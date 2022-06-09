package solutions.arrays;

import core.Solution;
import core.io.Input;
import core.io.Output;

public class FirstDuplicateValueSolution implements Solution{

    /*
     * Read the question very carfully always, if we read this
     * question properly, we will notice that the numbers in the array is
     * limited to the indices in the array. So we can use the input array to
     * mark whether or not a number corresponding to a index is seen or not by mapping
     * the value of the number in that index negative. If a number is already marked negative
     * then it was seen before. We return the number corresponding to the first occurence of this
     * condition.
     */
    @Override
    public Output<?> solve(Input<?> input) {

        int[] array = (int[]) input.getInput();

        for(int i = 0; i<array.length; i++) {
            int val = Math.abs(array[i]) - 1;

            if(array[val] < 0) {
                return new Output<>(val + 1);
            }

            array[val] = array[val] * -1;

        }
        return new Output<>(-1);
    }

}
