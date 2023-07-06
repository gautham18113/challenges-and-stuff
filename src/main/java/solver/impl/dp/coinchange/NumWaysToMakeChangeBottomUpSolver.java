package solver.impl.dp.coinchange;

import com.google.common.reflect.TypeToken;
import model.TestCases;
import module.SolverType;
import parser.Parser;
import problem.compare.Compare;
import problem.input.impl.CoinChangeInput;
import problem.output.impl.GenericOutput;
import solver.BaseSolver;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;

/**
 * https://leetcode.com/problems/coin-change-ii/
 */
@SolverType
public class NumWaysToMakeChangeBottomUpSolver extends
        BaseSolver<CoinChangeInput, GenericOutput<Integer>> {

    @Inject
    public NumWaysToMakeChangeBottomUpSolver(
            @Named("jsonParser")
            Parser parser,
            @Named("numWaysToMakeChangeProblem")
            String fileName,
            Map<String, Compare> compareMap) {
        super(parser, fileName, compareMap);
    }

    @Override
    protected TestCases getTestCases() {
        return parser.parse(getConfigFile(),
                new TypeToken<>() {
                });
    }

    @Override
    public GenericOutput<Integer> solveProblem(CoinChangeInput input) {
        int result = ways(input.getCoins(), input.getTarget());
        GenericOutput<Integer> output = new GenericOutput<>();
        output.setValue(result == 0 ? -1 : result);
        return output;
    }

    public int ways(int[] coins, int target) {
        // bottom up can be constructed by looking at leaf node of top-down
        // leaf node of top down is 1 or 0.
        // There can be a 2D dp array with
        // row = all possible amounts adding up to target
        // col = start index
        // 2d array is needed to keep track of the index, to avoid duplicates.

        // the base case would be 0, which means that the amount-coinValue has reached zero for a
        // combination, which means that it can be constructed.

        // initialize dp array with 0
        int[][] dp = new int[coins.length + 1][target + 1];

        // initialize success case
        dp[0][0] = 1;

        // we begin by trying to construct amount 1 using the given coins,
        // and build on top of it to construct 2, 3 ... upto target.
        for(int coinIdx=1; coinIdx <= coins.length; coinIdx++) {
            for (int amount = 0; amount <= target; amount++) {
                int denomination = coins[coinIdx - 1];
                int remain = amount - denomination;
                dp[coinIdx][amount] = dp[coinIdx - 1][amount];
                if(remain >= 0) {
                    if(dp[coinIdx][remain] > 0) {
                        dp[coinIdx][amount] += dp[coinIdx][remain];
                    }
                }
            }

        }

        return dp[coins.length][target];
    }

}

