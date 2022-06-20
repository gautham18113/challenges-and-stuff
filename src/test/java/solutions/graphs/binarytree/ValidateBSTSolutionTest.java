package solutions.graphs.binarytree;

import org.junit.jupiter.api.Test;

import common.TestUtil;
import problems.graphs.binarytree.ValidateBSTProblem;

public class ValidateBSTSolutionTest {

    private final ValidateBSTProblem problem = new ValidateBSTProblem();
    private final ValidateBSTSolution solution = new ValidateBSTSolution();

    @Test
    public void testSolution() {
        TestUtil.runAssertions(problem, solution);
    }
}
