package problems.arrays;

import core.Problem;
import core.ProblemInterface;
import core.TestCase;

public class NumberOfWaysToMakeChangeProblem implements ProblemInterface{

    /*
     * https://www.algoexpert.io/questions/number-of-ways-to-make-change
     */
    @Override
    public Problem getProblem() {
        return Problem.builder()
        .withTestCase(
            TestCase.builder().withInput(6).withInput(new int[]{1, 5}).withOutput(2).build()
        )
        .withTestCase(TestCase.builder().withInput(5).withInput(new int[]{1,2,5}).withOutput(4).build())
        .build();
    }

}
