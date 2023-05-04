package solver.impl.dp.knapsack;

import com.google.common.reflect.TypeToken;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import model.TestCases;
import parser.Parser;
import problem.compare.Compare;
import problem.input.impl.GenericInput;
import problem.output.impl.GenericOutput;
import solver.BaseSolver;

import java.util.Map;

public class TriangleBottomUpSolver
        extends BaseSolver<GenericInput<Integer[][]>, GenericOutput<Integer>> {
    @Inject
    public TriangleBottomUpSolver(
            @Named("jsonParser")
            Parser parser,
            @Named("triangleProblem")
            String fileName,
            Map<String, Compare> compareMap) {
        super(parser, fileName, compareMap);
    }

    public TestCases getTestCases() {
        return parser.parse(getConfigFile(), new TypeToken<>() {
        });
    }

    @Override
    public GenericOutput<Integer> solveProblem(GenericInput<Integer[][]> input) {

        Integer[][] triangle = input.getValue();

        // the bottom up dp array is just an inverted triangle which will store the sub problem
        // results
        int[][] dp = new int
                // last row length in triangle should be first row length in dp array
                [triangle[triangle.length - 1].length]
                // first row length in triangle should be last row length in dp array
                [triangle.length];

        for (int row = 0; row < dp.length; row++) {
            int triRow = triangle.length - 1 - row;
            for (int col = 0; col < triangle[triRow].length; col++) {
                // convert dp inverted idx to triangle idx
                // only row is inverted, column is the same
                int triCol = col;

                // base
                // this is the last row in the triangle, which is the leaf level
                // if we imagine it from top-down perspective.
                if (row == 0) {
                    dp[row][col] = triangle[triRow][triCol];
                     continue;
                }
                // minimum of adjacent columns in row above
                dp[row][col] =
                        Math.min(dp[row - 1][col], dp[row - 1][col + 1]) +
                                triangle[triRow][triCol];
            }
        }

        int result = dp[dp.length - 1][0];

        GenericOutput<Integer> output = new GenericOutput<>();
        output.setValue(result);

        return output;
    }

}

