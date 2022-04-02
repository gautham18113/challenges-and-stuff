package solutions.linkedlist;

import core.TestCase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import problems.linkedlist.RemoveDuplicatesInSortedLLProblem;

class RemoveDuplicatesInSortedLLSolutionTest {
    RemoveDuplicatesInSortedLLSolution removeDuplicatesInSortedLLSolution = new RemoveDuplicatesInSortedLLSolution();
    RemoveDuplicatesInSortedLLProblem removeDuplicatesInSortedLLProblem = new RemoveDuplicatesInSortedLLProblem();

    @Test
    void testSolve() {

        for(TestCase test: removeDuplicatesInSortedLLProblem.getProblem().getTestCases()) {
            Assertions
                .assertThat(
                    removeDuplicatesInSortedLLSolution.solve(
                        test.getInputs().get(0)).getOutput())
                .isEqualTo(
                    test.getOutput().getOutput()
                );
        }

    }
}
