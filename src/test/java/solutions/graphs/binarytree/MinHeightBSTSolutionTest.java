package solutions.graphs.binarytree;

import org.junit.jupiter.api.Test;

import common.TestUtil;
import problems.graphs.binarytree.MinHeightBSTProblem;

public class MinHeightBSTSolutionTest {

    private final MinHeightBSTProblem problem = new MinHeightBSTProblem();
    private final MinHeightBSTSolution solution = new MinHeightBSTSolution();

    @Test
    public void testSolution() {
        TestUtil.runAssertions(problem, solution);
    }
}
