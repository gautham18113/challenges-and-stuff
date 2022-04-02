package solutions.arrays;

import core.TestCase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import problems.arrays.MinimumWaitingTimeProblem;

public class MinimumWaitingTimeSolutionTest {

    private final MinimumWaitingTimeProblem minimumWaitingTimeProblem = new MinimumWaitingTimeProblem();
    private final MinimumWaitingTimeSolution minimumWaitingTimeSolution = new MinimumWaitingTimeSolution();

    @Test
    public void testMinimumWaitingTime() {

        for(TestCase testCase: minimumWaitingTimeProblem.problem.getTestCases()) {

            Assertions
                .assertThat(minimumWaitingTimeSolution.solve(testCase.getInputs().get(0)).getOutput())
                .isEqualTo(testCase.getOutput().getOutput());
        }
    }
}
