package solver;

import com.google.common.reflect.TypeToken;
import model.TestCase;
import model.TestCases;
import parser.Parser;
import problem.compare.Compare;
import problem.input.ProblemInput;
import problem.input.impl.FloodFillInput;
import problem.output.FloodFillOutput;
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

        Compare comparator = getCompareMap().get(jsonObj.getComparator());

        for (TestCase testCase: testCasesList) {
            O actual = this.solveProblem(
                    (I) testCase.getInput(),
                    (O) testCase.getOutput());
            O expected = (O) testCase.getOutput();

            if (!comparator.equal(expected.getOp(), actual.getOp())) {
                failedTestCases.add(testCase);
                assert(comparator.equal(expected.getOp(), actual.getOp()));
            }
        }

        return SolverOutput.builder().failedTestCases(failedTestCases).build();
    }

    protected abstract Parser getParser();

    protected abstract String getConfigFile();

    protected abstract Map<String, Compare> getCompareMap();

    protected abstract TestCases<I, O> getTestCases();

}
