package problems.arrays;

import core.Problem;
import core.ProblemInterface;
import core.TestCase;

/*
 * <div>
 * <p>
 *   Write a function that takes in a non-empty array of integers and returns an
 *   array of the same length, where each element in the output array is equal to
 *   the product of every other number in the input array.
 * </p>
 * <p>
 *   In other words, the value at <span>output[i]</span> is equal to the product of
 *  every number in the input array other than <span>input[i]</span>.
 * </p>
 * <p>Note that you're expected to solve this problem without using division.</p>
 * <h3>Sample Input</h3>
 * <pre><span class="">array</span> = [5, 1, 4, 2]
 * </pre>
 * <h3>Sample Output</h3>
 * <pre>[8, 40, 10, 20]
 * <span class="">// 8 is equal to 1 x 4 x 2</span>
 * <span class="">// 40 is equal to 5 x 4 x 2</span>
 * <span class="">// 10 is equal to 5 x 1 x 2</span>
 * <span class="">// 20 is equal to 5 x 1 x 4</span>
 * </pre>
 * </div>
 */
public class ArrayOfProductProblem implements ProblemInterface{

    @Override
    public Problem getProblem() {
        return Problem.builder()
        .withTestCase(
            TestCase.builder()
            .withInput(new int[]{5,1,4,2})
            .withOutput(new int[]{8,40,10,20})
            .build()
        )

        .build();
    }

}
