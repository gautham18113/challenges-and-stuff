package solutions.graphs;

import org.junit.jupiter.api.Test;

import common.TestUtil;
import problems.graphs.MinimumPassesOfMatrixProblem;

public class MinimumPassesOfMatrixSolutionTest {

    private final MinimumPassesOfMatrixProblem problem = new MinimumPassesOfMatrixProblem();
    private final MinimumPassesOfmatrixSolution solution = new MinimumPassesOfmatrixSolution();

    @Test
    public void testSolution() {
        TestUtil.runAssertions(problem, solution);
    }

}
