package solutions.graphs;

import problems.graphs.RemoveIslandsProblem;

import org.junit.jupiter.api.Test;

import common.TestUtil;

public class RemoveIslandsSolutionTest {

    private final RemoveIslandsProblem problem = new RemoveIslandsProblem();
    private final RemoveIslandsSolution solution = new RemoveIslandsSolution();

    @Test
    public void testSolution() {
        TestUtil.runAssertions(problem, solution);
    }

}
