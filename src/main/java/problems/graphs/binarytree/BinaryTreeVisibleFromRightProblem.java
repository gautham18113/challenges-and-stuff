package problems.graphs.binarytree;

import core.AbstractProblem;
import core.Problem;
import core.TestCase;

public class BinaryTreeVisibleFromRightProblem extends AbstractProblem {

    /**
     * Given a binary tree, return the rightmost node of each level.
     * @return
     */
    @Override
    public Problem getProblem() {
        return Problem.builder()
                .withTestCase(
                        TestCase.builder()
                                .withInput(buildTree(
                                        splitWords("1 2 4 x 7 x x 5 x x 3 x 6 x x").iterator(),
                                        (s) -> Integer.valueOf(s)
                                ))
                                .withOutput(new Integer[]{1,3,6,7})
                                .build()
                )
                .build();
    }
}
