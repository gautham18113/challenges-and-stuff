package solutions.arrays;

import common.TestUtil;
import org.junit.jupiter.api.Test;
import problems.arrays.MonotonicArrayProblem;

class MonotonicArraySolutionTest {
    private final MonotonicArraySolution monotonicArraySolution = new MonotonicArraySolution();
    private final MonotonicArrayProblem monotonicArrayProblem = new MonotonicArrayProblem();

    @Test
    void testSolve() {
        TestUtil.runAssertions(monotonicArrayProblem, monotonicArraySolution);
    }
}
