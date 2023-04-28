package solver.impl.dp;

import com.google.common.reflect.TypeToken;
import model.TestCases;
import parser.Parser;
import problem.compare.Compare;
import problem.input.impl.CoinChangeInput;
import problem.output.impl.GenericOutput;
import solver.BaseSolver;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/coin-change-ii/
 */
public class NumWaysToMakeChangeTopDownSolver extends BaseSolver<CoinChangeInput, GenericOutput<Integer>> {

    @Inject
    public NumWaysToMakeChangeTopDownSolver(
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
                new TypeToken<>() {});
    }

    @Override
    public GenericOutput<Integer> solveProblem(CoinChangeInput input) {
        int result = dfs(new Node(0, input.getTarget()), input.getCoins(), new HashMap<>());
        GenericOutput<Integer> output = new GenericOutput<>();
        output.setValue(result == 0 ? -1 : result);
        return output;
    }

    public int dfs(Node node, int[] coins, Map<Node, Integer> memo) {

        // numWays[amount] = sum(numWays[amount-c[i]])
        // where i is 0 to coins array length
        // iff numWays[amount-c[i]] is feasible

        if(node.amount == 0) {
            return 1;
        }

        if(node.amount < 0) {
            return 0;
        }

        // memo should contain both start index and amount obtained through coin at index to avoid
        // returning cached values of amount obtained because of duplicate calls

        if(memo.containsKey(node)) {
            return memo.get(node);
        }

        int ans = 0;

        // there will be duplicate paths if we consider all possible combinations.
        // the reason is that, let's say given [2, 3] and target amount 5, the possible
        // branches are

        // 5 (-2) -> 3 (-3) -> 0
        // 5 (-3) -> 2 (-2) -> 0
        // but we have already visited subtracting 2 from the amount. so this needs to be avoided
        // to eliminate duplicate counting. this can be done by following an order while determining
        // the next candidate of coin.

        for(int coinIdx = node.startIdx; coinIdx < coins.length; ++coinIdx) {
            ans += dfs(new Node(coinIdx, node.amount - coins[coinIdx]), coins, memo);
        }

        memo.put(node, ans);
        return ans;
    }

    private class Node {
        public int startIdx;
        public int amount;
        public Node(int startIdx, int amount) {
            this.startIdx = startIdx;
            this.amount = amount;
        }
    }
}
