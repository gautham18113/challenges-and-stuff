package solver.impl.dp.knapsack;

import com.google.common.reflect.TypeToken;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import lombok.EqualsAndHashCode;
import model.TestCases;
import module.SolverType;
import parser.Parser;
import problem.compare.Compare;
import problem.input.impl.GenericInput;
import problem.output.impl.GenericOutput;
import solver.BaseSolver;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/partition-equal-subset-sum/
 * top down for this problem is the same as knapsack weight only top down
 */
@SolverType
public class PartitionTwoEqualSumSubsetsTopDownSolver extends BaseSolver<GenericInput<Integer[]>, GenericOutput<Boolean>> {

    @Inject
    public PartitionTwoEqualSumSubsetsTopDownSolver(
            @Named("jsonParser")
            Parser parser,
            @Named("partitionTwoEqualSumSubsetsProblem")
            String fileName,
            Map<String, Compare> compareMap) {
        super(parser, fileName, compareMap);
    }

    public TestCases getTestCases() {
        return parser.parse(getConfigFile(), new TypeToken<>() {});
    }

    public GenericOutput<Boolean> solveProblem(GenericInput<Integer[]> input) {
        Integer[] array = input.getValue();

        int total = Arrays.stream(array).reduce(Integer::sum).get();

        Boolean result;

        if (total % 2 != 0) {
            result = false;
        } else {
            // target is sum of array / 2

            // use a combinatorial approach to find all possible combination of elements whose sum
            // will be equal to target

            result = dfs(
                    array,
                    // start idx
                    0,
                    // start sum
                    0,
                    // target
                    total / 2,
                    // memo
                    new HashMap<>());
        }

        GenericOutput<Boolean> output = new GenericOutput<>();
        output.setValue(result);
        return output;

    }

    public boolean dfs(Integer[] arr, int idx, int sum, int target, Map<State, Boolean> memo) {

        // return true if sum equals target
        if (sum == target) {
            return true;
        }

        State currentState = new State(sum, idx);

        // if a certain idx, sum combination was already seen, then return it
        if (memo.containsKey(currentState)) {
            return memo.get(currentState);
        }

        // base case, end of array
        if (idx == arr.length) {
            return false;
        }

        // edges will be
        // 1. include arr[idx] in sum
        // 2. do not include arr[idx] in sum
        boolean result = false;
        for (Integer edge: Arrays.asList(arr[idx], 0)) {

            // pruning
            if(sum + edge > target) {
                continue;
            }

            // aggregate boolean result using or
            result = result || dfs(
                    arr,
                    idx + 1,
                    sum + edge,
                    target,
                    memo
            );
        }

        // memoize result
        memo.put(currentState, result);

        return memo.get(currentState);
    }

    @EqualsAndHashCode
    private class State {
        public int sum;
        public int idx;
        public State(int sum, int idx) {
            this.sum = sum;
            this.idx = idx;
        }

    }
}
