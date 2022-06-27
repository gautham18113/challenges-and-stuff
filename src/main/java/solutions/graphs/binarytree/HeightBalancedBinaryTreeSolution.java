package solutions.graphs.binarytree;

import core.Solution;
import core.datastructure.BST;
import core.io.Input;
import core.io.Output;

public class HeightBalancedBinaryTreeSolution implements Solution{

    @Override
    public Output<?> solve(Input<?> input) {
        BST tree = (BST) input.getInput();
        TreeInfo info = new TreeInfo();
        heights(tree, info);
        return new Output<>(!info.notBalanced);
    }

    class TreeInfo {
        boolean notBalanced = false;
    }


    /**
     * <p>
     * At any point during traversal, if difference of height of
     * left and right sub tree is greater than 1, then we modify
     * an universal toggle which maintains the state of whether or
     * not the tree is height balanced.
     * </p>
     *
     * <p>
     * <b>T</b> O(n) <b>S</b> O(h)
     * <p>
     * @param tree
     * @param info
     * @return
     */
    public int heights(BST tree, TreeInfo info) {

        if(tree == null) return 0;

        int leftHeight = 1 + heights(tree.left, info);
        int rightHeight = 1 + heights(tree.right, info);

        if(Math.abs(leftHeight - rightHeight) > 1) info.notBalanced = true;

        int currentDepth = Math.max(leftHeight, rightHeight);

        return currentDepth;

      }

}
