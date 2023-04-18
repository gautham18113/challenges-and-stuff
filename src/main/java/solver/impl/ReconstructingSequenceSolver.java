package solver.impl;

import com.google.common.reflect.TypeToken;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import core.algorithm.TopologicalSortKahn;
import model.TestCases;
import parser.Parser;
import problem.compare.Compare;
import problem.input.impl.ReconstructingSequenceInput;
import problem.output.impl.GenericOutput;
import solver.BaseSolver;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class ReconstructingSequenceSolver
        extends BaseSolver<ReconstructingSequenceInput, GenericOutput<Boolean>> {

    @Inject
    public ReconstructingSequenceSolver(
            @Named("jsonParser")
            Parser parser,
            @Named("reconstructingSequenceProblem")
            String fileName,
            Map<String, Compare> compareMap) {
        super(parser, fileName, compareMap);
    }

    public GenericOutput<Boolean> solveProblem(ReconstructingSequenceInput input) {

        Integer[] original = input.getOriginal();
        Integer[][] sequences = input.getSeqs();

        // construct

        Map<Integer, List<Integer>> subsequenceMap = constructGraphFromSubsequence(sequences);

        // topological sort

        List<Integer> topologicalSorted = new TopologicalSortKahn<>(subsequenceMap).sort();

        // verify

        Boolean result = Optional.ofNullable(topologicalSorted).orElse(Collections.emptyList())
                .equals(original);

        GenericOutput output = new GenericOutput();

        output.setValue(result);

        return output;
    }

    private Map<Integer, List<Integer>> constructGraphFromSubsequence(Integer[][] subsequences) {
        Map<Integer, List<Integer>> subseqenceMap = new HashMap<>();

        for(Integer[] sequence: subsequences) {
            for(int i = 0; i<sequence.length; i++) {
                if (i == sequence.length - 1) {
                    if (!subseqenceMap.containsKey(sequence[i])) {
                        subseqenceMap.put(sequence[i], new ArrayList<>());
                    }
                }
                List<Integer> neighbors = subseqenceMap.getOrDefault(sequence[i], new ArrayList<>());
                if (!neighbors.contains(sequence[i])) {
                    neighbors.add(sequence[i]);
                }
            }
        }

        return subseqenceMap;
    }
    public TestCases<ReconstructingSequenceInput, GenericOutput<Boolean>> getTestCases() {
        return parser.parse(getConfigFile(), new TypeToken<>() {});
    }
}
