package problems.arrays;


import core.Problem;
import core.ProblemInterface;
import core.TestCase;
import core.io.Input;
import core.io.Output;

/**
 * <p>
 * Write a function that takes in an array of integers and returns the length of
 * the longest peak in the array.
 * </p>
 * <p>
 * A peak is defined as adjacent integers in the array that are <b>strictly</b>
 * increasing until they reach a tip (the highest value in the peak), at which
 * point they become <b>strictly</b> decreasing. At least three integers are required to
 * form a peak.
 * </p>
 * <p>
 * For example, the integers <span>1, 4, 10, 2</span> form a peak, but the
 * integers 4, 0, 10 don't and neither do the integers
 * 1, 2, 2, 0. Similarly, the integers <span>1, 2, 3</span> don't
 * form a peak because there aren't any strictly decreasing integers after the
 * </p>
 * <h3>Sample Input</h3>
 * <pre><span>array</span> = [1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3]
 * </pre>
 * <h3>Sample Output</h3>
 * <pre>6 <span>0, 10, 6, 5, -1, -3</span>
 * </pre>1
 * </div></div>
 */
public class LongestPeakProblem implements ProblemInterface{

    @Override
    public Problem getProblem() {
        return Problem.builder()
            .withTestCase(
                TestCase.builder()
                .withInput(new Input<>(new int[]{1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3}))
                .withOutput(new Output<>(6))
                .build()
            )
            .withTestCase(
                TestCase.builder()
                .withInput(new Input<>(new int[]{1, 1, 3, 2, 1}))
                .withOutput(new Output<>(4))
                .build()
            )
            .build();
    }

}
