package solutions.arrays;

import common.TestUtil;
import core.io.Input;
import core.io.Output;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import problems.arrays.SpiralTraverseProblem;

class SpiralTraverseSolutionTest {
    SpiralTraverseSolution spiralTraverseSolution = new SpiralTraverseSolution();
    SpiralTraverseProblem spiralTraverseProblem = new SpiralTraverseProblem();

    @Test
    void testSolve() {
        TestUtil.runAssertions(spiralTraverseProblem, spiralTraverseSolution);
    }
}