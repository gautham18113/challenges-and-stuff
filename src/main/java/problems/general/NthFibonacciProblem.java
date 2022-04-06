package problems.general;

import core.io.Input;
import core.io.Output;
import core.Problem;
import core.ProblemInterface;
import core.TestCase;

import java.util.Arrays;

/**
 * <p>
 *   The Fibonacci sequence is defined as follows: the first number of the sequence
 *   is <span>0</span>, the second number is <span>1</span>, and the nth number is the sum of the (n - 1)th
 *   and (n - 2)th numbers. Write a function that takes in an integer
 *   <span>n</span> and returns the nth Fibonacci number.
 * </p>
 * <p>
 *   <b>Important note </b>: the Fibonacci sequence is often defined with its first two
 *   numbers as <span>F0 = 0</span> and <span>F1 = 1</span>. For the purpose of
 *   this question, the first Fibonacci number is <span>F0</span>; therefore,
 *   <span>getNthFib(1)</span> is equal to <span>F0</span>, <span>getNthFib(2)</span>
 *   is equal to <span>F1</span>, etc..
 * </p>
 * <p></p>
 * <h3>Sample Input #1</h3>
 * <pre><span>n</span> = 2
 * </pre>
 * <h3>Sample Output #1</h3>
 * <pre>1 <span>// 0, 1</span>
 * </pre>
 * <h3>Sample Input #2</h3>
 * <pre><span >n</span> = 6
 * </pre>
 * <h3>Sample Output #2</h3>
 * <pre>5 <span>// 0, 1, 1, 2, 3, 5</span>
 * </pre>
 */
public class NthFibonacciProblem implements ProblemInterface {
    @Override
    public Problem getProblem() {
        return Problem.builder()
            .withTestCaseList(Arrays.asList(
                TestCase.builder().withInput(new Input<>(6)).withOutput(new Output<>(5)).build(),
                TestCase.builder().withInput(new Input<>(1)).withOutput(new Output<>(0)).build(),
                TestCase.builder().withInput(new Input<>(2)).withOutput(new Output<>(1)).build()
            ))
            .build();

    }
}
