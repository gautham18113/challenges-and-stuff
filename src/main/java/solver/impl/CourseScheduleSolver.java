package solver.impl;

import com.google.common.reflect.TypeToken;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import model.TestCases;
import parser.Parser;
import problem.compare.Compare;
import problem.input.impl.CourseScheduleInput;
import problem.output.impl.GenericOutput;
import solver.BaseSolver;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CourseScheduleSolver extends BaseSolver<CourseScheduleInput, GenericOutput<Boolean>> {

    @Inject
    public CourseScheduleSolver(
            @Named("jsonParser")
            Parser parser,
            @Named("courseScheduleProblem")
            String fileName,
            Map<String, Compare> compareMap) {
        super(parser, fileName, compareMap);
    }

    public TestCases getTestCases() {
        return parser.parse(getConfigFile(), new TypeToken<>() {
        });
    }

    public GenericOutput<Boolean> solveProblem(CourseScheduleInput input) {

        // Arrange
        // Construct dependency graph and in-edge map
        Map<Integer, List<Integer>> graph =
                constructDependencyGraph(input.getPrerequisites(), input.getN());
        Map<Integer, Integer> inEdgeMap = constructInEdgeMap(graph);

        // Perform topological ordering, if it is possible to form a topological order
        List<Integer> topoSorted = topoSort(graph, inEdgeMap);

        // then return true, else return false
        Boolean result = topoSorted.size() == input.getN();

        GenericOutput<Boolean> output = new GenericOutput<>();
        output.setValue(result);
        return output;
    }

    public List<Integer> topoSort(Map<Integer, List<Integer>> graph,
                                  Map<Integer, Integer> inEdgeMap) {

        // Kahn's algorithm
        // Create queue
        Deque<Integer> queue = new ArrayDeque<>();

        // Find nodes with 0 in edges and add them to queue
        // If such nodes don't exist, return null
        queue.addAll(
                inEdgeMap.keySet().stream().filter(key -> inEdgeMap.get(key) == 0).collect(
                        Collectors.toList())
        );

        List<Integer> topoSorted = new ArrayList<>();

        // Perform Kahn's Algorithm
        while (!queue.isEmpty()) {

            // pop from queue
            Integer current = queue.pop();
            topoSorted.add(current);

            // remove current element from neighbor's in edge count
            for (Integer neighbor : graph.get(current)) {
                inEdgeMap.put(neighbor, inEdgeMap.get(neighbor) - 1);
                // add neighbor with in edge count equal to 0 to queue
                if (inEdgeMap.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }

        }

        return topoSorted;

    }

    private Map<Integer, List<Integer>> constructDependencyGraph(Integer[][] prerequisites, int n) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        IntStream.range(0, n).boxed().forEach(num -> graph.put(num, new ArrayList<>()));

        for (Integer[] prereq : prerequisites) {
            Integer from = prereq[0];
            Integer to = prereq[1];

            graph.get(from).add(to);
        }

        return graph;
    }

    private Map<Integer, Integer> constructInEdgeMap(Map<Integer, List<Integer>> graph) {
        Map<Integer, Integer> inEdge = new HashMap<>();
        graph.keySet().forEach(key -> inEdge.put(key, 0));
        graph.values().forEach(
                value -> value.stream().forEach(child -> inEdge.put(child, inEdge.get(child) + 1)));
        return inEdge;
    }
}
