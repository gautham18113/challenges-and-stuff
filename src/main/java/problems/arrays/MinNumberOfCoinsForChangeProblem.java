package problems.arrays;

import core.Problem;
import core.ProblemInterface;
import core.TestCase;

public class MinNumberOfCoinsForChangeProblem implements ProblemInterface{

    /*
     * <div class="html">
     * <p>
     *   Given an array of positive integers representing coin denominations and a
     *   single non-negative integer <span>n</span> representing a target amount of
     *   money, write a function that returns the smallest number of coins needed to
     *   make change for (to sum up to) that target amount using the given coin
     *   denominations.
     * </p>
     * <p>
     *   Note that you have access to an unlimited amount of coins. In other words, if
     *   the denominations are <span>[1, 5, 10]</span>, you have access to an unlimited
     *   amount of <span>1</span>s, <span>5</span>s, and <span>10</span>s.
     * </p>
     * <p>
     *   If it's impossible to make change for the target amount, return
     *   <span>-1</span>.
     * </p>
     * <h3>Sample Input</h3>
     * <pre><span class="CodeEditor-promptParameter">n</span> = 7
     * <span class="CodeEditor-promptParameter">denoms</span> = [1, 5, 10]
     * </pre>
     * <h3>Sample Output</h3>
     * <pre>3 <span class="CodeEditor-promptComment">// 2x1 + 1x5</span>
     * </pre>
     * </div>
     */
    @Override
    public Problem getProblem() {
        return Problem.builder()
        .withTestCase(
            TestCase.builder()
            .withInput(new int[]{1,5,10})
            .withInput(7)
            .withOutput(3)
            .build()
        )
        .build();
    }

}
