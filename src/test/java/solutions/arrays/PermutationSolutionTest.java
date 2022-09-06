package solutions.arrays;

import org.junit.jupiter.api.Test;

import common.TestUtil;
import problems.arrays.PermutationProblem;

public class PermutationSolutionTest {

    private final PermutationProblem problem = new PermutationProblem();
    private final PermutationSolution solution = new PermutationSolution();

    @Test
    public void test() {
        TestUtil.runAssertions(problem, solution);
    }
}
