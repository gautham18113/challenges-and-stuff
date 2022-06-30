package solutions.arrays;

import core.Solution;
import core.io.Input;
import core.io.Output;

public class KadanesAlgorithmSolution implements Solution{

    @Override
    public Output<?> solve(Input<?> input) {
        int[] array = (int[]) input.getInput();
        int maxSum = maxSubsetSumSpaceOptimized(array);
        maxSubsetSum(array);
        return new Output<>(maxSum);
    }

    /**
     * <b>T</b> O(n) <b>S<b> O(n)
     * @param array
     * @return maximum sum possible from a contiguous subset of the array
     */
    private int maxSubsetSum(int[] array) {
        /*
         * An index in this array represents maximum possible
         * sum till that index in the original array
         */
        int[] dpArray = new int[array.length];

        /*
         * At every index we have two choices
         * 1. The element at current index extends sum till previous element
         * 2. The element at current index begins it's own subarray
         */
        int maxSoFar = Integer.MIN_VALUE;

         for(int i = 0; i < array.length; i++) {
            if(i == 0) dpArray[i] = array[i];

            else{
                dpArray[i] = Math.max(
                    /* 1 */
                    array[i] + dpArray[i - 1],
                    /* 2 */
                    array[i]
                );
            }

            maxSoFar = Math.max(dpArray[i], maxSoFar);
         }

         return maxSoFar;
    }

    /**
     * <b>T</b>O(n) <b>S</b>O(1)
     * @param array
     * @return
     */
    private int maxSubsetSumSpaceOptimized(int[] array) {
        int sumSoFar = 0;

        /*
         * At every index we have two choices
         * 1. The element at current index extends sum till previous element
         * 2. The element at current index begins it's own subarray
         */
        int maxSoFar = Integer.MIN_VALUE;

         for(int i = 0; i < array.length; i++) {
            // if(i == 0) dpArray[i] = array[i];
            if(i == 0) sumSoFar = array[i];

            else{
                sumSoFar = Math.max(array[i] + sumSoFar, array[i]);
                // dpArray[i] = Math.max(
                //     /* 1 */
                //     array[i] + dpArray[i - 1],
                //     /* 2 */
                //     array[i]
                // );
            }

            // maxSoFar = Math.max(dpArray[i], maxSoFar);
            maxSoFar = Math.max(sumSoFar, maxSoFar);
         }

         return maxSoFar;
    }

}
