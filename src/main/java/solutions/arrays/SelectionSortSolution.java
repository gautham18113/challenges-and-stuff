package solutions.arrays;

import core.Solution;
import core.Util;
import core.io.Input;
import core.io.Output;

/**
 * <p>
 *     Selection Sort: Maintain two portions in the array, sorted and unsorted.
 *     Each time we loop through the array, we find the smallest element in the unsorted part of the
 *     array and swap it with first element of unsorted array. Then we include this element in the sorted array.
 *
 *     Simply put, we will traverse the array n time, each time finding the smallest element and bringing it to the front.
 * </p>
 */
public class SelectionSortSolution implements Solution {
    @Override
    public Output<?> solve(Input<?> input) {
        int[] array = (int[]) input.getInput();

        int ptr1 = 0;
        int ptr2 = 0;

        while(ptr1 < array.length) {
            for(int i = ptr2; i < array.length; i++) {
               if(array[i] < array[ptr2]) {
                   ptr2 =i;
               }
            }
            Util.swap(ptr1, ptr2, array);
            ptr1++;
            ptr2 = ptr1;
        }

        return new Output<>(array);
    }
}
