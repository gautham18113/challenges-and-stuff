package problems.graphs.binarytree;

import core.datastructure.CustomBinaryTree;
import core.io.Input;
import core.io.Output;
import core.Problem;
import core.TestCase;

import java.util.Arrays;

public class BranchSumsProblem {

    public Problem problem;

    public BranchSumsProblem() {
        problem = Problem.builder()
            .withTestCaseList(
                Arrays.asList(
                    TestCase.builder()
                        .withInputParameters(Arrays.asList(
                            new Input<>(

                                CustomBinaryTree.toBinaryTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)))
                            )
                        ).withOutput(new Output<>(16)).build()
                )
            )
            .build();

    }
}
