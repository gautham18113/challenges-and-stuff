package problems.arrays;

import java.util.Arrays;

import core.Problem;
import core.ProblemInterface;
import core.TestCase;

public class PermutationProblem implements ProblemInterface{

    /**
     * <div class="html">
     * <p>
     *   Write a function that takes in an array of unique integers and returns an
     *   array of all permutations of those integers in no particular order.
     * </p>
     * <p>If the input array is empty, the function should return an empty array.</p>
     * <h3>Sample Input</h3>
     * <pre><span class="CodeEditor-promptParameter">array</span> = [1, 2, 3]
     * </pre>
     * <h3>Sample Output</h3>
     * <pre>[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
     * </pre>
     * </div>
     */
    @Override
    public Problem getProblem() {
        return Problem.builder()
        .withTestCase(
            TestCase.builder()
            .withInput(Arrays.asList(1, 2, 3))
            .withOutput(Arrays.asList(
                Arrays.asList(1,2,3),
                Arrays.asList(1,3,2),
                Arrays.asList(2,1,3),
                Arrays.asList(2,3,1),
                Arrays.asList(3,1,2),
                Arrays.asList(3,2,1)
            ))
            .build()
        )

        .build();
    }

}
