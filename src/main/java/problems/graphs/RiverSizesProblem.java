package problems.graphs;

import java.util.Arrays;

import core.Problem;
import core.ProblemInterface;
import core.TestCase;

public class RiverSizesProblem implements ProblemInterface{

    @Override
    public Problem getProblem() {
        return Problem.builder()
        .withTestCase(
            TestCase.builder()
            .withInput(
                new int[][] {
                   new int[] {1,0,0,1,0},
                   new int[] {1,0,1,0,0},
                   new int[] {0,0,1,0,1},
                   new int[] {1,0,1,0,1},
                   new int[] {1,0,1,1,0}
                }
            )
            .withOutput(Arrays.asList(1,2,2,2,5))
            .build()
        )
        .build();
    }

}
