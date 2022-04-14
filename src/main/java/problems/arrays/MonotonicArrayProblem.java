package problems.arrays;

import core.Problem;
import core.ProblemInterface;
import core.TestCase;

/**
 * <p>
 *   Write a function that takes in an array of integers and returns a boolean
 *   representing whether the array is monotonic.
 * </p>
 * <p>
 *   An array is said to be monotonic if its elements, from left to right, are
 *   entirely non-increasing or entirely non-decreasing.
 * </p>
 * <p>
 *   Non-increasing elements aren't necessarily exclusively decreasing; they simply
 *   don't increase. Similarly, non-decreasing elements aren't necessarily
 *   exclusively increasing; they simply don't decrease.
 * </p>
 * <p>Note that empty arrays and arrays of one element are monotonic.</p>
 * <h3>Sample Input</h3>
 * <pre><span>array</span> = [-1, -5, -10, -1100, -1100, -1101, -1102, -9001]
 * </pre>
 * <h3>Sample Output</h3>
 * <pre>true
 * </pre>
 */
public class MonotonicArrayProblem implements ProblemInterface {
    @Override
    public Problem getProblem() {
        return Problem.builder()
                .withTestCase(
                        TestCase.builder()
                                .withInput(new int[] {-1, -5, -10, -1100, -1100, -1101, -1102, -9001})
                                .withOutput(true)
                                .build()
                )
                .withTestCase(
                        TestCase.builder()
                                .withInput(new int[]{1, 5, 10, 1100, 1101, 1102, 9001})
                                .withOutput(true)
                                .build()
                )
                .withTestCase(
                        TestCase.builder()
                                .withInput(new int[]{-1, -5, -10, -1100, -900, -1101, -1102, -9001})
                                .withOutput(false)
                                .build()
                )
                .withTestCase(
                        TestCase.builder()
                                .withInput(new int[]{1, 2, 0})
                                .withOutput(false)
                                .build()
                )
                .build();
    }
}
