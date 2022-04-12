package solutions.arrays;

import common.TestUtil;
import org.junit.jupiter.api.Test;
import problems.arrays.SmallestDifferenceProblem;


class SmallestDifferenceSolutionTest {
    private static final SmallestDifferenceSolution smallestDifferenceSolution = new SmallestDifferenceSolution();
    private static final SmallestDifferenceProblem smallestDifferenceProblem = new SmallestDifferenceProblem();

    @Test
    public void testSolve(){
        TestUtil.runAssertionsMultipleParams(smallestDifferenceProblem, smallestDifferenceSolution);
    }

}