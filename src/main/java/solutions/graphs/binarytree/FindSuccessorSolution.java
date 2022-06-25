package solutions.graphs.binarytree;

import java.util.ArrayList;
import java.util.List;

import core.Solution;
import core.datastructure.BST;
import core.io.Input;
import core.io.Output;

public class FindSuccessorSolution implements Solution{

    @SuppressWarnings("all")
    @Override
    public Output<?> solve(Input<?> input) {
        List<Input> params = (List<Input>) input.getInput();

        BST tree = (BST) params.get(0).getInput();
        int nodeValue = (int) params.get(1).getInput();


        List<Integer> result = new ArrayList(1);

        findSuccessorSubOptimal(tree, nodeValue, result);

        int idx = result.indexOf(nodeValue);

        Integer successor = idx >= result.size() ? null : result.get(idx + 1);

        BST optimalResult = new BST(null);

        findSuccessorOptimal(tree, optimalResult, nodeValue);

        return new Output<>(optimalResult.value);
    }

    private Integer findSuccessorSubOptimal(BST tree, int nodeValue, List<Integer> traversed) {

        if(tree == null) {
            return null;
        }

        findSuccessorSubOptimal(tree.left, nodeValue, traversed);
        Integer current = tree.value;
        traversed.add(current);
        findSuccessorSubOptimal(tree.right, nodeValue, traversed);
        return current;
    }

    private Integer findSuccessorOptimal(BST tree, BST successor, int nodeValue) {
        if(tree == null) return null;

        if(tree.value == nodeValue) {
            if(tree.right != null) {
                successor.value = recurseLeft(tree.right);
            }
            else {
                successor.value = recurseTop(tree);
            }
            return null;
        }
        else {
            findSuccessorOptimal(tree.left, successor, nodeValue);
            findSuccessorOptimal(tree.right, successor, nodeValue);

            return tree.value;

        }
    }

    private Integer recurseLeft(BST tree) {
        if(tree.left == null) {
            return tree.value;
        }
        int leftMost = recurseLeft(tree.left);
        return leftMost;
    }

    private Integer recurseTop(BST tree) {

        while(tree.parent !=null && tree.parent.right!=null && tree.value == tree.parent.right.value) {
            tree = tree.parent;
        }

        // root node
        if(tree.parent == null) return null;

        return tree.parent.value;

    }

}
