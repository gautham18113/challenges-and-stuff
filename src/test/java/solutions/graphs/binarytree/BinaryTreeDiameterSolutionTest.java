package solutions.graphs.binarytree;

import org.junit.jupiter.api.Test;

import common.TestUtil;
import problems.graphs.binarytree.BinaryTreeDiameterProblem;

public class BinaryTreeDiameterSolutionTest {

    private final BinaryTreeDiameterSolution solution = new BinaryTreeDiameterSolution();
    private final BinaryTreeDiameterProblem problem = new BinaryTreeDiameterProblem();

    @Test
    public void testSolution() {
        TestUtil.runAssertions(problem, solution);
    }
}
