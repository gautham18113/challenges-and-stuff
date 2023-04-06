package solutions.arrays;

import org.junit.jupiter.api.Test;
import common.ListOfListComparator;

import common.TestUtil;
import problems.arrays.GroupAnagramProblem;

public class GroupAnagramSolutionTest {
    private final GroupAnagramProblem problem = new GroupAnagramProblem();
    private final GroupAnagramSolution solution = new GroupAnagramSolution();

    @Test
    public void test() {
        TestUtil.runAssertionsWithComparator(problem, solution, new ListOfListComparator<String>());
    }
}