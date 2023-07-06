package solver.impl.toposort;

import com.google.common.reflect.TypeToken;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import model.TestCases;
import module.SolverType;
import parser.Parser;
import problem.compare.Compare;
import problem.input.impl.ReconstructingSequenceInput;
import problem.output.impl.GenericOutput;
import solver.BaseSolver;

import java.util.*;

/**
 * https://leetcode.com/problems/sequence-reconstruction/
 */
@SolverType
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

        List<Integer> topologicalSorted = topoSort(subsequenceMap);

        // verify

        Boolean result = List.of(original).equals(topologicalSorted);

        GenericOutput output = new GenericOutput();

        output.setValue(result);

        return output;
    }

    private Map<Integer, List<Integer>> constructGraphFromSubsequence(Integer[][] subsequences) {
        Map<Integer, List<Integer>> subseqenceMap = new HashMap<>();

        for (Integer[] subsequence : subsequences) {
            for (int i = 0; i < subsequence.length; i++) {
                // add element at end of list to map, and have empty array list as it's value
                // if it does not exist.
                if (i == subsequence.length - 1) {
                    if (!subseqenceMap.containsKey(subsequence[i])) {
                        subseqenceMap.put(subsequence[i], new ArrayList<>());
                    }
                    continue;
                }
                // add new graph vertex if it does not exist
                if (!subseqenceMap.containsKey(subsequence[i])) {
                    subseqenceMap.put(subsequence[i], new ArrayList<>());
                }
                // add edge to vertex
                List<Integer> neighbors = subseqenceMap.get(subsequence[i]);
                if (!neighbors.contains(subsequence[i + 1])) {
                    neighbors.add(subsequence[i + 1]);
                }
            }
        }

        return subseqenceMap;
    }

    private List<Integer> topoSort(Map<Integer, List<Integer>> graph) {
        Map<Integer, Integer> inEdgeMap = new HashMap<>();

        // Populate in-edge map
        graph.forEach((k, v) -> {
            // Add unvisited vertex to map
            if (!inEdgeMap.containsKey(k)) {
                inEdgeMap.put(k, 0);
            }
            for (Integer neighbor : v) {
                // Add unvisited neighbor to map
                if (!inEdgeMap.containsKey(neighbor)) {
                    inEdgeMap.put(neighbor, 0);
                }
                // increase in-edge count of neighbor
                inEdgeMap.put(neighbor, inEdgeMap.get(neighbor) + 1);
            }
        });

        // Add vertex with 0 in-edges to queue
        Deque<Integer> queue = new ArrayDeque<>();
        inEdgeMap.forEach((k, v) -> {
            if (v == 0) {
                queue.add(k);
            }
        });

        // Array to store topologically sorted vertices
        List<Integer> toposorted = new ArrayList<>();

        while (!queue.isEmpty()) {

            // If queue size is greater than one, then there is more than
            // one way to construct the topological sorted array. Hence, the
            // sequence is not unique.
            if (queue.size() > 1) {
                return null;
            }

            Integer current = queue.pop();
            toposorted.add(current);

            // Reduce in-edge count of neighbor of current vertex by 1
            for (Integer neighbor : graph.get(current)) {
                int neighborInEdgeCount = inEdgeMap.get(neighbor);

                inEdgeMap.put(neighbor, neighborInEdgeCount - 1);

                if (neighborInEdgeCount - 1 == 0) {
                    queue.add(neighbor);
                }
            }

        }

        return toposorted.size() == graph.size() ? toposorted : null;
    }

    public TestCases<ReconstructingSequenceInput, GenericOutput<Boolean>> getTestCases() {
        return parser.parse(getConfigFile(), new TypeToken<>() {
        });
    }
}
