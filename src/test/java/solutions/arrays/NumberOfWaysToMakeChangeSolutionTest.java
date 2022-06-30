package solutions.arrays;

import org.junit.jupiter.api.Test;

import common.TestUtil;
import problems.arrays.NumberOfWaysToMakeChangeProblem;

public class NumberOfWaysToMakeChangeSolutionTest {

    private final NumberOfWaysToMakeChangeSolution solution = new NumberOfWaysToMakeChangeSolution();
    private final NumberOfWaysToMakeChangeProblem problem = new NumberOfWaysToMakeChangeProblem();

    @Test
    public void testSolution() {
        TestUtil.runAssertionsMultipleParams(problem, solution);
    }
}
