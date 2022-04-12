package problems.arrays;

import core.Problem;
import core.ProblemInterface;
import core.TestCase;

/**
 * <p>
 *   Write a function that takes in two non-empty arrays of integers, finds the
 *   pair of numbers (one from each array) whose absolute difference is closest to
 *   zero, and returns an array containing these two numbers, with the number from
 *   the first array in the first position.
 * </p>
 * <p>
 *   Note that the absolute difference of two integers is the distance between
 *   them on the real number line. For example, the absolute difference of -5 and 5
 *   is 10, and the absolute difference of -5 and -4 is 1.
 * </p>
 * <p>
 *   You can assume that there will only be one pair of numbers with the smallest
 *   difference.
 * </p>
 * <h3>Sample Input</h3>
 * <pre>
 * arrayOne = [-1, 5, 10, 20, 28, 3]
 * arrayTwo = [26, 134, 135, 15, 17]
 * </pre>
 * <h3>Sample Output</h3>
 * <pre>[28, 26]</pre>
 * </div>
 */
public class SmallestDifferenceProblem implements ProblemInterface {

    @Override
    public Problem getProblem() {
        return Problem.builder()
                .withTestCase(
                        TestCase.builder()
                                .withInput(new int[]{-1, 5, 10, 20, 28, 3})
                                .withInput(new int[]{26, 134, 135, 15, 17})
                                .withOutput(new int[]{28, 26})
                                .build()
                )
                .build();
    }
}
