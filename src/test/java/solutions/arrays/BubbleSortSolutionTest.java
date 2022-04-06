package solutions.arrays;

import common.TestUtil;
import org.junit.jupiter.api.Test;
import problems.arrays.BubbleSortProblem;

class BubbleSortSolutionTest {
    private final BubbleSortSolution bubbleSortSolution = new BubbleSortSolution();
    private final BubbleSortProblem bubbleSortProblem = new BubbleSortProblem();

    @Test
    void testSolve() {
        TestUtil.runAssertions(bubbleSortProblem, bubbleSortSolution);
    }
}
