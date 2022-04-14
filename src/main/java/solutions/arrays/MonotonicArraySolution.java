package solutions.arrays;

import core.Solution;
import core.io.Input;
import core.io.Output;

public class MonotonicArraySolution implements Solution {

    @Override
    public Output<?> solve(Input<?> input) {
        int[] array = (int[]) input.getInput();

        int idx = 0;
        Boolean increasing = null;

        if(array.length <= 2) return new Output<>(true);


        while(idx < array.length - 1) {

            if(increasing == null && array[idx] < array[idx + 1]) {
                increasing = true;
                idx++;
                continue;
            }

            if(increasing == null && array[idx] > array[idx + 1]) {
                increasing = false;
                idx++;
                continue;
            }

            if(increasing == null && array[idx] == array[idx + 1]) {
                idx++;
                continue;
            }


            // Increasing but changes direction
            if(increasing && (array[idx] > array[idx + 1])){
                return new Output<>(false);
            }

            // Decreasing but changes direction
            if(!increasing && (array[idx] < array[idx + 1])){
                return new Output<>(false);
            }

            idx++;
        }
        return new Output<>(true);
    }
}
