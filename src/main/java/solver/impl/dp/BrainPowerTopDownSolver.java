package solver.impl.dp;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/solving-questions-with-brainpower/description/
 */
@SolverType
public class BrainPowerTopDownSolver
        extends BaseSolver<GenericInput<List<List<Integer>>>, GenericOutput<Integer>> {

    @Inject
    public BrainPowerTopDownSolver(
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

        int maxScore = dfs(0, questions, new HashMap<>());

        GenericOutput<Integer> output = new GenericOutput<>();

        output.setValue(maxScore);

        return output;
    }

    public int dfs(int startIdx, List<List<Integer>> questions, Map<Integer, Integer> memo) {
        if (startIdx >= questions.size()) {
            return 0;
        }

        if (memo.containsKey(startIdx)) {
            return memo.get(startIdx);
        }

        int nextIdx = startIdx + questions.get(startIdx).get(1) + 1;
        int score = Math.max(
                // pick current
                questions.get(startIdx).get(0) +
                        dfs(nextIdx, questions, memo),
                // skip current
                dfs(startIdx + 1, questions, memo)
        );

        memo.put(startIdx, score);

        return score;
    }


}
