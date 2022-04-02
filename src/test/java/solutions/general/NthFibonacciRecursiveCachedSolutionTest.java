package solutions.general;

import core.TestCase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import problems.general.NthFibonacciProblem;

class NthFibonacciRecursiveCachedSolutionTest {
    private final NthFibonacciRecursiveCachedSolution nthFibonacciRecursiveCachedSolution = new NthFibonacciRecursiveCachedSolution();
    private final NthFibonacciProblem nthFibonacciProblem = new NthFibonacciProblem();

    @Test
    void testSolve() {
        for(TestCase test: nthFibonacciProblem.getProblem().getTestCases()) {
            Assertions
                .assertThat(nthFibonacciRecursiveCachedSolution.solve(test.getInputs().get(0)).getOutput())
                .isEqualTo(test.getOutput().getOutput());
        }
    }

}
