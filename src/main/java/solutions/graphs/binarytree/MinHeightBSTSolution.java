package solutions.graphs.binarytree;

import core.Solution;
import core.datastructure.BST;
import core.io.Input;
import core.io.Output;

public class MinHeightBSTSolution implements Solution{

    @Override
    public Output<?> solve(Input<?> input) {
        int[] array = (int[])input.getInput();
        // BST result = constructMinHeightBstOptimized(array, null, 0, array.length-1);
        BST result = constructMinHeightBstOptimized2(array, 0, array.length-1);
        result.printBinaryTree();
        return new Output<>(result);
    }

    /* T O(nlogn) S O(n)
     * O(nlogn) because BST insert method has n log n complexity
     */
    private BST constructMinHeightBst(int[] array, BST tree, int left, int right) {

        int mid = left + (right - left) / 2;

        if(left < 0 || right >= array.length || left > right) return tree;

        if(tree == null) {
            tree = new BST(array[mid]);
        }
        else {
            tree.insert(array[mid]);
        }

        constructMinHeightBst(array, tree, left, mid - 1);
        constructMinHeightBst(array, tree, mid + 1, right);

        return tree;
    }

    /* T O(n) S O(n)
     * Time complexity reduced because of not using BST insert.
     */
    @SuppressWarnings("all")
    private BST constructMinHeightBstOptimized(int[] array, BST tree, int left, int right) {
        int mid = left + (right - left ) / 2;

        if(left > right) return tree;

        int value = array[mid];

        BST newBst = new BST(value);

        if(tree == null) {
            tree = newBst;
        }
        else{
            if(tree.value > value) {
                tree.left = newBst;
                tree = tree.left;
            }
            else if(tree.value <= value) {
                tree.right = newBst;
                tree = tree.right;
            }

        }
        constructMinHeightBst(array, tree, left, mid - 1);
        constructMinHeightBst(array, tree, mid + 1, right);

        return tree;
    }

    private BST constructMinHeightBstOptimized2(int[] array, int left, int right) {
        int mid = left + (right - left) / 2;

        if(left > right) return null;

        BST tree = new BST(array[mid]);
        tree.left = constructMinHeightBstOptimized2(array, left, mid - 1);
        tree.right = constructMinHeightBstOptimized2(array, mid + 1, right);

        return tree;
    }

}
