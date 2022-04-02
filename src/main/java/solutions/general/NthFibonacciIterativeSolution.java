package solutions.general;

import core.Solution;
import core.io.Input;
import core.io.Output;

public class NthFibonacciIterativeSolution implements Solution {
    /**
     *
     * O(n) time | O(1) space
     * @param input {@link Input} wrapper containing length of fibonacci series
     * @return {@link Output} wrapper containing Nth member of fibonacci series
     *
     */
    @Override
    public Output<?> solve(Input<?> input) {

        int n = (Integer) input.getInput();

        int[] arr = {0, 1};

        if(n == 2) return new Output<>(1);

        int counter = 3;

        while(counter <= n) {

            int three = arr[0] + arr[1];
            arr[0] = arr[1];
            arr[1] = three;

            counter++;

        }
        return new Output<>(n > 1 ? arr[1] : arr[0]);
    }
}
