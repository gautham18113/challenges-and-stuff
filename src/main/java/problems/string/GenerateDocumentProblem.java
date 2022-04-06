package problems.string;

import core.Problem;
import core.ProblemInterface;
import core.TestCase;
import core.io.Input;
import core.io.Output;

/**
 * <div class="html">
 * <p>
 *   You're given a string of available characters and a string representing a
 *   document that you need to generate. Write a function that determines if you
 *   can generate the document using the available characters. If you can generate
 *   the document, your function should return <span>true</span>; otherwise, it
 *   should return <span>false</span>.
 * </p>
 * <p>
 *   You're only able to generate the document if the frequency of unique
 *   characters in the characters string is greater than or equal to the frequency
 *   of unique characters in the document string. For example, if you're given
 *   <span>characters = "abcabc"</span> and <span>document = "aabbccc"</span> you
 *   <b>cannot</b> generate the document because you're missing one <span>c</span>.
 * </p>
 * <p>
 *   The document that you need to create may contain any characters, including
 *   special characters, capital letters, numbers, and spaces.
 * </p>
 * <p>Note: you can always generate the empty string (<span>""</span>).</p>
 * <h3>Sample Input</h3>
 * <pre><span>characters</span> = "Bste!hetsi ogEAxpelrt x "
 * <span>document</span> = "AlgoExpert is the Best!"
 * </pre>
 * <h3>Sample Output</h3>
 * <pre>true
 * </pre>
 * </div>
 */
public class GenerateDocumentProblem implements ProblemInterface {
    @Override
    public Problem getProblem() {
        return Problem.builder()
            .withTestCase(
                TestCase.builder()
                    .withInput(new Input<>("Bste!hetsi ogEAxpelrt x "))
                    .withInput(new Input<>("AlgoExpert is the Best!"))
                    .withOutput(new Output<>(true))
                    .build()
            )
            .withTestCase(
                TestCase.builder()
                    .withInput(new Input<>("abcabc"))
                    .withInput(new Input<>("aabbccc"))
                    .withOutput(new Output<>(false))
                    .build()
            )
            .build();
    }
}
