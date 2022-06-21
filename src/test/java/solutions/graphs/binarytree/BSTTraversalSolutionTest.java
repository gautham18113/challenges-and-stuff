package solutions.graphs.binarytree;

import org.junit.jupiter.api.Test;

import common.TestUtil;
import problems.graphs.binarytree.BSTTraversalProblem;

public class BSTTraversalSolutionTest {
    private final BSTTraversalProblem problem = new BSTTraversalProblem();
    private final BSTTraversalSolution solution = new BSTTraversalSolution();

    @Test
    public void testSolution() {
        TestUtil.runAssertions(problem, solution);
    }

}
