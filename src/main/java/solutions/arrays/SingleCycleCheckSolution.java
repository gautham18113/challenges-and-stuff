package solutions.arrays;

import core.Solution;
import core.io.Input;
import core.io.Output;

public class SingleCycleCheckSolution implements Solution {

    @Override
    public Output<?> solve(Input<?> input) {

        int[] array = (int[]) input.getInput();

        int currIndex = 0;
        int visited = 0;

        while(visited < array.length) {
            visited++;
            int jump = array[currIndex];
            currIndex = adjustedIdx(currIndex, jump, array.length);
            if(currIndex == 0) break;
        }
        return new Output<>(visited == array.length && currIndex == 0);
    }

    private int adjustedIdx(int idx, int jump, int length) {
        int remain = (idx + jump) % length;
        return remain >=0 ? remain : remain + length;
    }

}
