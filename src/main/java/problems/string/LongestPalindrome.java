package problems.string;

import core.io.Input;
import core.io.Output;
import core.Problem;
import core.TestCase;

import java.util.Arrays;

public class LongestPalindrome {
    public Problem problem;
    /**
     *
     * Given a string s, return the longest palindromic substring in s.
     *
     * Constraints:
     * 1 <= s.length <= 1000
     * s consist of only digits and English letters.
     *
     * Example 1:
     *
     * Input: s = "babad"
     * Output: "bab"
     * Explanation: "aba" is also a valid answer.
     *
     * Example 2:
     *
     * Input: s = "cbbd"
     * Output: "bb"
     *
     */
    public LongestPalindrome() {
        problem = Problem.builder().withTestCaseList(
            Arrays.asList(
                TestCase.builder()
                    .withInput(new Input<>("cbbd"))
                    .withOutput(new Output<>("bb"))
                    .build(),
                TestCase.builder()
                    .withInput(new Input<>("character"))
                    .withOutput(new Output<>("ara"))
                    .build(),
                TestCase.builder()
                    .withInput(new Input<>(""))
                    .withOutput(new Output<>(""))
                    .build(),
                TestCase.builder()
                    .withInput(new Input<>("a"))
                    .withOutput(new Output<>("a"))
                    .build()
                )
                )
            .build();
    }
}
