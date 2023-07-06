package solver.impl.twopointer;

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

/* https://leetcode.com/problems/container-with-most-water
    This problem has 3 variables in it, length of left side, length of right side and width of
    the container. I guess that to optimize a O(n^2) solution to O(n), we need to fix two of the variables.

    So, we fix the width by initializing two pointers at either end, hence maximizing the width.
    Next we maximize the length by realizing the fact that the max area of water stored is determined
    by the shorter length. So, at every step, we store the area (if it is greater) and discard the
    side with shorter length until the pointers are on top of each other.
 */
@SolverType
public class ContainerWithMostWaterSolver
        extends BaseSolver<GenericInput<Integer[]>, GenericOutput<Integer>> {
    @Inject
    public ContainerWithMostWaterSolver(
            @Named("jsonParser")
            Parser parser,
            @Named("containerWithMostWaterProblem")
            String fileName,
            Map<String, Compare> compareMap) {
        super(parser, fileName, compareMap);
    }

    @Override
    protected TestCases<GenericInput<Integer[]>, GenericOutput<Integer>> getTestCases() {
        return parser.parse(getConfigFile(), new TypeToken<>() {
        });
    }

    @Override
    public GenericOutput<Integer> solveProblem(GenericInput<Integer[]> input) {

        Integer[] containers = input.getValue();

        // Maximize width
        int l = 0;
        int r = containers.length - 1;

        int maxArea = 0;

        while(l < r) {

            // area is determined by shorter side
            int currentArea = Math.min(containers[r], containers[l]) * (r - l);

            // drop shorter side and try to optimize
            if(containers[r] < containers[l]) {
                r--;
            } else {
                l++;
            }

            maxArea = Math.max(currentArea, maxArea);

        }

        GenericOutput<Integer> output = new GenericOutput<>();
        output.setValue(maxArea);
        return output;
    }
}
