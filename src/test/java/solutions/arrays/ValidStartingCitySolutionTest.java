package solutions.arrays;

import org.junit.jupiter.api.Test;

import common.TestUtil;
import problems.arrays.ValidStartingCityProblem;

public class ValidStartingCitySolutionTest {
    private final ValidStartingCityProblem problem = new ValidStartingCityProblem();

    private final ValidStartingCitySolution solution = new ValidStartingCitySolution();

    @Test
    public void testSolution() {
        TestUtil.runAssertionsMultipleParams(problem, solution);
    }
}
