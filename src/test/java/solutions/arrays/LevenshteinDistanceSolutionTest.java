package solutions.arrays;

import org.junit.jupiter.api.Test;

import common.TestUtil;
import problems.string.LevenshteinDistanceProblem;
import solutions.string.LevenshteinDistanceSolution;

public class LevenshteinDistanceSolutionTest {

    private final LevenshteinDistanceProblem problem = new LevenshteinDistanceProblem();
    private final LevenshteinDistanceSolution solution = new LevenshteinDistanceSolution();

    @Test
    public void testSolution() {
        TestUtil.runAssertionsMultipleParams(problem, solution);
    }
}
