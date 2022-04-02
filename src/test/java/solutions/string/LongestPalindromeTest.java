package solutions.string;

import core.io.Output;
import core.TestCase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import problems.string.LongestPalindrome;

public class LongestPalindromeTest {

    private final LongestPalindrome longestPalindrome = new LongestPalindrome();
    private final LongestPalindromeDpSolution longestPalindromeDpSolution = new LongestPalindromeDpSolution();

    @Test
    public void longestPalindromeTest() {
        for(TestCase test: longestPalindrome.problem.getTestCases()) {
            Output op = longestPalindromeDpSolution.solve(test.getInputs().get(0));
            Assertions.assertThat(op.getOutput()).isEqualTo(
                test.getOutput().getOutput()
            );

        }

    }

}
