package problems.arrays;

import core.Problem;
import core.ProblemInterface;
import core.TestCase;

public class SpiralTraverseProblem implements ProblemInterface {

    @Override
    public Problem getProblem() {
        return Problem.builder()
                .withTestCase(
                        TestCase.builder()
                                .withInput(new int[][]{
                                        {1,2,3,4},
                                        {12,13,14,5},
                                        {11,16,15,6},
                                        {10,9,8,7}
                                })
                                .withOutput(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16})
                                .build()
                )
                .withTestCase(
                        TestCase.builder()
                                .withInput(new int[][]{
                                        {4, 2, 3, 6, 7, 8, 1, 9, 5, 10},
                                        {12, 19, 15, 16, 20, 18, 13, 17, 11, 14}
                                })
                                .withOutput(
                                        new int[]{4, 2, 3, 6, 7, 8, 1, 9, 5, 10, 14, 11, 17, 13, 18, 20, 16, 15, 19, 12}
                                )
                                .build()
                )
                .build();
    }
}
