package solutions.graphs;

import common.TestUtil;
import org.junit.jupiter.api.Test;
import problems.graphs.ShortestPathBetweenNodesProblem;

public class ShortestPathBetweenNodesSolutionTest {

    ShortestPathBetweenNodesProblem problem = new ShortestPathBetweenNodesProblem();
    ShortestPathBetweenNodesSolution solution = new ShortestPathBetweenNodesSolution();

    @Test
    public void testShortestPathBetweenNodes() {
        TestUtil.runAssertionsMultipleParams(problem, solution);
    }
}
