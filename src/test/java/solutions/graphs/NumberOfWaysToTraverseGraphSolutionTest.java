package solutions.graphs;

import org.junit.jupiter.api.Test;

import common.TestUtil;
import problems.graphs.NumberOfWaysToTraverseGraphProblem;

public class NumberOfWaysToTraverseGraphSolutionTest {
    private static final NumberOfWaysToTraverseGraphProblem problem = new NumberOfWaysToTraverseGraphProblem();
    private static final NumberOfWaysToTraverseGraphSolution solution = new NumberOfWaysToTraverseGraphSolution();

    @Test
    public void testSolution() {
        TestUtil.runAssertionsMultipleParams(problem, solution);
    }
}
