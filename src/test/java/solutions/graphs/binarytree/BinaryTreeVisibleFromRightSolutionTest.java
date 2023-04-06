package solutions.graphs.binarytree;

import common.TestUtil;
import org.junit.jupiter.api.Test;
import problems.graphs.binarytree.BinaryTreeVisibleFromRightProblem;

public class BinaryTreeVisibleFromRightSolutionTest {

    BinaryTreeVisibleFromRightSolution solution = new BinaryTreeVisibleFromRightSolution();
    BinaryTreeVisibleFromRightProblem problem = new BinaryTreeVisibleFromRightProblem();

    @Test
    public void testBinaryTreeVisibleFromRight() {
        TestUtil.runAssertions(problem, solution);
    }
}
