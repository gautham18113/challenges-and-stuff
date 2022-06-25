package solutions.graphs.binarytree;

import org.junit.jupiter.api.Test;

import common.TestUtil;
import problems.graphs.binarytree.FindSuccessorProblem;

public class FindSuccessorSolutionTest {

    private final FindSuccessorProblem problem = new FindSuccessorProblem();
    private final FindSuccessorSolution solution = new FindSuccessorSolution();

    @Test
    public void testSolution() {
        TestUtil.runAssertionsMultipleParams(problem, solution);
    }

}
