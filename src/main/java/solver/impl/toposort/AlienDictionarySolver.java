package solver.impl.toposort;

import com.google.common.reflect.TypeToken;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import model.TestCases;
import solver.SolverType;
import parser.Parser;
import problem.compare.Compare;
import problem.input.impl.GenericInput;
import problem.output.impl.GenericOutput;
import solver.BaseSolver;

import java.util.*;
import java.util.stream.Collectors;

@SolverType
public class AlienDictionarySolver
        extends BaseSolver<GenericInput<List<String>>, GenericOutput<String>> {

    @Inject
    public AlienDictionarySolver(
            @Named("jsonParser")
            Parser parser,
            @Named("alienDictionaryProblem")
            String fileName,
            Map<String, Compare> compareMap) {
        super(parser, fileName, compareMap);
    }

    public TestCases getTestCases() {
        return parser.parse(getConfigFile(), new TypeToken<>() {
        });
    }

    public GenericOutput<String> solveProblem(GenericInput<List<String>> input) {
        List<String> words = input.getValue();

        // Use topological sort to construct the topological order of words
        // If there are multiple values in the queue which might cause inconsistency
        // then use lexical ordering.

        // construct dependency graph
        Map<Character, List<Character>> graph = constructDependencyGraph(words);

        // construct in-edge graph
        Map<Character, Integer> inEdgeGraph = constructInEdgeGraph(graph);

        // perform topological sort in lexicographic order
        String result = topologicalSort(graph, inEdgeGraph);

        GenericOutput<String> output = new GenericOutput<>();
        output.setValue(result);
        return output;
    }

    private Map<Character, List<Character>> constructDependencyGraph(List<String> words) {
        Map<Character, List<Character>> graph = new HashMap<>();

        words.forEach(word -> {
            for (int i = 0; i < word.length(); i++) {
                graph.put(word.charAt(i), new ArrayList<>());
            }
        });

        // dependency construction is by words, since words in the dictionary
        // are arranged in lexicographical order, for two adjacent words a and b,
        // first character of a comes before first character of b. Second character of a comes
        // before second character of b and so on

        // using  this logic to construct the dependency graph

        for (int i = 1; i < words.size(); i++) {
            String prev = words.get(i - 1);
            String curr = words.get(i);

            int length = Math.min(prev.length(), curr.length());

            // compare character from previous string with corresponding  character at the
            // same index in lexicographically adjacent string
            for (int j = 0; j < length; j++) {
                Character prevChar = prev.charAt(j);
                Character currChar = curr.charAt(j);
                if (prevChar != currChar) {
                    if (!graph.get(prevChar).contains(currChar)) {
                        graph.get(prevChar).add(currChar);
                    }
                }
            }
        }
        return graph;
    }

    private Map<Character, Integer> constructInEdgeGraph(Map<Character, List<Character>> graph) {

        Map<Character, Integer> inEdgeMap = new HashMap<>();

        graph.keySet().forEach(key -> inEdgeMap.put(key, 0));

        for (Map.Entry<Character, List<Character>> entry : graph.entrySet()) {

            entry.getValue()
                    .forEach(neighbor -> inEdgeMap.put(neighbor, inEdgeMap.get(neighbor) + 1));

        }

        return inEdgeMap;
    }

    private String topologicalSort(Map<Character, List<Character>> graph,
                                   Map<Character, Integer> inEdgeMap) {

        PriorityQueue<Character> queue = new PriorityQueue<>();
        // Add all edges with 0 in-edges to queue
        queue.addAll(
                inEdgeMap.keySet().stream().filter(e -> inEdgeMap.get(e) == 0)
                        .collect(Collectors.toList())
        );

        // create result collector
        List<Character> topoSorted = new ArrayList<>();

        // loop through queue following kahns algorithm
        while (!queue.isEmpty()) {
            // polling from heap will ensure lower lexical order
            Character node = queue.poll();

            topoSorted.add(node);

            // decrease in-edge count of current node's neighbors by 1
            for (Character neighbor : graph.get(node)) {
                int inEdges = inEdgeMap.get(neighbor);
                inEdgeMap.put(neighbor, inEdges - 1);
                // if there are no in edges then add it to queue
                if (inEdges - 1 == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return topoSorted.stream().map(String::valueOf).collect(Collectors.joining());

    }
}
