package problems.graphs;

import core.AbstractProblem;
import core.Problem;
import core.TestCase;

import java.lang.reflect.Array;
import java.util.Arrays;


public class ShortestPathBetweenNodesProblem extends AbstractProblem {

    /**
     * Given an (unweighted) connected graph, return the length of the shortest path between two nodes A and B, in terms of the number of edges.
     *
     * Input:
     *
     * graph = [[1, 2], [0, 2, 3], [0, 1], [1]]
     * A = 0
     * B = 3
     *
     * Output
     *
     * 2
     *
     * @return
     */
    @Override
    public Problem getProblem() {
        return Problem.builder()
                .withTestCase(
                        TestCase.builder()
                                .withInput(Arrays.asList(
                                        Arrays.asList(1, 2),
                                        Arrays.asList(0,2,3),
                                        Arrays.asList(0,1),
                                        Arrays.asList(1)
                                ))
                                .withInput(0)
                                .withInput(3)
                                .withOutput(2)
                                .build()
                )
                .build();
    }
}
