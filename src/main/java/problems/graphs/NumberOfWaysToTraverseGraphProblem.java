package problems.graphs;

import core.Problem;
import core.ProblemInterface;
import core.TestCase;

public class NumberOfWaysToTraverseGraphProblem implements ProblemInterface{

    @Override
    public Problem getProblem() {
        return Problem.builder()
        .withTestCase(
            TestCase.builder()
            /* width */
            .withInput(4)
            /* height */
            .withInput(3)
            .withOutput(10)
            .build()
        )
        .build();
    }

}
