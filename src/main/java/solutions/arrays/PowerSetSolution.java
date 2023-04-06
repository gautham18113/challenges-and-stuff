package solutions.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import core.Solution;
import core.io.Input;
import core.io.Output;

public class PowerSetSolution implements Solution {

    public Output<?> solve(Input<?> input) {
        int[] arr = (int[]) input.getInput();
        List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        List<List<Integer>> result = createPowerSet(arrList);

        return new Output<>(result);
    }

    /**
     * T = O(2^n * n)
     * S = O(2^n * n)
     *
     * Explanation: For each element in the input list, the subset
     * result list has to be iterated again. The subset list roughly
     * doubles it's size during every loop, hence roughly 2^n. And during
     * each loop, on an average, the subset list contains n/2 elements.
     */
    @SuppressWarnings("unchecked")
    public List<List<Integer>> createPowerSet(List<Integer> arr) {

        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.EMPTY_LIST);

        for(int num: arr) {

            List<List<Integer>> tempResult = new ArrayList<>(result);

            for(List<Integer> subset: tempResult) {
                List<Integer> tempSet = new ArrayList<>(subset);
                tempSet.add(num);
                result.add(tempSet);
            }
        }

        return result;

    }

}
