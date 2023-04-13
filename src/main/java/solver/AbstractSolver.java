package solver;

import model.TestCase;
import model.TestCases;
import parser.Parser;
import problem.compare.Compare;
import problem.compare.impl.GenericCompare;
import problem.input.ProblemInput;
import problem.output.ProblemOutput;

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

        for (TestCase testCase : testCasesList) {
            O actual = this.solveProblem((I) testCase.getInput());
            O expected = (O) testCase.getOutput();

            if (!comparator.equal(expected.getValue(), actual.getValue())) {
                failedTestCases.add(testCase);
                assert (comparator.equal(expected.getValue(), actual.getValue()));
            }
        }

        return SolverOutput.builder().failedTestCases(failedTestCases).build();
    }

    protected abstract Parser getParser();

    protected abstract String getConfigFile();

    protected abstract Map<String, Compare> getCompareMap();

    protected abstract TestCases<I, O> getTestCases();

}
