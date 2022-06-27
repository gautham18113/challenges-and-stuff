package solutions.graphs.binarytree;

import org.junit.jupiter.api.Test;

import common.TestUtil;
import problems.graphs.binarytree.HeightBalancedBinaryTreeProblem;

public class HeightBalancedBinaryTreeSolutionTest {

    private final HeightBalancedBinaryTreeProblem problem = new HeightBalancedBinaryTreeProblem();
    private final HeightBalancedBinaryTreeSolution solution = new HeightBalancedBinaryTreeSolution();

    @Test
    public void testSolution() {
        TestUtil.runAssertions(problem, solution);
    }
}
