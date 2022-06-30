package problems.arrays;

import core.Problem;
import core.ProblemInterface;
import core.TestCase;

public class KadanesAlgorithmProblem implements ProblemInterface{

    /**
     * <div class="html">
     * <p>
     *   Write a function that takes in a non-empty array of integers and returns the
     *   maximum sum that can be obtained by summing up all of the integers in a
     *   non-empty subarray of the input array. A subarray must only contain adjacent
     *   numbers (numbers next to each other in the input array).
     * </p>
     * <h3>Sample Input</h3>
     * <pre><span >array</span> = [3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4]
     * </pre>
     * <h3>Sample Output</h3>
     * <pre>19 <span >// [1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1]</span>
     * </pre>
     * </div>
     */
    @Override
    public Problem getProblem() {
        return Problem.builder()
        .withTestCase(
            TestCase.builder()
            .withInput(new int[]{3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4})
            .withOutput(19)
            .build()
        )
        .build();
    }

}
