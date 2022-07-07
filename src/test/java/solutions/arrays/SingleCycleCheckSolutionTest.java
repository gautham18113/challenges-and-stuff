package solutions.arrays;

import org.junit.jupiter.api.Test;

import common.TestUtil;
import problems.arrays.SingleCycleCheckProblem;

public class SingleCycleCheckSolutionTest {

    private final SingleCycleCheckSolution solution = new SingleCycleCheckSolution();
    private final SingleCycleCheckProblem problem = new SingleCycleCheckProblem();

    @Test
    public void testSolution() {
        TestUtil.runAssertions(problem, solution);
    }

}
