package solutions.graphs.binarytree;

import common.TestUtil;
import org.junit.jupiter.api.Test;
import problems.graphs.binarytree.BinaryTreeLevelOrderTraversalProblem;

public class BinaryTreeLevelOrderTraversalSolutionTest{

    private final BinaryTreeLevelOrderTraversalSolution solution = new BinaryTreeLevelOrderTraversalSolution();
    private final BinaryTreeLevelOrderTraversalProblem problem = new BinaryTreeLevelOrderTraversalProblem();

    @Test
    public void testBinaryTreeLevelOrderTraversal() {
        TestUtil.runAssertions(problem, solution);
    }

}
