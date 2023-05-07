package solver.impl.dp.interval;

import com.google.common.reflect.TypeToken;
import model.TestCases;
import parser.Parser;
import problem.compare.Compare;
import problem.input.impl.GenericInput;
import problem.output.impl.GenericOutput;
import solver.BaseSolver;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Map;

public class CoinGameTopDownSolver
        extends BaseSolver<GenericInput<List<Integer>>, GenericOutput<Integer>> {

    @Inject
    public CoinGameTopDownSolver(@Named("jsonParser") Parser parser,
                                 @Named("coinGameProblem") String fileName,
                                 Map<String, Compare> compareMap) {
        super(parser, fileName, compareMap);
    }

    @Override
    protected TestCases getTestCases() {
        return parser.parse(getConfigFile(), new TypeToken<>() {
        });
    }

    @Override
    public GenericOutput<Integer> solveProblem(GenericInput<List<Integer>> input) {
        // This is an interval dp problem

        List<Integer> coins = input.getValue();

        int[] prefixSum = new int[coins.size() + 1];

        for(int i = 1; i <= coins.size(); i++) {
            prefixSum[i] = prefixSum[i - 1] + coins.get(i - 1);
        }
        int score = dfs(coins, 0, coins.size() - 1,
                new int[input.getValue().size()][input.getValue().size()], prefixSum);


        GenericOutput<Integer> output = new GenericOutput<>();
        output.setValue(score);
        return output;
    }

    public int dfs(List<Integer> coins, int left, int right, int[][] dp, int[] prefixSum) {

        // leaf, only one coin is left
        if (left == right) {
            return coins.get(left);
        }

        // return from memo if it is available
        if (dp[left][right] != 0) {
            return dp[left][right];
        }


        /**
         * Note that a common pitfall is to try to keep tracking of which player the current
         * recursive call is for using an extra state variable.
         * This is unnecessary because it doesn't really matter which user the recursive call is
         * for because the current player always tries to minimize the other player's score
         * (each user "plays perfectly in such a way that maximizes their score").
         *
         * [IMPORTANT]
         * Each recursive call returns the best possible score the current player
         * can get. So, the outermost call will return the best score for the first player
         *
         * Recurrence relation:
         * myScore = total - opponentScore
         * myScore = total - min(opponentScore if I pick left coin, opponentScore if I pick right coin)
         * above is easier to understand if we take just two numbers, say [9, 4]. Sum is 13,
         * and we want to optimize the score at this step. It will be optimized if the person who
         * goes next picks 4, i.e. min(9,4). So 13 - 4 = 9 is the maximum possible score for the
         * current person.
         **/
        dp[left][right] = (prefixSum[right + 1] - prefixSum[left]) -
                Math.min(dfs(coins, left + 1, right, dp, prefixSum), // opponent score if i pick left coin
                        dfs(coins, left, right - 1, dp, prefixSum) // opponent score if i pick right coin
                );

        return dp[left][right];

    }
}

