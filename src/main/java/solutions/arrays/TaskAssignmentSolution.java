package solutions.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import core.Solution;
import core.io.Input;
import core.io.Output;

public class TaskAssignmentSolution implements Solution {

    @SuppressWarnings("all")
    @Override
    public Output<?> solve(Input<?> input) {
        List<Input> inputs = (List<Input>) input.getInput();
        int[] taskDuration = (int[]) inputs.get(0).getInput();
        int k = (int) inputs.get(1).getInput();
        List<List<Integer>> result = taskAssign(k, taskDuration);

        return new Output<>(result);
    }

    private final List<List<Integer>> taskAssign(int workers, int[] tasks) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> taskToIndexMap = taskToIndex(tasks);
        Arrays.sort(tasks);
        for(int start = 0; start < tasks.length; start++) {
            int end = tasks.length - 1 - start;
            if(end < start) break;

            Integer[] pair = new Integer[]{
                taskToIndexMap.get(tasks[start]).remove(0),
                taskToIndexMap.get(tasks[end]).remove(0)
            };

            result.add(Arrays.asList(pair));
        }

        return result;
    }

    private Map<Integer, List<Integer>> taskToIndex(int[] tasks) {

        Map<Integer, List<Integer>> m = new HashMap<>();

        for(int i = 0; i < tasks.length; i++) {
            List<Integer> temp = m.getOrDefault(tasks[i], new ArrayList<>());
            temp.add(i);
            m.put(tasks[i], temp);
        }

        return m;
    }

}
