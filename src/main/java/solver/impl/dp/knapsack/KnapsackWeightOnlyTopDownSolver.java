package solver.impl.dp.knapsack;

import com.google.common.reflect.TypeToken;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import model.TestCases;
import module.SolverType;
import parser.Parser;
import problem.compare.Compare;
import problem.input.impl.GenericInput;
import problem.output.impl.GenericOutput;
import solver.BaseSolver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SolverType
public class KnapsackWeightOnlyTopDownSolver
        extends BaseSolver<GenericInput<List<Integer>>, GenericOutput<List<Integer>>> {

    @Inject
    public KnapsackWeightOnlyTopDownSolver(
            @Named("jsonParser")
            Parser parser,
            @Named("knapsackWeightOnlyProblem")
            String fileName,
            Map<String, Compare> compareMap) {
        super(parser, fileName, compareMap);
    }

    public TestCases getTestCases() {
        return parser.parse(getConfigFile(),
                new TypeToken<>() {
                });
    }

    public GenericOutput<List<Integer>> solveProblem(GenericInput<List<Integer>> input) {
        List<Integer> weights = input.getValue();

        /**
         * 0
         * 1    3   3   5
         * 0    3       3       5
         *      0   3   5
         *          0   5
         */
        // using combinatorial brute force method, it is possible to find all possible
        // sums using the weights given. But that would give a 2^N time complexity where
        // N is the size of weights array.

        // An optimization would be to memoize some of the repeated branches. But the
        // sum of weight value alone is not enough to determine if the branch was already visited
        // or not. For example 1 + 3 = 4 has duplicates, so a combination of weight and index is
        // required to be memoized. For example, for the above weight sum, we would put the following
        // in the memo: memo[(1,4): true, (2, 4): true] which means that the weight sum 4 through
        // index 1 and 2 has already been visited.


        List<Integer> result = new ArrayList<>();
        dfs(weights, 0, 0, result, new HashMap<>());
        GenericOutput<List<Integer>> output = new GenericOutput<>();
        output.setValue(result.stream().sorted().distinct().collect(Collectors.toList()));

        return output;

    }

    /**
     * given an array of weights w such that w = {w_0 ... w_n}
     *
     * let array W be all possible weights that can be formed using multiple combinations of
     * weights in w.
     *
     *
     */
    private void dfs(List<Integer> weights, int currIndex, int sum, List<Integer> result,
                     Map<Integer[], Boolean> memo) {

        // If  a combination of sum, idx is already seen then don't traverse that branch
        if (memo.getOrDefault(new Integer[]{currIndex, sum}, false)) {
            return;
        }

        // base case, reached end of weights array
        if (currIndex == weights.size()) {
            result.add(sum);
            return;
        }

        dfs(
                weights,
                currIndex + 1,
                // W(i - 1) + w_i
                sum + weights.get(currIndex),
                result,
                memo);

        dfs(
                weights,
                currIndex + 1,
                // W(i - 1)
                sum,
                result,
                memo);

        memo.put(new Integer[]{currIndex, sum}, true);
    }
}
