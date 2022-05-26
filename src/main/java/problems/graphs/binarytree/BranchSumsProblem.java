package problems.graphs.binarytree;

import core.datastructure.CustomBinaryTree;
import core.Problem;
import core.ProblemInterface;
import core.TestCase;

import java.util.Arrays;

public class BranchSumsProblem implements ProblemInterface {

    @Override
    public Problem getProblem() {
        return Problem.builder().withTestCase(

                TestCase.builder().withInput(CustomBinaryTree.toBinaryTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)))
                        .withOutput(16).build())
                .build();
    }
}
