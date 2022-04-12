package solutions.arrays;

import common.TestUtil;
import org.junit.jupiter.api.Test;
import problems.arrays.MoveElementToEndProblem;

class MoveElementToEndSolutionTest {
    private final MoveElementToEndSolution moveElementToEndSolution = new MoveElementToEndSolution();
    private final MoveElementToEndProblem moveElementToEndProblem = new MoveElementToEndProblem();

    @Test
    void testSolve() {
        TestUtil.runAssertionsMultipleParams(moveElementToEndProblem, moveElementToEndSolution);
    }
}
