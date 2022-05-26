package solutions.arrays;

import core.Solution;
import core.io.Input;
import core.io.Output;

public class MonotonicArraySolution implements Solution {

    @Override
    public Output<?> solve(Input<?> input) {
        int[] array = (int[]) input.getInput();
        return new Output<>(determineTrend(array));
    }
    private boolean determineTrend(int[] arr) {
        boolean isNonIncreasing = true;
        boolean isNonDecreasing = true;

        if(arr.length <= 1) return true;

        for(int i = 1; i < arr.length; i++) {
            if(arr[i - 1] < arr[i]) {
                isNonIncreasing = false;
            }
            if(arr[i - 1] > arr[i]) {
                isNonDecreasing = false;
            }
        }
        return isNonDecreasing || isNonIncreasing;
    }
}
