package solutions.arrays;

import common.TestUtil;
import core.TestCase;
import core.io.Input;
import core.io.Output;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import problems.arrays.NestedProductSumProblem;

class NestedProductSumSolutionTest {
    private final NestedProductSumSolution nestedProductSumSolution = new NestedProductSumSolution();
    private final NestedProductSumProblem nestedProductSumProblem = new NestedProductSumProblem();

    @Test
    void testSolve() {
        TestUtil.runAssertions(nestedProductSumProblem, nestedProductSumSolution);
    }
}
