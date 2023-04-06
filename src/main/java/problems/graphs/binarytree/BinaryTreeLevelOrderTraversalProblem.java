package problems.graphs.binarytree;

import core.AbstractProblem;
import core.Problem;
import core.TestCase;

import java.util.Arrays;

public class BinaryTreeLevelOrderTraversalProblem extends AbstractProblem {

    /**
     * Given a binary tree, return its level order traversal. The input is the root node of the tree.
     * The output should be a list of lists of integers, with the ith list containing the values of nodes on level i,
     * from left to right.
     * @return
     */
    @Override
    public Problem getProblem() {
        return Problem.builder().withTestCaseList(
                Arrays.asList(
                        TestCase.builder()
                                .withInput(
                                        this.buildTree(
                                                this.splitWords(
                                                        "1 2 4 x 7 x x 5 x x 3 x 6 x x").iterator(),
                                                (x) -> Integer.valueOf(x) ))
                                .withOutput(new int[][]{
                                        {1},
                                        {2,3},
                                        {4,5,6},
                                        {7}
                                })
                                .withComparator((e, a) -> comparator((int[][])e, (int[][])a))
                                .build()
                )
        ).build();
    }

    private boolean comparator(int[][] expected, int[][] actual) {
        return Arrays.deepEquals(expected, actual);
    }
}
