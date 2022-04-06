package solutions.arrays;

import common.TestUtil;
import org.junit.jupiter.api.Test;
import problems.arrays.InsertionSortProblem;

class InsertionSortSolutionTest {
    private final InsertionSortSolution insertionSortSolution = new InsertionSortSolution();
    private final InsertionSortProblem insertionSortProblem = new InsertionSortProblem();

    @Test
    void testSolve() {
        TestUtil.runAssertions(insertionSortProblem, insertionSortSolution);
    }
}
