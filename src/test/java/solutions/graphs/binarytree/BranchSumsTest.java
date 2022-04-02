package solutions.graphs.binarytree;

import core.io.Output;
import core.TestCase;
import org.junit.jupiter.api.Test;
import problems.graphs.binarytree.BranchSumsProblem;
import org.assertj.core.api.Assertions;
public class BranchSumsTest {

    private final BranchSumsSolution branchSumsSolution = new BranchSumsSolution();
    private final BranchSumsProblem branchSumsProblem = new BranchSumsProblem();

    @Test
    public void testBranchSums() {
        for(TestCase test: branchSumsProblem.problem.getTestCases()) {
           Output op = branchSumsSolution.solve(test.getInputs().get(0));
           Assertions.assertThat(op.getOutput())
               .isEqualTo(test.getOutput().getOutput());
        }

    }
}
