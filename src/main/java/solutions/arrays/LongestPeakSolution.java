package solutions.arrays;

import core.Solution;
import core.io.Input;
import core.io.Output;

public class LongestPeakSolution implements Solution{

    /* For problems like this where we need to look behind or forward,
     * it's better to use a while loop.
     * And for comparison with next element, it is better to compare i
     * and i+1 instead of i and i-1 since this will cause an index error.
     *
     * Time Complexity: O(N) since we never visit a certain node
     * more than once.
     * Space Complexity: O(1)
     */
    @Override
    public Output<?> solve(Input<?> input) {
        int[] array = (int[]) input.getInput();

        int longestPeak = 0;

        int i = 1;

        while(i < array.length - 1) {
            boolean isPeak = array[i - 1] < array[i] && array[i] > array[i + 1];

            if(!isPeak){
                i++;
                continue;
            }

            int leftIdx = i - 2;

            while(leftIdx >= 0 && array[leftIdx] < array[leftIdx + 1]) {
                leftIdx--;
            }

            int rightIdx = i + 2;

            while(rightIdx < array.length && array[rightIdx] < array[rightIdx - 1]) {
                rightIdx++;
            }

            int peakLength = rightIdx - leftIdx - 1;

            if(peakLength > longestPeak) {
                longestPeak = peakLength;
            }

            i = rightIdx;
        }

        return new Output<>(longestPeak);
    }

}
