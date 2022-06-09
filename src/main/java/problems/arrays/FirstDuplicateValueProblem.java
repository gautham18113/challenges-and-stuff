package problems.arrays;

import core.Problem;
import core.ProblemInterface;
import core.TestCase;

/**
 * <div class="html">
 * <p>
 *   Given an array of integers between <span>1</span> and <span>n</span>,
 *   inclusive, where <span>n</span> is the length of the array, write a function
 *   that returns the first integer that appears more than once (when the array is
 *   read from left to right).
 * </p>
 * <p>
 *   In other words, out of all the integers that might occur more than once in the
 *   input array, your function should return the one whose first duplicate value
 *   has the minimum index.
 * </p>
 * <p>
 *   If no integer appears more than once, your function should return
 *   <span>-1</span>.
 * </p>
 * <p>Note that you're allowed to mutate the input array.</p>
 * <h3>Sample Input #1</h3>
 * <pre><span class="">array</span> = [2, 1, 5, 2, 3, 3, 4]
 * </pre>
 * <h3>Sample Output #1</h3>
 * <pre>2 <span class="">// 2 is the first integer that appears more than once.</span>
 * <span class="">// 3 also appears more than once, but the second 3 appears after the second 2.</span>
 * </pre>
 * <h3>Sample Input #2</h3>
 * <pre><span class="">array</span> = [2, 1, 5, 3, 3, 2, 4]
 * </pre>
 * <h3>Sample Output #2</h3>
 * <pre>3 <span class="">// 3 is the first integer that appears more than once.</span>
 * <span class="">// 2 also appears more than once, but the second 2 appears after the second 3.</span>
 * </pre>
 * </div></div>
 */
public class FirstDuplicateValueProblem implements ProblemInterface{

    @Override
    public Problem getProblem() {
        return Problem.builder()
        .withTestCase(
            TestCase.builder()
            .withInput(new int[]{19, 4, 1, 6, 2, 5, 20, 13, 8, 6, 11, 12, 12, 12, 11, 18, 7, 13, 6, 10})
            .withOutput(6)
            .build()
        )
        .withTestCase(
            TestCase.builder()
            .withInput(new int[]{2,1,5,2,3,3,4})
            .withOutput(2)
            .build()
        )
        .withTestCase(
            TestCase.builder()
            .withInput(new int[]{2,1,5,3,3,3,4})
            .withOutput(3)
            .build()
        )
        .withTestCase(
            TestCase.builder()
            .withInput(new int[]{1,1,2,3,3,2,2})
            .withOutput(1)
            .build()
        )
        .build();
    }

}
