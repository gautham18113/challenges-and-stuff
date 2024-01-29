package solver.impl;

import com.google.common.reflect.TypeToken;
import model.solver.SolverOutput;
import model.testcase.TestCase;
import model.testcase.TestCases;
import parser.Parser;
import compare.Compare;
import compare.impl.GenericCompare;
import model.io.ProblemInput;
import parser.impl.JsonParser;
import problem.output.ProblemOutput;
import solver.Solver;
import solver.input.GenericInput;
import solver.output.GenericOutput;

import javax.inject.Inject;
import javax.inject.Named;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractSolver  {
    private String fileName;
    private Map<String, Compare> compareMap;
    public AbstractSolver(
            String fileName,
            Map<String, Compare> compareMap) {
        this.fileName=fileName;
        this.compareMap=compareMap;
    }

    protected abstract Object solve(Object input);

    public SolverOutput solve() {

        TestCases jsonObj = (TestCases) getTestCases();

        TestCase[] testCasesList = jsonObj.getTestCases();

        List<TestCase> failedTestCases = new ArrayList<>();

        Compare comparator =
                getCompareMap().getOrDefault(jsonObj.getComparator(), new GenericCompare());

        System.out.println("Begin test cases for " + this.getClass().getSimpleName());
        for (TestCase testCase : testCasesList) {
            System.out.println("Executing test case: " + testCase.toString());
            long start = System.nanoTime();
            GenericOutput actual = (GenericOutput) this.solve(testCase.getInput());
            long stop = System.nanoTime();
            NumberFormat formatter = new DecimalFormat("#0.00000");
            System.out.println("Execution time is " + formatter.format(stop - start) + " nano seconds");

            GenericOutput expected = (GenericOutput) testCase.getOutput();

            expected.toString();
            actual.toString();

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

        if (!failedTestCases.isEmpty()) {
            throw new AssertionError(String.format("Some testcases failed: %s", failedTestCases));
        }
        return SolverOutput.builder().build();
    }

    protected String getConfigFile() {
        return fileName;
    };

    protected Map<String, Compare> getCompareMap() {

        return this.compareMap;
    }

    protected Object getTestCases(){
        return new JsonParser<>().parse(getConfigFile(), getType());
    };

    protected abstract Type getType();

}
