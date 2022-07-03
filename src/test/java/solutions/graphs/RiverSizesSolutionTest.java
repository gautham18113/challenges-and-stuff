package solutions.graphs;

import org.junit.jupiter.api.Test;

import common.TestUtil;
import problems.graphs.RiverSizesProblem;

public class RiverSizesSolutionTest {

    private final RiverSizesProblem problem = new RiverSizesProblem();
    private final RiverSizesSolution solution = new RiverSizesSolution();

    @Test
    public void testSolution() {
        TestUtil.runAssertions(problem, solution);
    }
}
