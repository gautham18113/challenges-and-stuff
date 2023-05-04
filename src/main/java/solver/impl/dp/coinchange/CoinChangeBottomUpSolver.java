package solver.impl.dp.coinchange;

import com.google.common.reflect.TypeToken;
import model.TestCases;
import parser.Parser;
import problem.compare.Compare;
import problem.input.impl.CoinChangeInput;
import problem.output.impl.GenericOutput;
import solver.BaseSolver;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Arrays;
import java.util.Map;


/**
 * https://leetcode.com/problems/coin-change/
 */
public class CoinChangeBottomUpSolver extends BaseSolver<CoinChangeInput, GenericOutput<Integer>> {

    @Inject
    public CoinChangeBottomUpSolver(
            @Named("jsonParser")
            Parser parser,
            @Named("coinChangeProblem")
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
        // we can use the top-down approach to create the bottom up approach
        // notice that the leaf of the top-down approach will be 0 or negative, so
        // we will try to construct the bottom up with 0 as base.

        // since we only need to store the no of coins for every possible sum, the dp
        // array can be of size target and number of ways to construct 0 will be 1 , which is the
        // base case.

        // for each coinDenomination in coins, if n - coinDenomination >= 0  and
        // dp[n - coinDenomination] is not INF (cannot be constructed)
        // then dp[n] = min(dp[n], 1 + dp[n - coinDenomination])

        int[] coins = input.getCoins();
        int target = input.getTarget();

        // +1 to include 0
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for (int subTarget = 1; subTarget < dp.length; subTarget++) {

            for (int coinIdx = 0; coinIdx < coins.length; coinIdx++) {
                if (subTarget - coins[coinIdx] >= 0) {
                    // if INF, then sub-target cannot be constructed using this coin
                    if (dp[subTarget - coins[coinIdx]] != Integer.MAX_VALUE) {
                        dp[subTarget] = Math.min(dp[subTarget], dp[subTarget - coins[coinIdx]] + 1);
                    }
                }
            }
        }

        int result = dp[target] == Integer.MAX_VALUE ? -1 : dp[target];

        GenericOutput<Integer> output = new GenericOutput<>();
        output.setValue(result);

        return output;
    }
}
