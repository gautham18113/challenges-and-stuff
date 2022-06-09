package solutions.arrays;

import org.junit.jupiter.api.Test;

import common.TestUtil;
import problems.arrays.MergeOverlappingIntervalsProblem;

public class MergeOverlappingIntervalsSolutionTest {
    private final MergeOverlappingIntervalsProblem problem = new MergeOverlappingIntervalsProblem();
    private final MergeOverlappingIntervalsSolution solution = new MergeOverlappingIntervalsSolution();

    @Test
    public void testSolution() {
        TestUtil.runAssertions(problem, solution);
    }
}
