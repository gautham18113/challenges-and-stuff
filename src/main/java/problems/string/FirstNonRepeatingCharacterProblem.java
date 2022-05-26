package problems.string;

import core.Problem;
import core.ProblemInterface;
import core.TestCase;

/**
 * <div class="_3ujpThEtqc2woOs6g2RNC2 ae-workspace-dark"><div class="html">
 * <p>
 *   Write a function that takes in a string of lowercase English-alphabet letters
 *   and returns the index of the string's first non-repeating character.
 * </p>
 * <p>
 *   The first non-repeating character is the first character in a string that
 *   occurs only once.
 * </p>
 * <p>
 *   If the input string doesn't have any non-repeating characters, your function
 *   should return <span>-1</span>.
 * </p>
 * <h3>Sample Input</h3>
 * <pre><span>string</span> = "abcdcaf"
 * </pre>
 * <h3>Sample Output</h3>
 * <pre>1 <span>// The first non-repeating character is "b" and is found at index 1.</span>
 * </pre>
 * </div></div>
 */
public class FirstNonRepeatingCharacterProblem implements ProblemInterface {
    @Override
    public Problem getProblem() {
        return Problem.builder()
            .withTestCase(
                TestCase.builder()
                    .withInput("abcdcaf")
                    .withOutput(1)
                    .build()
            )
            .build();
    }
}
