package solutions.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

import core.Solution;
import core.io.Input;
import core.io.Output;

public class MergeOverlappingIntervalsSolution implements Solution{

    /**
     * did not immediately realize the fact that the end iterval needs
     * to be updated while checking for mergeable intervals.
     */
    @Override
    public Output<?> solve(Input<?> input) {
        int[][] intervals = (int[][])input.getInput();

        // time o(nlogn)
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        // space o(n)
        int[][] output = new int[intervals.length][];

        int i = 0;

        int outputIdx = 0;

        // time o(n)
        while(i < intervals.length) {

            int j = i + 1;

            int[] merged = intervals[i];

            while(j < intervals.length && merged[1] >= intervals[j][0]) {
                /* since start interval is already sorted, we only need to update
                 * end interval */
                merged[1] = Math.max(merged[1], intervals[j++][1]);
            }

            output[outputIdx++] = merged;

            i = j;

        }

        return new Output<>(Arrays.stream(output).filter(e -> Objects.nonNull(e)).toArray(int[][]::new));
    }

}
