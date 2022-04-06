package problems.arrays;

import core.Problem;
import core.ProblemInterface;
import core.TestCase;
import core.io.Input;
import core.io.Output;

/**
 * <div class="html">
 * <p>
 *   Write a function that takes in an array of integers and returns a sorted
 *   version of that array. Use the Selection Sort algorithm to sort the array.
 * </p>
 * <p>
 *   If you're unfamiliar with Selection Sort, we recommend watching the Conceptual
 *   Overview section of this question's video explanation before starting to code.
 * </p>
 * <h3>Sample Input</h3>
 * <pre><span>array</span> = [8, 5, 2, 9, 5, 6, 3]
 * </pre>
 * <h3>Sample Output</h3>
 * <pre>[2, 3, 5, 5, 6, 8, 9]
 * </pre>
 * </div>
 */
public class SelectionSortProblem implements ProblemInterface {
    @Override
    public Problem getProblem() {
        return Problem.builder()
            .withTestCase(
                TestCase.builder()
                    .withInput(new Input<>(new int[] {8, 5, 2, 9, 5, 6, 3}))
                    .withOutput(new Output<>(new int[] {2, 3, 5, 5, 6, 8, 9}))
                    .build()

            )
            .withTestCase(
                TestCase.builder()
                    .withInput(new Input<>(new int[0]))
                    .withOutput(new Output<>(new int[0]))
                    .build()
            )
            .build();
    }
}
