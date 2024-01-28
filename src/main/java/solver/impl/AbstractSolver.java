package solver.impl;

import model.solver.SolverOutput;
import model.testcase.TestCase;
import model.testcase.TestCases;
import parser.Parser;
import compare.Compare;
import compare.impl.GenericCompare;
import model.io.ProblemInput;
import problem.output.ProblemOutput;
import solver.Solver;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractSolver<I extends ProblemInput, O extends ProblemOutput>
        implements Solver<I, O> {

    public SolverOutput solve() {

        TestCases<I, O> jsonObj = getTestCases();

        TestCase[] testCasesList = jsonObj.getTestCases();

        List<TestCase> failedTestCases = new ArrayList<>();

        Compare comparator =
                getCompareMap().getOrDefault(jsonObj.getComparator(), new GenericCompare());

        System.out.println("Begin test cases for " + this.getClass().getSimpleName());
        for (TestCase testCase : testCasesList) {
            System.out.println("Executing test case: " + testCase.toString());
            long start = System.nanoTime();
            O actual = this.solveProblem((I) testCase.getInput());
            long stop = System.nanoTime();
            NumberFormat formatter = new DecimalFormat("#0.00000");
            System.out.println("Execution time is " + formatter.format(stop - start) + " seconds");

            O expected = (O) testCase.getOutput();

            if (!comparator.equal(expected.getValue(), actual.getValue())) {
                System.out.println("Test case failed:");
                System.out.printf("test case: %s%n", testCase);
                System.out.printf("expected = %s , actual = %s%n", expected,
                        actual);
                failedTestCases.add(testCase);
            }
        }
        System.out.println("End test cases for " + this.getClass().getSimpleName());
        System.out.println("\n");

        if (failedTestCases.size() > 0) {
            throw new AssertionError(String.format("Some testcases failed: %s", failedTestCases));
        }
        return SolverOutput.builder().failedTestCases(failedTestCases).build();
    }

    protected abstract Parser getParser();

    protected abstract String getConfigFile();

    protected abstract Map<String, Compare> getCompareMap();

    protected abstract TestCases<I, O> getTestCases();

}
