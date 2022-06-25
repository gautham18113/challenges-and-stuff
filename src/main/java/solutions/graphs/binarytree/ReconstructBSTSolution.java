package solutions.graphs.binarytree;

import core.Solution;
import core.datastructure.BST;
import core.io.Input;
import core.io.Output;

public class ReconstructBSTSolution implements Solution{

    @Override
    public Output<?> solve(Input<?> input) {
        int[] array = (int[]) input.getInput();
        reconstructBst(array, 0, array.length-1);
        BST result = reconstructBstOptimized(array, Integer.MIN_VALUE, Integer.MAX_VALUE, new GlobalVariables(), null);
        return new Output<>(result);
    }

    /**
     * <p>
     * Important point to note is that, the right child of current
     * array element is the first element to further ahead in the array
     * that is greater than or equal to the current element. Using this fact
     * we can split the array into root, left and right subtree.
     * </p>
     * <p>
     * <b>T</b> O(n^2) <b>S</b> O(n)
     * </p>
     * @param array
     * @param start
     * @param end
     * @return
     */
    private final BST reconstructBst(int[] array, int start, int end) {

        if(end - start < 0) {
            return null;
        }

        int i = start;
        int j = i + 1;
        BST node = new BST(array[i]);

        /* I missed the point that j should always land on right
         * sub tree root index for this to work. So if j lands on
         * an end value that's actually a part of the left sub tree
         * because it has reached the end of the array, then it mistakenly
         * puts the element at j as the right child.
         * The workaround here is to keep moving j until regardless
         * of size of array, if the element being compared is not the
         * right node.
         */
        try {
            while(array[j] < array[i]) j++;
        }
        catch(ArrayIndexOutOfBoundsException e) {

        }
        node.left = reconstructBst(array, i + 1, j - 1);

        node.right = reconstructBst(array, j, end);

        return node;

    }

    class GlobalVariables {
        public int currentIdx;
    }

    /**
     * <p>
     * In this solution, we use the concept of minimum and maximum possible values allowable for a BST
     * node. This concept previously used in {@link ValidateBSTSolution}. We use minimum and maximum
     * allowable values to check if value to be inserted belongs at a certain position. We keep track
     * of value to be inserted globally in the instance object of {@link GlobalVariables}.
     * </p>
     * <p>
     * <b>T</b> O(n) <b>S</b> O(n + h)
     * </p>
     * @param array
     * @param minPossibleVal
     * @param maxPossibleVal
     * @param v
     * @param tree
     * @return
     */
    private final BST reconstructBstOptimized(int[] array, int minPossibleVal, int maxPossibleVal, GlobalVariables v, BST tree) {

        if(v.currentIdx > array.length - 1) return null;

        int currentVal = array[v.currentIdx];

        if(currentVal >= minPossibleVal && currentVal < maxPossibleVal) {
            tree = new BST(currentVal);
        } else {
            return null;
        }

        v.currentIdx++;

        tree.left = reconstructBstOptimized(array, minPossibleVal, currentVal, v, tree.left);
        tree.right = reconstructBstOptimized(array , currentVal, maxPossibleVal, v, tree.right);

        return tree;
    } }
