package solver.impl.dp.dynamicsubproblem;

import com.google.common.reflect.TypeToken;
import model.TestCases;
import solver.SolverType;
import parser.Parser;
import problem.compare.Compare;
import problem.input.impl.GenericInput;
import problem.output.impl.GenericOutput;
import solver.BaseSolver;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;

@SolverType
public class LISTopDownSolver
        extends BaseSolver<GenericInput<Integer[]>, GenericOutput<Integer>> {

    private int res = 0;
    @Inject
    public LISTopDownSolver(
            @Named("jsonParser")
            Parser parser,
            @Named("LISProblem")
            String fileName,
            Map<String, Compare> compareMap) {
        super(parser, fileName, compareMap);
    }

    @Override
    protected TestCases getTestCases() {
        return parser.parse(getConfigFile(), new TypeToken<>() {});
    }

    @Override
    public GenericOutput<Integer> solveProblem(GenericInput<Integer[]> input) {
        GenericOutput<Integer> output = new GenericOutput<>();
        // int lis = dfs(input.getValue(), 0, Integer.MIN_VALUE, 0);

        res = 0;

        if(input.getValue().length == 0) {
            output.setValue(0);
            return output;
        }

        dfsMemo(input.getValue(), 0, new int[input.getValue().length]);

        output.setValue(res);

        return output;
    }

    // brute force
    public int dfs(Integer[] arr, int startIdx, int prevValue, int lisSoFar) {

        // This makes sense since LIS of an individual element in an array is 1
        if (startIdx == arr.length) {
            return lisSoFar;
        }

        int ans = 0;

        if (prevValue < arr[startIdx]) {
            // subseq continues with current element in it
            ans = Math.max(ans, dfs(arr, startIdx + 1, arr[startIdx], lisSoFar + 1));
        }
        // subseq continues without current element in it
        ans = Math.max(ans, dfs(arr, startIdx + 1, prevValue, lisSoFar));

        return ans;
    }

    // O(2^N) to O(N^2)
    public void dfsMemo(Integer[] arr, int startIdx, int[] memo) {
        // This makes sense since LIS of an individual element in an array is 1
        if (startIdx == arr.length) {
            return;
        }

        int ans = 1;

        for (int idx = 0; idx < startIdx; idx++) {
            // if it is comparatively increasing, then get LIS from state
            // of else leave it at default, 1
            if(arr[startIdx] > arr[idx]) {
                ans = Math.max(memo[idx] + 1, ans);
            }
        }

        memo[startIdx] = ans;

        res = Math.max(res, ans);

        dfsMemo(arr, startIdx + 1, memo);

    }
}
