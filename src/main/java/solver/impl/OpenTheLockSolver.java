package solver.impl;

import com.google.common.reflect.TypeToken;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import model.TestCases;
import parser.Parser;
import problem.compare.Compare;
import problem.input.impl.OpenTheLockInput;
import problem.output.impl.GenericOutput;
import solver.BaseSolver;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/open-the-lock/
 */
public class OpenTheLockSolver extends BaseSolver<OpenTheLockInput, GenericOutput<Integer>> {

    private Parser<TestCases<OpenTheLockInput, GenericOutput<Integer>>> parser;

    @Inject
    public OpenTheLockSolver(
            @Named("jsonParser")
            Parser parser,
            @Named("openTheLockProblem")
            String fileName,
            Map<String, Compare> compareMap) {
        super(parser, fileName, compareMap);
        assert(Objects.nonNull(parser));
        this.parser = parser;
    }

    @Override
    public GenericOutput<Integer> solveProblem(OpenTheLockInput input) {
        String target = input.getTargetCombo();

        List<String> trappedCombos = input.getTrappedCombos();

        GenericOutput<Integer> output = new GenericOutput<>();

        Integer possiblePaths = bfs(target, trappedCombos);

        output.setValue(possiblePaths);

        return output;
    }

    private Integer bfs(String target, List<String> trappedCombos) {
        Deque<Integer[]> queue = new ArrayDeque<>();

        queue.add(new Integer[]{0, 0, 0, 0});

        Set<String> seen = new HashSet<>();

        int level = 0;

        while(!queue.isEmpty()) {

            int queueSize = queue.size();

            for (int queueIdx = 0; queueIdx < queueSize; queueIdx++) {
                Integer[] combo = queue.pop();

                String stringValueOfCombo = Arrays.stream(combo)
                        .collect(Collectors.toList())
                        .stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining());

                if (seen.contains(stringValueOfCombo)) {
                    continue;
                }

                seen.add(stringValueOfCombo);

                if (target.equals(stringValueOfCombo)) {
                    return level;
                }

                if (trappedCombos.contains(stringValueOfCombo)) {
                    continue;
                }

                // Neighbors are flip backward and flip forward in all
                // elements in combo list
                for (int i =0; i < 4; i++) {
                    for(Integer neighbor: getNeighbors(combo[i])) {
                        Integer[] newCombo = Arrays.copyOf(combo, combo.length);
                        newCombo[i] = neighbor;
                        queue.add(newCombo);
                    }
                }
            }

            level++;

        }

        return -1;
    }

    private Integer[] getNeighbors(Integer current) {
        if (current == 9) {
            return new Integer[]{8, 0};
        } else if (current == 0) {
            return new Integer[]{9, 1};
        } else {
            return new Integer[]{current - 1, current + 1};
        }
    }

    protected TestCases<OpenTheLockInput, GenericOutput<Integer>> getTestCases() {
        return parser.parse(getConfigFile(), new TypeToken<>() {});
    }
}
