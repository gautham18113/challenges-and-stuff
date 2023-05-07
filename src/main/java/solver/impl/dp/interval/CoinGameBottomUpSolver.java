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

public class CoinGameBottomUpSolver
        extends BaseSolver<GenericInput<List<Integer>>, GenericOutput<Integer>> {

    @Inject
    public CoinGameBottomUpSolver(@Named("jsonParser") Parser parser,
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

        List<Integer> coins = input.getValue();
        int n = coins.size();
        int[][] dp = new int[n + 1][n + 1];

        // bottom up is similar to top down, we try to calculate the score by size of the sub array
        // starting from sub array of size 1.

        for (int size = 0; size < n; size++) {
            // left bound must be between 1 and n - size
            for (int left = 1; left <= n - size; left++) {
                int right = left + size;
                int total = coins.subList(left - 1, right).stream().reduce(Integer::sum).orElse(0);
                if (left == right) {
                    dp[left][right] = coins.get(left - 1);
                } else {
                    dp[left][right] = total - Math.min(dp[left + 1][right], dp[left][right - 1]);
                }
            }
        }

        GenericOutput<Integer> output = new GenericOutput<>();
        output.setValue(dp[1][n]);
        return output;
    }

}

