package solutions.string;

import org.junit.jupiter.api.Test;

import common.TestUtil;
import problems.string.LongestPalindrome;

public class LongestPalindromeTest {

    private final LongestPalindrome longestPalindrome = new LongestPalindrome();
    private final LongestPalindromeDpSolution longestPalindromeDpSolution = new LongestPalindromeDpSolution();

    @Test
    public void longestPalindromeTest() {
        TestUtil.runAssertions(longestPalindrome, longestPalindromeDpSolution);

    }

}
