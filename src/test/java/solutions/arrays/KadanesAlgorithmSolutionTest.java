package solutions.arrays;

import org.junit.jupiter.api.Test;

import common.TestUtil;
import problems.arrays.KadanesAlgorithmProblem;

public class KadanesAlgorithmSolutionTest {

    private final KadanesAlgorithmSolution solution = new KadanesAlgorithmSolution();
    private final KadanesAlgorithmProblem problem = new KadanesAlgorithmProblem();

    @Test
    public void testSolution() {
        TestUtil.runAssertions(problem, solution);
    }

}
