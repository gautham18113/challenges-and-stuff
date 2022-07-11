package problems.arrays;

import java.util.Arrays;

import core.Problem;
import core.ProblemInterface;
import core.TestCase;

public class TaskAssignmentProblem implements ProblemInterface {

    /*
     * <div class="html">
     * <p>
     *   You're given an integer <span>k</span> representing a number of workers and an
     *   array of positive integers representing durations of tasks that must be
     *   completed by the workers. Specifically, each worker must complete two unique
     *   tasks and can only work on one task at a time. The number of tasks will always
     *   be equal to <span>2k</span> such that each worker always has exactly two tasks
     *   to complete. All tasks are independent of one another and can be completed in
     *   any order. Workers will complete their assigned tasks in parallel, and the
     *   time taken to complete all tasks will be equal to the time taken to complete
     *   the longest pair of tasks (see the sample output for an explanation).
     * </p>
     * <p>
     *   Write a function that returns the optimal assignment of tasks to each worker
     *   such that the tasks are completed as fast as possible. Your function should
     *   return a list of pairs, where each pair stores the indices of the tasks that
     *   should be completed by one worker. The pairs should be in the following
     *   format: <span>[task1, task2]</span>, where the order of <span>task1</span> and
     *   <span>task2</span> doesn't matter. Your function can return the pairs in any
     *   order. If multiple optimal assignments exist, any correct answer will be
     *   accepted.
     * </p>
     * <p>
     *   Note: you'll always be given at least one worker (i.e., <span>k</span> will
     *   always be greater than <b>0</b>).
     * </p>
     * <h3>Sample Input</h3>
     * <pre><span class="">k</span> = 3
     * <span class="">tasks</span> = [1, 3, 5, 3, 1, 4]
     * </pre>
     * <h3>Sample Output</h3>
     * <pre>[
     *   [0, 2], <span class="">// tasks[0] = 1, tasks[2] = 5 | 1 + 5 = 6</span>
     *   [4, 5], <span class="">// tasks[4] = 1, tasks[5] = 4 | 1 + 4 = 5</span>
     *   [1, 3], <span class="">// tasks[1] = 3, tasks[3] = 3 | 3 + 3 = 6</span>
     * ] <span class="">// The fastest time to complete all tasks is 6.</span>
     *
     * <span class="">// Note: there are multiple correct answers for this sample input.</span>
     * <span class="">// The following is an example of another correct answer:</span>
     * <span class="">// [</span>
     * <span class="">//   [2, 4],</span>
     * <span class="">//   [0, 5],</span>
     * <span class="">//   [1, 3]</span>
     * <span class="">// [</span>
     * </pre>
     * </div>
     */
    @Override
    public Problem getProblem() {
        return Problem.builder()
        .withTestCase(
            TestCase.builder()
            .withInput(new int[]{1, 3, 5, 3, 1, 4})
            .withInput(3)
            .withOutput(Arrays.asList(
                Arrays.asList(0, 2),
                Arrays.asList(4, 5),
                Arrays.asList(1, 3)
            ))
            .build()
        )
        .build();
    }

}
