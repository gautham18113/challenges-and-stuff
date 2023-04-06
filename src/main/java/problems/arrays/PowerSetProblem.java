package problems.arrays;

import java.util.Arrays;
import java.util.Collections;

import core.Problem;
import core.ProblemInterface;
import core.TestCase;

public class PowerSetProblem implements ProblemInterface{

    /**
     * <div class="html">
     * <p>
     *   Write a function that takes in an array of unique integers and returns its
     *   powerset.
     * </p>
     * <p>
     *   The powerset <span>P(X)</span> of a set <span>X</span> is the set of all
     *   subsets of <span>X</span>. For example, the powerset of <span>[1,2]</span> is
     *   <span>[[], [1], [2], [1,2]]</span>.
     * </p>
     * <p>
     *   Note that the sets in the powerset do not need to be in any particular order.
     * </p>
     * <h3>Sample Input</h3>
     * <pre><span class="CodeEditor-promptParameter">array</span> = [1, 2, 3]
     * </pre>
     * <h3>Sample Output</h3>
     * <pre>[[], [1], [2], [3], [1, 2], [1, 3], [2, 3], [1, 2, 3]]
     * </pre>
     * </div>
     */
    @Override
    public Problem getProblem() {
        return Problem.builder()
        .withTestCase(
            TestCase.builder()
            .withInput(new int[]{1,2,3})
            .withOutput(
                Arrays.asList(
                    Collections.emptyList(),
                    Arrays.asList(1),
                    Arrays.asList(2),
                    Arrays.asList(3),
                    Arrays.asList(1,3),
                    Arrays.asList(1,2),
                    Arrays.asList(2,3),
                    Arrays.asList(1,2,3)
                )
            )
            .build()
        )
        .build();
    }
}
