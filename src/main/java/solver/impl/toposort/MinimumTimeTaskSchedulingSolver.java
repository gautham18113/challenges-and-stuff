package solver.impl.toposort;

import com.google.common.reflect.TypeToken;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import model.TestCases;
import solver.SolverType;
import parser.Parser;
import problem.compare.Compare;
import problem.input.impl.MinimumTimeTaskSchedulingInput;
import problem.output.impl.GenericOutput;
import solver.BaseSolver;

import java.util.*;
import java.util.stream.Collectors;

@SolverType
public class MinimumTimeTaskSchedulingSolver
        extends BaseSolver<MinimumTimeTaskSchedulingInput, GenericOutput<Integer>> {

    @Inject
    public MinimumTimeTaskSchedulingSolver(
            @Named("jsonParser")
            Parser parser,
            @Named("minimumTimeTaskSchedulingProblem")
            String fileName,
            Map<String, Compare> compareMap) {
        super(parser, fileName, compareMap);
    }

    public TestCases getTestCases() {
        return parser.parse(getConfigFile(), new TypeToken<>() {
        });
    }

    @Override
    public GenericOutput<Integer> solveProblem(MinimumTimeTaskSchedulingInput input) {

        // Arrange
        List<String> tasks = input.getTasks();
        List<Integer> times = input.getTimes();
        String[][] requirements = input.getRequirements();

        Map<String, Integer> taskTimes = new HashMap<>();
        for (int idx = 0; idx < tasks.size(); idx++) {
            taskTimes.put(tasks.get(idx), times.get(idx));
        }

        // Construct dependency graph
        Map<String, List<String>> graph = constructDependencyGraph(requirements, tasks);

        // Construct in-edge graph
        Map<String, Integer> inEdges = new HashMap<>();
        graph.keySet().forEach(key -> inEdges.put(key, 0));
        graph.values().forEach(children -> children.forEach(child -> inEdges.put(child, inEdges.get(child) + 1)));

        // Topological sort to get minimum time
        Integer minimumDuration = topologicalSortWithTime(graph, taskTimes, inEdges);

        GenericOutput<Integer> output = new GenericOutput<>();
        output.setValue(minimumDuration);

        return output;

    }

    private Map<String, List<String>> constructDependencyGraph(String[][] requirements,
                                                               List<String> tasks) {
        Map<String, List<String>> graph = new HashMap<>();
        tasks.forEach(task -> graph.put(task, new ArrayList<>()));

        for (String[] requirement : requirements) {
            String from = requirement[0];
            String to = requirement[1];

            if (!graph.get(from).contains(to)) {
                graph.get(from).add(to);
            }

        }
        return graph;
    }


    private Integer topologicalSortWithTime(Map<String, List<String>> graph,
                                            Map<String, Integer> time,
                                            Map<String, Integer> inEdges) {

        // get task with 0 dependencies
        List<String> taskWithNoDeps =
                inEdges.keySet().stream().filter(e -> inEdges.get(e) == 0).collect(
                        Collectors.toList());

        // initialize result variable
        Integer timeTaken = 0;

        // initialize a time taken to reach vertex map
        Map<String, Integer> timeToReach = new HashMap<>();
        graph.keySet().forEach(key -> timeToReach.put(key, 0));

        // initialize queue
        Deque<String> queue = new ArrayDeque<>();

        // Add task with no dependencies to queue
        queue.addAll(taskWithNoDeps);

        // update timeTaken map with processing time of above tasks
        // since tasks are executed in parallel, the time taken is determined
        // by the time taken to complete the longest task
        for (String task : taskWithNoDeps) {
            timeToReach.put(task, time.get(task));
            timeTaken = Math.max(timeTaken, time.get(task));
        }

        // Perform BFS while keeping track of level
        while (!queue.isEmpty()) {

            // pop from queue
            String taskToExecute = queue.pop();

            // for each neighbor, reduce in edge count
            graph.get(taskToExecute).forEach(neighbor -> inEdges.put(neighbor, inEdges.get(neighbor) - 1));

            // for each neighbor of executed task, update time taken to complete.
            // update maximum time with maximum time to reach a neighbor if it is greater
            for (String neighbor : graph.get(taskToExecute)) {
                timeToReach.put(
                        neighbor,
                        Math.max(timeToReach.get(neighbor),
                                timeToReach.get(taskToExecute) + time.get(neighbor))
                );
                timeTaken = Math.max(timeTaken, timeToReach.get(neighbor));

                if(inEdges.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }

        }
        return timeTaken;
    }

}
