package solutions.graphs.binarytree;

import java.util.ArrayList;
import java.util.List;

import core.Solution;
import core.datastructure.BST;
import core.io.Input;
import core.io.Output;
import problems.graphs.binarytree.BSTTraversalProblem.BSTTraversalProblemInput;

public class BSTTraversalSolution implements Solution{

    @Override
    public Output<?> solve(Input<?> input) {

        BSTTraversalProblemInput problemInput = (BSTTraversalProblemInput) input.getInput();

        String traversalType = problemInput.getTraversalType();
        BST tree = problemInput.getTree();

        List<Integer> result = new ArrayList<>();
        switch(traversalType) {
            case "IN_ORDER":
                inOrderTraversal(tree, result);
                break;
            case "PRE_ORDER":
                preOrderTraversal(tree, result);
                break;
            case "POST_ORDER":
                postOrderTraversal(tree, result);
                break;
        }

        return new Output<>(result);
    }

    private List<Integer> inOrderTraversal(BST tree, List<Integer> aggregator) {
        if(tree == null) {
            return null;
        }

        inOrderTraversal(tree.left, aggregator);
        aggregator.add(tree.value);
        inOrderTraversal(tree.right, aggregator);

        return aggregator;
    }

    private List<Integer> preOrderTraversal(BST tree, List<Integer> aggregator) {
        if(tree == null) {
            return null;
        }

        aggregator.add(tree.value);
        preOrderTraversal(tree.left, aggregator);
        preOrderTraversal(tree.right, aggregator);
        return aggregator;
    }

    private List<Integer> postOrderTraversal(BST tree, List<Integer> aggregator) {
        if(tree == null) {
            return null;
        }

        postOrderTraversal(tree.left, aggregator);
        postOrderTraversal(tree.right, aggregator);
        aggregator.add(tree.value);

        return aggregator;
    }

}
