package solutions.graphs.binarytree;

import org.junit.jupiter.api.Test;

import common.TestUtil;
import problems.graphs.binarytree.FindKthLargestInBSTProblem;

public class FindKthLargestInBSTSolutionTest {

    private final FindKthLargestInBSTProblem problem = new FindKthLargestInBSTProblem();
    private final FindKthLargetsInBSTSolution solution = new FindKthLargetsInBSTSolution();

    @Test
    public void testSolution() {
        TestUtil.runAssertionsMultipleParams(problem, solution);
    }
}
