package problems.arrays;

import core.Problem;
import core.ProblemInterface;
import core.TestCase;
import core.io.Input;
import core.io.Output;

public class InsertionSortProblem implements ProblemInterface {
    @Override
    public Problem getProblem() {
        return Problem.builder()
            .withTestCase(
                TestCase.builder()
                    .withInput(new Input<>(new int[] {8, 5, 2, 9, 5, 6, 3}))
                    .withOutput(new Output<>(new int[] {2, 3, 5, 5, 6, 8, 9}))
                    .build()
            )
            .build();
    }
}
