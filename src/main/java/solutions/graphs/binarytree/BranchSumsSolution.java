package solutions.graphs.binarytree;

import core.io.Input;
import core.io.Output;
import core.Solution;
import core.datastructure.CustomBinaryTree;

public class BranchSumsSolution implements Solution {

    /**
     * If we were to isolate a node, we will not be able to find the depth
     * without knowing how many parent nodes are above it.
     *
     * Hence, we need a way to keep track of the depth at every level.
     *
     * This information will be provided to the node by its parent. And then
     * in turn, it will pass the depth to its children.
     *
     * The top level node will have a depth of 0.
     *
     * To find cumulative depth at a certain level, the recursive function
     * call would be
     *
     * f(n,d) = f(n.left, d+1) + f(n.right, d+1) + d
     *
     * where d is the depth of current node n.
     *
     * That is, sum of depth of current node, cumulative depth of left sub-tree
     * and cumulative depth of right sub-tree.
     *
     * @param input {@link Input} input wrapper containing binary tree whose cumulative depth should be calculated
     * @return output {@link Output} output wrapper with int cumulative depth
     **/
    @Override
    public Output<?> solve(Input<?> input) {
        CustomBinaryTree root = (CustomBinaryTree) input.getInput();
        return new Output<>(depthSum(root, -1));
    }


     /**
      *
      * Helper function to recursively calculate sum of depths.
      * @param node {@link CustomBinaryTree} a Binary tree node
      * @param cumulativeSum the cumulative sum of depths updated with every recursive call
      *
      * @return int final sum of depths
      *
      **/
    public int depthSum(CustomBinaryTree node, int cumulativeSum) {

        if(node == null) {
            return 0;
        }

        cumulativeSum++;

        int leftSum = depthSum(node.left, cumulativeSum);
        int rightSum = depthSum(node.right, cumulativeSum);

        return cumulativeSum + leftSum + rightSum;
    }

}
