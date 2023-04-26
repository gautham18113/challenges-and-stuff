package solver.impl;

import com.google.common.reflect.TypeToken;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import model.TestCases;
import parser.Parser;
import problem.compare.Compare;
import problem.input.impl.TwoSumUnsortedInput;
import problem.output.impl.GenericOutput;
import solver.BaseSolver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumUnsortedSolver
        extends BaseSolver<TwoSumUnsortedInput, GenericOutput<Integer[]>> {

    @Inject
    public TwoSumUnsortedSolver(
            @Named("jsonParser")
            Parser parser,
            @Named("twoSumUnsortedProblem")
            String fileName,
            Map<String, Compare> map) {
        super(parser, fileName, map);
    }

    @Override
    public TestCases getTestCases() {
        return parser.parse(getConfigFile(), new TypeToken<>() {
        });
    }

    @Override
    public GenericOutput<Integer[]> solveProblem(TwoSumUnsortedInput input) {
        List<Integer> array = input.getArray();
        Integer target = input.getTarget();

        // initiate prefix sum map that will contain sum of elements from 0 to i - 1
        Map<Integer, Integer> prefixSum = new HashMap<>();

        int runningSum = 0;
        for (int ptr = 0; ptr < array.size(); ptr++) {
            prefixSum.put(runningSum, ptr);
            runningSum += array.get(ptr);
            if (prefixSum.containsKey(runningSum - target)) {
                GenericOutput<Integer[]> output = new GenericOutput<>();
                output.setValue(new Integer[]{prefixSum.get(runningSum - target), ptr + 1});
                return output;
            }
        }

        return new GenericOutput<>();
    }
}
