package solutions.arrays;

import core.Solution;
import core.Util;
import core.io.Input;
import core.io.Output;

/**
 * <p>
 * Insertion sort: maintain a sorted part in the given array
 * and keep inserting elements into that part in sorted order.
 * </p>
 *
 * O(n^2) time | O(1) space - worst case
 *
 * O(n) time | O(1) space - best case
 *
 */
public class InsertionSortSolution implements Solution {

    @Override
    public Output<?> solve(Input<?> input) {
        int[] array = (int[]) input.getInput();
        for(int i=0; i<array.length; i++) {
            int j = i-1;
            int toInsert = array[i];
            while(j >= 0 && array[j] > toInsert) {
                Util.swap(j, j+1, array);
                j--;
            }
        }
        return new Output<>(array);
    }
}
