package core.algorithm;

import java.sql.Array;
import java.util.*;

/**
 * Kahn's algorithm is used to obtain a Topological Order of the elements of a directed graph.
 *
 * Topological order simply means that every node that the current node points to appears after
 * the current node. So it is not strictly increasing or decreasing, it just means that a node
 * further down in the ordering is a node that is directly or indirectly an out-edge of another
 * node behind it.
 *
 * It solves the problem that, given a directed graph, and we need to remove a node, does there
 * exist a way such that removing a node guarantees that there are no other nodes pointing to
 * the node being removed. i.e. there are no in-edges.
 *
 * Topological sort is very similar to BFS, the only difference is that we only push nodes with
 * 0 in-degree into the queue.
 *
 */
public class TopologicalSortKahn<T> {

    private Map<T, List<T>> graph;
    public TopologicalSortKahn(Map<T, List<T>> graph) {
        this.graph = graph;
    }

    public List<T> sort() {

        Deque<T> queue = new ArrayDeque<>();
        Map<T, Integer> inEdgeMap = getInEdgeMap();
        List<T> result = new ArrayList<>();

        // create a map of node -> number of in edges
        graph.entrySet().forEach(e -> {
            if (inEdgeMap.get(e.getKey()) == 0) {
                queue.add(e.getKey());
            }
        });

        while(!queue.isEmpty()) {
            T current = queue.pop();
            result.add(current);

            for (T neighbor: graph.get(current)) {
                // loop through every neighbor and reduce
                // in edge count contributed to that neighbor
                // by the current node
                int inEdge = inEdgeMap.get(neighbor);
                inEdgeMap.put(neighbor, inEdge - 1);

                if (inEdge - 1 == 0) {
                    // if any neighbor has 0 in edges, then
                    // add it to queue
                    queue.add(neighbor);
                }
            }
        }

        return result.size() != graph.size() ? null : result;

    }

    private Map<T, Integer> getInEdgeMap() {
        Map<T, Integer> inEdgeMap = new HashMap<>();

        this.graph.entrySet().forEach(e -> {
            if (!inEdgeMap.containsKey(e.getKey())) {
                inEdgeMap.put(e.getKey(), 0);
            }
            for(T node: e.getValue()) {
                int inEdges = inEdgeMap.getOrDefault(node, 0);
                inEdgeMap.put(node, inEdges + 1);
            }
        });

        return inEdgeMap;
    }

}
