package solutions.graphs.binarytree;

import org.junit.jupiter.api.Test;

import common.TestUtil;
import problems.graphs.binarytree.ReconstructBSTProblem;

public class ReconstructBSTSolutionTest {

    private final ReconstructBSTProblem problem = new ReconstructBSTProblem();
    private final ReconstructBSTSolution solution = new ReconstructBSTSolution();

    @Test
    public void testSolution() {
        TestUtil.runAssertions(problem, solution);
    }

}
