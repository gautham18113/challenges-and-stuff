package solutions.arrays;

import org.junit.jupiter.api.Test;

import common.TestUtil;
import problems.arrays.TaskAssignmentProblem;

public class TaskAssignmentSolutionTest {

    private final TaskAssignmentSolution solution = new TaskAssignmentSolution();
    private final TaskAssignmentProblem problem = new TaskAssignmentProblem();

    @Test
    public void testSolution() {
        TestUtil.runAssertionsMultipleParams(problem, solution);
    }
}
