package solutions.general;

import core.Solution;
import core.io.Input;
import core.io.Output;

public class NthFibonacciRecursiveSolution implements Solution {

    @Override
    public Output<?> solve(Input<?> input) {
        int result = nthFiboRecursive((Integer) input.getInput());
        return new Output<>(result);
    }

    /**
     *
     * <p>O(2^n) time | O(n) space</p>
     *
     * <p>
     *     <b>Time Complexity Explanation:</b>
     * </p>
     * <p>
     *     With each call, we initiate two additional calls. Hence every step will create 2 x 2 x 2 x 2 etc. calls for
     *     n times. Which gives a time complexity of O(2^n).
     * </p>
     *
     * <p>
     *     <b>Space Complexity Explanation:</b>
     * </p>
     * <p>
     *     At any given time, there are only going to be a maximum of n function calls in the call stack.
     *     This is because the call stack that starts with f(n) will only complete when it reached f(0) which
     *     will return 0. Then the call stack will be cleared to proceed to the next function call.
     * </p>
     *
     * <p>
     *     <b>Recursive Formula:</b>
     * </p>
     * <p>
     *    {@code fibonacci(n) = fibonacci(n - 1) + fibonacci(n - 2) if n > 2}
     * </p>
     *
     * @param n The number of elements at which series should stop
     * @return the nth element of the fibonacci series
     */
    public int nthFiboRecursive(int n) {
        if(n == 1) return 0;
        if(n == 2) return 1;
        return nthFiboRecursive(n - 1) + nthFiboRecursive(n - 2);
    }
}
