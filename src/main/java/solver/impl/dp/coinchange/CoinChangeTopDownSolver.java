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
import java.util.HashMap;
import java.util.Map;

@SolverType
public class CoinChangeTopDownSolver extends BaseSolver<CoinChangeInput, GenericOutput<Integer>> {


    @Inject
    public CoinChangeTopDownSolver(
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

        int[] coins = input.getCoins();
        int target = input.getTarget();

        int minNoOfCoins = dfs(
                /* start amount */ target,
                /* coin array */ coins,
                /* memoization */ new HashMap<>()
        );

        // target cannot be formed with given coins
        if (minNoOfCoins == Integer.MAX_VALUE) {
            minNoOfCoins = -1;
        }

        GenericOutput<Integer> output = new GenericOutput<>();
        output.setValue(minNoOfCoins);

        return output;
    }


    // aggregation DFS problem which aggregates by minimum number of coins
    private Integer dfs(int amount, int[] coins, Map<Integer, Integer> memo) {

        // if target cannot be created using selected coins, return infinity
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }

        // if target can be made with selected coins return 0
        // note that we return 0 instead of 1 since we don't want to include any coins for
        // the leaf node
        if (amount == 0) {
            return 0;
        }

        // if min no of coins is already available for current vertex, then return it
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }

        int noOfCoins = Integer.MAX_VALUE;

        for (int idx = 0; idx < coins.length; idx++) {

            // vertex = amount, edge = coin denominations
            // return value: no of coins or depth of branch
            // recurrence relation:
            // OPT(amount) = 1 + min([OPT(amount-c0)..OPT(amount-cn)] given that any(OPT(amount-cn))
            // can construct the required target

            noOfCoins = Math.min(noOfCoins, dfs(
                    amount - coins[idx], coins, memo
            ));

        }

        // if no of coins is not infinity, then it means that the target can be constructed
        // by the branch that this node is in.
        // then increase the number of coins by 1
        if (noOfCoins != Integer.MAX_VALUE) {
            noOfCoins++;
        }

        memo.put(amount, noOfCoins);

        return noOfCoins;
    }

}
