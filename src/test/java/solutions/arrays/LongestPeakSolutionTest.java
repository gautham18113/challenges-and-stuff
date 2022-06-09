package solutions.arrays;

import org.junit.jupiter.api.Test;

import common.TestUtil;
import problems.arrays.LongestPeakProblem;

public class LongestPeakSolutionTest {

    private LongestPeakProblem longestPeakProblem = new LongestPeakProblem();
    private LongestPeakSolution longestPeakSolution = new LongestPeakSolution();

    @Test
    public void testSolution() {
        TestUtil.runAssertions(longestPeakProblem, longestPeakSolution);
    }
}
