package problems.general;

import core.Problem;
import core.ProblemInterface;
import core.TestCase;
import core.io.Input;
import core.io.Output;

/**
 * <div class="html">
 * <p>
 *   Given a non-empty string of lowercase letters and a non-negative integer
 *   representing a key, write a function that returns a new string obtained by
 *   shifting every letter in the input string by k positions in the alphabet,
 *   where k is the key.
 * </p>
 * <p>
 *   Note that letters should "wrap" around the alphabet; in other words, the
 *   letter z shifted by one returns the letter <span>a</span>.
 * </p>
 * <h3>Sample Input</h3>
 * <pre><span>string</span> = "xyz"
 * <span>key</span> = 2
 * </pre>
 * <h3>Sample Output</h3>
 * <pre>"zab"
 * </pre>
 * </div>
 */
public class CaesarCypherEncryptorProblem implements ProblemInterface {
    @Override
    public Problem getProblem() {
        return Problem.builder()
            .withTestCase(
                TestCase.builder()
                    .withInput(new Input<>("xyz"))
                    .withInput(new Input<>(2))
                    .withOutput(new Output<>("zab"))
                    .build()
            )
            .withTestCase(
                TestCase.builder()
                    .withInput(new Input<>("xyz"))
                    .withInput(new Input<>(0))
                    .withOutput(new Output<>("xyz"))
                    .build()
            )
            .build();
    }
}
