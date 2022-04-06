package solutions.arrays;

import common.TestUtil;
import org.junit.jupiter.api.Test;
import problems.arrays.SelectionSortProblem;

class SelectionSortSolutionTest {

    private final SelectionSortSolution selectionSortSolution = new SelectionSortSolution();
    private final SelectionSortProblem selectionSortProblem = new SelectionSortProblem();

    @Test
    public void testSolve() {
        TestUtil.runAssertions(selectionSortProblem, selectionSortSolution);
    }
}
