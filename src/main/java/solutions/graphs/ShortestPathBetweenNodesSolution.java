package solutions.graphs;

import core.Solution;
import core.io.Input;
import core.io.Output;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestPathBetweenNodesSolution implements Solution {
    @Override
    public Output<?> solve(Input<?> input) {

        List<Input> inputs = (List<Input>) input.getInput();
        List<List<Integer>> graph = (List<List<Integer>>) inputs.get(0).getInput();
        Integer target = (Integer) inputs.get(2).getInput();

        return new Output<>(bfs(graph, target));
    }

    private int bfs(List<List<Integer>> graph, Integer targetNode) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        Boolean[] visited = new Boolean[graph.size()];
        Arrays.fill(visited, false);

        queue.add(0);

        int edge = -1;

        while(!queue.isEmpty()) {

            int queueSize = queue.size();

            edge++;

            for (int i=0; i<queueSize; i++) {

                int node = queue.pop();

                if (visited[node]) { continue; }

                if (node == targetNode) { return edge; }

                queue.addAll(graph.get(node));

                visited[node] = true;
            }
        }

        return edge;
    }
}
