package solver.impl.dp.knapsack;

import com.google.common.reflect.TypeToken;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import model.TestCases;
import solver.SolverType;
import parser.Parser;
import problem.compare.Compare;
import problem.input.impl.GenericInput;
import problem.output.impl.GenericOutput;
import solver.BaseSolver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SolverType
public class KnapsackWeightOnlyBottomUpSolver extends
        BaseSolver<GenericInput<List<Integer>>, GenericOutput<List<Integer>>> {

    @Inject
    public KnapsackWeightOnlyBottomUpSolver(
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
        List<Integer> result = new ArrayList<>();
        bottomUp(weights, result);
        GenericOutput<List<Integer>> output = new GenericOutput<>();
        output.setValue(result.stream().sorted().distinct().collect(Collectors.toList()));

        return output;

    }

    /**
     * Bottom Up:
     * <p>
     * For the bottom up way, we store all the possible values of weight sums that can be formed
     * just by one weight and continuously extend on top of it by adding the other weights from
     * the weights array.
     * </p>
     * <p>
     * Each row in the DP array will represent the addition of another weight to the set of
     * available weights and each column will represent all possible weight sums from 0 to sum(w1...wn) where w is the weight
     * in the weights array. And each cell will have a boolean indicating if a given weight sum can be built using
     * the set of weights represented by that row.
     * </p>
     * <p>
     * The condition of whether or not a certain weight sum can be built by using the set of
     * weights in the given row is determined by subtracting the weight represented by that row
     * from the weight sum and checking if the residual weight can be built by weights excluding
     * the weight represented by that row, i.e. weights at row - 1;
     * </p>
     * <p>
     * The first row will be no weights (zero) and first column will also be zero, this handles the case where
     * any given weight sum W is subtracted by some weight wn, the remaining weight W - wn, say wk, should
     * be possible to build using the given weights. Having 0 handles the case where wk = 0.
     * </p>
     */
    private void bottomUp(List<Integer> weights, List<Integer> result) {

        int X = weights.stream().reduce(Integer::sum).orElse(0);
        boolean[][] dp = new boolean[weights.size() + 1][X + 1];

        // base case, only 0 weight sum can be created with
        dp[0][0] = true;

        for (int row = 1; row < weights.size() + 1; row++) {
            for (int col = 0; col < X + 1; col++) {
                if (col == 0) {
                    // 0 weight sum can be created with any weight
                    dp[row][col] = true;
                    continue;
                }

                // whether weight represented by col can be created without using w_i
                dp[row][col] = dp[row - 1][col];

                // check whether weight sum can be formed on top of weight represented by
                // col - w_i
                if (col - weights.get(row - 1) >= 0) {
                    dp[row][col] = dp[row][col] || dp[row - 1][col - weights.get(row - 1)];
                }

            }
        }

        // Get list of weight sums that can be formed using all provided weights
        for (int i = 0; i < dp[0].length; i++) {
            if (dp[weights.size()][i]) {
                result.add(i);
            }
        }
    }
}
