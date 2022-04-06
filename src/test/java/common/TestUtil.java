package common;

import core.ProblemInterface;
import core.Solution;
import core.TestCase;
import core.io.Input;
import org.assertj.core.api.Assertions;

public class TestUtil {

    public static void runAssertions(
        ProblemInterface problem,
        Solution solution
    ) {
        for(TestCase test: problem.getProblem().getTestCases()) {
            Assertions
                .assertThat(solution.solve(test.getInputs().get(0)).getOutput())
                .isEqualTo(test.getOutput().getOutput());

        }
    }

    public static void runAssertionsMultipleParams(
        ProblemInterface problem,
        Solution solution
    ) {
        for(TestCase test: problem.getProblem().getTestCases()) {
            Assertions
                .assertThat(solution.solve(new Input<>(test.getInputs())).getOutput())
                .isEqualTo(test.getOutput().getOutput());
        }
    }
}
