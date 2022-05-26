package solutions.graphs.binarytree;

import org.junit.jupiter.api.Test;
import common.TestUtil;
import problems.graphs.binarytree.BranchSumsProblem;

public class BranchSumsTest{

    private final BranchSumsSolution branchSumsSolution = new BranchSumsSolution();
    private final BranchSumsProblem branchSumsProblem = new BranchSumsProblem();

    @Test
    public void testBranchSums() {
        TestUtil.runAssertions(branchSumsProblem, branchSumsSolution);
    }
}
