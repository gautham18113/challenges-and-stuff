package solutions.graphs.binarytree;

import java.util.HashMap;
import java.util.Map;

import core.Solution;
import core.datastructure.BST;
import core.io.Input;
import core.io.Output;

public class BinaryTreeDiameterSolution implements Solution{

    /**
     * <p>
     * Key to this problem is to figure out the fact that max path length of any given node
     * is the maximum of max path seen so far, max height of left sub tree + max height of right sub tree
     * </p>
     * <p>
     * <b>T</b> O(n) <b>S</b> O(h)
     */
    @Override
    public Output<?> solve(Input<?> input) {
        BST tree = (BST) input.getInput();

        Map<String, Integer> result = new HashMap<>();

        result.put("maxPathLength", Integer.MIN_VALUE);

        maxPathLength(tree, result);

        int longestPath = result.get("maxPathLength");

        /* subtract by 1 for number of edges between left and right node */
        return new Output<>(longestPath - 1);
    }

    private int maxPathLength(BST node, Map<String, Integer> result) {

        /* Base Case */
        if(node == null) return 0;

        /*
         * Max Path length = max(max path length of left node, max path length of right node)
         * path length = max height of left + max height of right
         *
         */

        int leftHeight = 1 + maxPathLength(node.left, result);
        int rightHeight = 1 + maxPathLength(node.right, result);
        /* subtract 1 to account for double counting root node */
        int currentPathLength = leftHeight + rightHeight - 1;
        if(result.get("maxPathLength") < currentPathLength) {
            result.put("maxPathLength", currentPathLength);
        }

        return Math.max(leftHeight, rightHeight);
    }

}
