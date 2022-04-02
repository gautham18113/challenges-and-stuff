package solutions.arrays;

import core.io.Input;
import core.TestCase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import problems.arrays.TandemBicycleProblem;

class TandemBicycleSolutionTest {
    private final TandemBicycleSolution tandemBicycleSolution = new TandemBicycleSolution();
    private final TandemBicycleProblem tandemBicycleProblem = new TandemBicycleProblem();

    @Test
    void testSolve() {
        for(TestCase test: tandemBicycleProblem.problem.getTestCases()) {
            Assertions
                .assertThat(
                    tandemBicycleSolution.solve(new Input<>(test.getInputs())).getOutput()
                )
                .isEqualTo(test.getOutput().getOutput());
        }
    }
}
