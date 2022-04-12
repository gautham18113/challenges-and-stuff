package problems.arrays;

import core.Problem;
import core.ProblemInterface;
import core.TestCase;

/**
 * <div class="html">
 * <p>
 *   You're given an array of integers and an integer. Write a function that moves
 *   all instances of that integer in the array to the end of the array and returns
 *   the array.
 * </p>
 * <p>
 *   The function should perform this in place (i.e., it should mutate the input
 *   array) and doesn't need to maintain the order of the other integers.
 * </p>
 * <h3>Sample Input</h3>
 * <pre><span>array</span> = [2, 1, 2, 2, 2, 3, 4, 2]
 * <span>toMove</span> = 2
 * </pre>
 * <h3>Sample Output</h3>
 * <pre>[1, 3, 4, 2, 2, 2, 2, 2] <span>// the numbers 1, 3, and 4 could be ordered differently</span>
 * </pre>
 * </div>
 */
public class MoveElementToEndProblem implements ProblemInterface {


    @Override
    public Problem getProblem() {
        return Problem.builder()
                .withTestCase(
                        TestCase.builder()
                                .withInput(new int[]{2, 1, 2, 2, 2, 3, 4, 2})
                                .withInput(2)
                                .withOutput(new int[]{4,1,3,2,2,2,2,2})
                                .build()
                )
                .build();
    }
}
