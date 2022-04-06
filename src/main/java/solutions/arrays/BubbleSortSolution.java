package solutions.arrays;

import core.Solution;
import core.io.Input;
import core.io.Output;
import core.Util;

public class BubbleSortSolution implements Solution {
    /**
     * O(n) time | O(1) space - best case when the array is already sorted
     * O(n^2) time | O(1) space - worst case when array is sorted in descending order
     * @param input
     * @return
     */
    @Override
    public Output<?> solve(Input<?> input) {
        int[] toSort = (int[]) input.getInput();

        for(int i=0; i < toSort.length; i++) {
            boolean sorted = true;
            for(int j = 0; j < toSort.length - 1 - i; j++) {
                if(toSort[j] > toSort[j + 1]) {
                    Util.swap(j, j + 1, toSort);
                    sorted = false;
                }
            }
            if(sorted) break;
        }
        return new Output<>(toSort);
    }
}
