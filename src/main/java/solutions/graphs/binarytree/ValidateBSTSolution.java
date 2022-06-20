package solutions.graphs.binarytree;

import java.util.Objects;

import core.Solution;
import core.datastructure.BST;
import core.io.Input;
import core.io.Output;

public class ValidateBSTSolution implements Solution{


    /*
     * A tree is a valid BST iff
     * 1. All nodes to the left of current node are strictly less than  current node
     * 2. All nodes to the right of current node are greater than or equal to current node
     * 3. Child nodes of current node are BST themselves.
     *
     *
     */
    @Override
    public Output<?> solve(Input<?> input) {
        BST tree = (BST) input.getInput();
        return new Output<>(isBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    private boolean isBST(BST node, int minPossibleValue, int maxPossibleValue) {
        int currentNodeValue = node.value;
        BST left = node.left;
        BST right = node.right;
        boolean isABst = currentNodeValue >= minPossibleValue && currentNodeValue < maxPossibleValue;

        if(!isABst) return false;

        if(Objects.nonNull(left) && !isBST(left, minPossibleValue, currentNodeValue)) {
            return false;
        }

        if(Objects.nonNull(right) && !isBST(right, currentNodeValue, maxPossibleValue)) {
            return false;
        }

        return true;
    }
}
