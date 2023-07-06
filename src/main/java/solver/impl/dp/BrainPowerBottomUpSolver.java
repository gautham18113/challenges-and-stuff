package solver.impl.dp;

import com.google.common.reflect.TypeToken;
import model.TestCases;
import module.SolverType;
import parser.Parser;
import problem.compare.Compare;
import problem.input.impl.GenericInput;
import problem.output.impl.GenericOutput;
import solver.BaseSolver;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/solving-questions-with-brainpower/description/
 */
@SolverType
public class BrainPowerBottomUpSolver
        extends BaseSolver<GenericInput<List<List<Integer>>>, GenericOutput<Integer>> {

    @Inject
    public BrainPowerBottomUpSolver(
            @Named("jsonParser")
            Parser parser,
            @Named("brainPowerProblem")
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
    public GenericOutput<Integer> solveProblem(GenericInput<List<List<Integer>>> input) {
        List<List<Integer>> questions = input.getValue();

        int maxScore = bottomUp(questions);

        GenericOutput<Integer> output = new GenericOutput<>();

        output.setValue(maxScore);

        return output;
    }

    private int bottomUp(List<List<Integer>> questions) {
        int[] dp = new int[questions.size() + 1];
        int n = questions.size();

        // dp[i] = max score from dp[i] to dp[n - 1] where n is the size of questions

        for (int i = n - 1; i >= 0; i--) {
            int nextQn = i + questions.get(i).get(1) + 1;
            int score = questions.get(i).get(0);

            dp[i] = Math.max(
                    // pick
                    dp[Math.min(nextQn, n)] + score,
                    // don't pick
                    dp[i + 1]
            );
        }

        return dp[0];
    }

}
