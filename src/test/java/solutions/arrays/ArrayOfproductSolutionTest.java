package solutions.arrays;

import org.junit.jupiter.api.Test;

import common.TestUtil;
import problems.arrays.ArrayOfProductProblem;

public class ArrayOfproductSolutionTest {

    private final ArrayOfProductProblem problem = new ArrayOfProductProblem();
    private final ArrayOfProductSolution solution = new ArrayOfProductSolution();

    @Test
    public void testSolution() {
        TestUtil.runAssertions(problem, solution);
    }
}
