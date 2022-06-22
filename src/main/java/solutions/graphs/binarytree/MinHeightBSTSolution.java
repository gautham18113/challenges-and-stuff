package solutions.graphs.binarytree;

import core.Solution;
import core.datastructure.BST;
import core.io.Input;
import core.io.Output;

public class MinHeightBSTSolution implements Solution{

    /**
     * <p>
     * To minimize the height of the tree, we need to minimize the height of both left
     * and right sub trees.
     * </p>
     * <p>
     * To do this we can make use of the fact that the input array will be <b> sorted </b>.
     * </p>
     * <p>
     * Since the input array is sorted, the mid point of the array will represent the root element.
     * The portions of the array to the left and right of the mid point will have the left and right
     * children in their respective mid points. If we consider the left and right sub array to represent a BST
     * themselves, then recursion can be used in the left and right halves to recursively construct the entire tree.
     * </p>
     * @param input wrapper for int array
     * @return output wrapper for {@link BST}
     */
    @Override
    public Output<?> solve(Input<?> input) {
        int[] array = (int[])input.getInput();
        // BST result = constructMinHeightBstOptimized(array, null, 0, array.length-1);
        BST result = constructMinHeightBstOptimized2(array, 0, array.length-1);
        result.printBinaryTree();
        return new Output<>(result);
    }

    /**
     * <p>
     * This solution uses the insert method of the {@link BST} to insert the mid value of current
     * array into the tree. It has a higher time complexity since it uses the insert method of the BST.
     * </p>
     * <b>T</b> O(nlogn)
     * <b>S</b> O(n)
     * <hr/>
     * @param array input array
     * @param tree aggregator {@link BST}
     * @param left left index of current sub array
     * @param right right index of current sub array
     * @return fully constructed {@link BST}
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

    /**
     * <p>
     * This solution does not use the insert method of the {@link BST}. Instead
     * it recursively constructs the tree while recursing through the sub arrays.
     * </p>
     * <b>T</b> O(n) <b>S</b> O(n)
     * <hr/>
     * @param array input array
     * @param left left index of sub array
     * @param right right index of sub array
     * @return fully constructed {@link BST}
     */
    private BST constructMinHeightBstOptimized2(int[] array, int left, int right) {
        int mid = left + (right - left) / 2;

        if(left > right) return null;

        BST tree = new BST(array[mid]);
        tree.left = constructMinHeightBstOptimized2(array, left, mid - 1);
        tree.right = constructMinHeightBstOptimized2(array, mid + 1, right);

        return tree;
    }

}
