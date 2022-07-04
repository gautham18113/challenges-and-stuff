package solutions.arrays;

import org.junit.jupiter.api.Test;

import common.TestUtil;
import problems.arrays.MinNumberOfCoinsForChangeProblem;

public class MinimumNumberOfCoinsForChangeSolutionTest {

    private final MinNumberOfCoinsForChangeProblem problem = new MinNumberOfCoinsForChangeProblem();
    private final MinNumberOfCoinsForChangeSolution solution = new MinNumberOfCoinsForChangeSolution();

    @Test
    public void testSolution() {
        TestUtil.runAssertionsMultipleParams(problem, solution);
    }
}
