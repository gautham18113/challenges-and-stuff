package solutions.arrays;

import common.TestUtil;
import core.TestCase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import problems.arrays.MinimumWaitingTimeProblem;

public class MinimumWaitingTimeSolutionTest {

    private final MinimumWaitingTimeProblem minimumWaitingTimeProblem = new MinimumWaitingTimeProblem();
    private final MinimumWaitingTimeSolution minimumWaitingTimeSolution = new MinimumWaitingTimeSolution();

    @Test
    public void testMinimumWaitingTime() {
        TestUtil.runAssertions(minimumWaitingTimeProblem, minimumWaitingTimeSolution);
    }
}
