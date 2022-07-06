package solutions.graphs;

import org.junit.jupiter.api.Test;

import common.TestUtil;
import problems.graphs.YoungestCommonAncestorProblem;

public class YoungestCommonAncestorSolutionTest {

    private final YoungestCommonAncestorSolution solution = new YoungestCommonAncestorSolution();

    private final YoungestCommonAncestorProblem problem = new YoungestCommonAncestorProblem();

    @Test
    public void testSolution() {

        TestUtil.runAssertionsMultipleParams(problem, solution);

    }

}
