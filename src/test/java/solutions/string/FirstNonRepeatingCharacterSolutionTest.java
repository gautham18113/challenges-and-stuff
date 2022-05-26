package solutions.string;

import common.TestUtil;
import org.junit.jupiter.api.Test;
import problems.string.FirstNonRepeatingCharacterProblem;

class FirstNonRepeatingCharacterSolutionTest {
    FirstNonRepeatingCharacterSolution firstNonRepeatingCharacterSolution = new FirstNonRepeatingCharacterSolution();
    FirstNonRepeatingCharacterProblem firstNonRepeatingCharacterProblem = new FirstNonRepeatingCharacterProblem();

    @Test
    void testSolve() {
        TestUtil.runAssertions(firstNonRepeatingCharacterProblem, firstNonRepeatingCharacterSolution);
    }
}
