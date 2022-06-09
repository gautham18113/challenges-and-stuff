package solutions.arrays;

import org.junit.jupiter.api.Test;

import common.TestUtil;
import problems.arrays.FirstDuplicateValueProblem;

public class FirstDuplicateValueSolutionTest {

    private final FirstDuplicateValueProblem problem = new FirstDuplicateValueProblem();
    private final FirstDuplicateValueSolution solution = new FirstDuplicateValueSolution();

    @Test
    public void testSolution() {
        TestUtil.runAssertions(problem, solution);
    }

}
