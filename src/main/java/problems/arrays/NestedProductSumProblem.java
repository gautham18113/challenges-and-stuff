package problems.arrays;

import core.Problem;
import core.ProblemInterface;
import core.TestCase;
import core.io.Input;
import core.io.Output;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <div>
 * <p>
 *   Write a function that takes in a "special" array and returns its product sum.
 * </p>
 * <p>
 *   A "special" array is a non-empty array that contains either integers or other
 *   "special" arrays. The product sum of a "special" array is the sum of its
 *   elements, where "special" arrays inside it are summed themselves and then
 *   multiplied by their level of depth.
 * </p>
 * <p>
 *   The depth of a "special" array is how far nested it is. For instance, the
 *   depth of <span>[]</span> is <span>1</span>; the depth of the inner array in
 *   <span>[[]]</span> is <span>2</span>; the depth of the innermost array in
 *   <span>[[[]]]</span> is <span>3</span>.
 * </p>
 * <p>
 *   Therefore, the product sum of <span>[x, y]</span> is <span>x + y</span>; the
 *   product sum of <span>[x, [y, z]]</span> is <span>x + 2 * (y + z)</span>; the
 *   product sum of <span>[x, [y, [z]]]</span> is <span>x + 2 * (y + 3z)</span>.
 * </p>
 * <h3>Sample Input</h3>
 * <pre><span>array</span> = [5, 2, [7, -1], 3, [6, [-13, 8], 4]]
 * </pre>
 * <h3>Sample Output</h3>
 * <pre>12 <span>// calculated as: 5 + 2 + 2 * (7 - 1) + 3 + 2 * (6 + 3 * (-13 + 8) + 4)</span>
 * </pre>
 * </div>
 */
public class NestedProductSumProblem implements ProblemInterface {


    @Override
    public Problem getProblem() {
        return Problem.builder()
            .withTestCase(TestCase.builder()
                .withInput(new Input<>(
                    toArrayList(
                        Arrays.asList(
                            5,
                            2,
                            toArrayList(Arrays.asList(7, -1)),
                            3,
                            toArrayList(Arrays.asList(6, toArrayList(Arrays.asList(-13, 8)), 4))
                        )
                    )
                ))
                .withOutput(new Output<>(12))
                .build())
            .build();
    }

    private ArrayList<Object> toArrayList(List<Object> lst) {
        return new ArrayList<>(lst);
    }
}
