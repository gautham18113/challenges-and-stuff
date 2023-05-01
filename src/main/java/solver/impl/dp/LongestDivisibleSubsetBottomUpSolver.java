package solver.impl.dp;

import com.google.common.reflect.TypeToken;
import model.TestCases;
import parser.Parser;
import problem.compare.Compare;
import problem.input.impl.GenericInput;
import problem.output.impl.GenericOutput;
import solver.BaseSolver;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Arrays;
import java.util.Map;

/**
 * https://leetcode.com/problems/largest-divisible-subset/
 */
public class LongestDivisibleSubsetBottomUpSolver
        extends BaseSolver<GenericInput<Integer[]>, GenericOutput<Integer>> {
    @Inject
    public LongestDivisibleSubsetBottomUpSolver(
            @Named("jsonParser")
            Parser parser,
            @Named("longestDivisibleSubsetProblem")
            String fileName,
            Map<String, Compare> compareMap) {
        super(parser, fileName, compareMap);
    }

    @Override
    protected TestCases getTestCases() {
        return parser.parse(getConfigFile(), new TypeToken<>() {
        });
    }

    @Override
    public GenericOutput<Integer> solveProblem(GenericInput<Integer[]> input) {
        Integer[] arr = input.getValue();

        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);

        // recurrence relation =>
        // dp[i] = max(1 + dp[j], dp[i]) if arr[i] % arr[j] == 0 and arr[i] > arr[j]
        // for every j = 0 to i-1

        // to maintain property arr[i] > arr[j], arr[i] should be greater because to satisfy
        // the set condition, the largest number in the divisible set should be divisible by all the
        // smaller  numbers in the set.
        Arrays.sort(arr);
        // since array elements are unique, we don't need to worry about equal
        // if arr[j] is divisible by i, then transitively, any number divisible by arr[j] will also
        // be divisible by arr[i]

        int maxSubset = 0;

        for (int i = 0; i < arr.length; i++) {
            int one = arr[i];
            for (int j = 0; j < i; j++) {
                int two = arr[j];

                if (one % two == 0 || two % one == 0) {
                    dp[i] = Math.max(1 + dp[j], dp[i]);
                }
            }
            maxSubset = Math.max(dp[i], maxSubset);
        }

        GenericOutput<Integer> output = new GenericOutput<>();
        output.setValue(maxSubset);
        return output;
    }
}
