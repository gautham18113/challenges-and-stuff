package solutions.graphs;

import org.junit.jupiter.api.Test;

import common.TestUtil;
import problems.graphs.CycleInGraphProblem;

public class CycleInGraphSolutionTest {

    private final CycleInGraphSolution solution = new CycleInGraphSolution();
    private final CycleInGraphProblem problem = new CycleInGraphProblem();

    @Test
    public void testSolution() {
        TestUtil.runAssertions(problem, solution);
    }
}
