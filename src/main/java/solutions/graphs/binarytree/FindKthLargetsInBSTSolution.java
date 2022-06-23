package solutions.graphs.binarytree;

import java.util.ArrayList;
import java.util.List;

import core.Solution;
import core.datastructure.BST;
import core.io.Input;
import core.io.Output;
import problems.graphs.binarytree.FindKthLargestInBSTProblem;

public class FindKthLargetsInBSTSolution implements Solution {

    /**
     * Solves problem {@link FindKthLargestInBSTProblem}
     *
     * @param input {@link Input} wrapper containing a {@link BST}
     */
    @SuppressWarnings("all")
    @Override
    public Output<?> solve(Input<?> input) {
        List<Input> inputs = (List<Input>) input.getInput();
        int k = (int) inputs.get(0).getInput();
        BST tree = (BST) inputs.get(1).getInput();
        List<Integer> result = new ArrayList<>();
        result.add(Integer.MIN_VALUE);
        kthLargest(tree, k, result);
        return new Output(result.get(0));
    }

    /**
     * <p>
     * We will use reverse in-order traversal to read the node values in
     * descending order. The kth largest node then can be tracked by the number
     * of visited nodes.
     * </p>
     * @param tree
     * @param k
     * @param result
     * @return
     */
    private final int kthLargest(BST tree, int k, List<Integer> result) {

        if (result.get(0) > Integer.MIN_VALUE) return 0;

        else {
            if (tree == null) return k;

            k = kthLargest(tree.right, k, result);

            k--;

            if (k == 0) result.add(0, tree.value);

            k = kthLargest(tree.left, k, result);

            return k;
        }

    }

}
