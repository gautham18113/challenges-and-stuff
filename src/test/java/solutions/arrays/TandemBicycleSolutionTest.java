package solutions.arrays;

import common.TestUtil;
import org.junit.jupiter.api.Test;
import problems.arrays.TandemBicycleProblem;

class TandemBicycleSolutionTest {
    private final TandemBicycleSolution tandemBicycleSolution = new TandemBicycleSolution();
    private final TandemBicycleProblem tandemBicycleProblem = new TandemBicycleProblem();

    @Test
    void testSolve() {
        TestUtil.runAssertionsMultipleParams(tandemBicycleProblem, tandemBicycleSolution);
    }
}
