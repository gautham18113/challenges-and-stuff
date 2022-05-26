package problems.string;

import core.io.Input;
import core.io.Output;
import core.Problem;
import core.ProblemInterface;
import core.TestCase;

public class LongestPalindrome implements ProblemInterface {
    public Problem problem;

    /**
     *
     * <div>
     * <p>
     * Given a string <code>s</code> which consists of lowercase or uppercase
     * letters, return <em>the length of the <strong>longest
     * palindrome</strong></em>&nbsp;that can be built with those letters.
     * </p>
     *
     * <p>
     * Letters are <strong>case sensitive</strong>, for
     * example,&nbsp;<code>"Aa"</code> is not considered a palindrome here.
     * </p>
     *
     * <p>
     * &nbsp;
     * </p>
     * <p>
     * <strong>Example 1:</strong>
     * </p>
     *
     * <pre>
     * <strong>Input:</strong> s = "abccccdd"
     * <strong>Output:</strong> 7
     * <strong>Explanation:</strong>
     * One longest palindrome that can be built is "dccaccd", whose length is 7.
     * </pre>
     *
     * <p>
     * <strong>Example 2:</strong>
     * </p>
     *
     * <pre>
     * <strong>Input:</strong> s = "a"
     * <strong>Output:</strong> 1
     * </pre>
     *
     * <p>
     * <strong>Example 3:</strong>
     * </p>
     *
     * <pre>
     * <strong>Input:</strong> s = "bb"
     * <strong>Output:</strong> 2
     * </pre>
     *
     * <p>
     * &nbsp;
     * </p>
     * <p>
     * <strong>Constraints:</strong>
     * </p>
     *
     * <ul>
     * <li><code>1 &lt;= s.length &lt;= 2000</code></li>
     * <li><code>s</code> consists of lowercase <strong>and/or</strong> uppercase
     * English&nbsp;letters only.</li>
     * </ul>
     * </div>
     */
    @Override
    public Problem getProblem() {
        return Problem.builder()
                .withTestCase(TestCase.builder().withInput(new Input<>("cbbd")).withOutput(new Output<>("bb")).build())
                .withTestCase(
                        TestCase.builder().withInput(new Input<>("character")).withOutput(new Output<>("ara")).build())
                .withTestCase(TestCase.builder().withInput(new Input<>("")).withOutput(new Output<>("")).build())
                .withTestCase(TestCase.builder().withInput(new Input<>("a")).withOutput(new Output<>("a")).build())
                .build();
    }
}
