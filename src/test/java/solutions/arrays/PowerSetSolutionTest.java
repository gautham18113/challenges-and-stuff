package solutions.arrays;

import org.junit.jupiter.api.Test;

import common.TestUtil;
import problems.arrays.PowerSetProblem;

public class PowerSetSolutionTest {

    private PowerSetProblem problem = new PowerSetProblem();

    private PowerSetSolution solution = new PowerSetSolution();

    @Test
    public void test() {
        TestUtil.runAssertions(problem, solution);
    }
}
