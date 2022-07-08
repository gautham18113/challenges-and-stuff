package problems.graphs;

import core.Problem;
import core.ProblemInterface;
import core.TestCase;

public class CycleInGraphProblem implements ProblemInterface {

    /**
     * <div>
     * <p>
     *   You're given a list of <span>edges</span> representing an unweighted, directed
     *   graph with at least one node. Write a function that returns a boolean
     *   representing whether the given graph contains a cycle.
     * </p>
     * <p>
     *   For the purpose of this question, a cycle is defined as any number of
     *   vertices, including just one vertex, that are connected in a closed chain. A
     *   cycle can also be defined as a chain of at least one vertex in which the first
     *   vertex is the same as the last.
     * </p>
     * <p>
     *   The given list is what's called an adjacency list, and it represents a graph.
     *   The number of vertices in the graph is equal to the length of
     *   <span>edges</span>, where each index <span>i</span> in
     *   <span>edges</span> contains vertex <span>i</span>'s outbound edges, in no
     *   particular order. Each individual edge is represented by a positive integer
     *   that denotes an index (a destination vertex) in the list that this vertex is
     *   connected to. Note that these edges are directed, meaning that you can only
     *   travel from a particular vertex to its destination, not the other way around
     *   (unless the destination vertex itself has an outbound edge to the original
     *   vertex).
     * </p>
     * <p>
     *   Also note that this graph may contain self-loops. A self-loop is an edge that
     *   has the same destination and origin; in other words, it's an edge that
     *   connects a vertex to itself. For the purpose of this question, a self-loop is
     *   considered a cycle.
     * </p>
     * <h3>Sample Input</h3>
     * <pre><span class="">edges</span> = [
     *   [1, 3],
     *   [2, 3, 4],
     *   [0],
     *   [],
     *   [2, 5],
     *   [],
     * ]
     * </pre>
     * <h3>Sample Output</h3>
     * <pre>true
     * <span class="">// There are multiple cycles in this graph: </span>
     * <span class="">// 1) 0 -&gt; 1 -&gt; 2 -&gt; 0</span>
     * <span class="">// 2) 0 -&gt; 1 -&gt; 4 -&gt; 2 -&gt; 0</span>
     * <span class="">// 3) 1 -&gt; 2 -&gt; 0 -&gt; 1</span>
     * <span class="">// These are just 3 examples; there are more.</span>
     * </pre>
     * </div>
     */
    @Override
    public Problem getProblem() {
        return Problem.builder()
        .withTestCase(
            TestCase.builder()
            .withInput(new int[][]{
                {1, 3},
                {2, 3, 4},
                {0},
                {},
                {2, 5},
                {}
            })
            .withOutput(true)
            .build()
        )
        .build();
    }

}
