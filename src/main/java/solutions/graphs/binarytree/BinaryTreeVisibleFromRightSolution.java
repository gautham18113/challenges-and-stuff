package solutions.graphs.binarytree;

import core.Solution;
import core.datastructure.Node;
import core.io.Input;
import core.io.Output;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeVisibleFromRightSolution implements Solution {
    @Override
    public Output<?> solve(Input<?> input) {
        Node node = (Node) input.getInput();

        return new Output<>(bfs(node).toArray());
    }

    private List<Integer> bfs(Node root) {
        ArrayDeque<Node> queue = new ArrayDeque<>();

        // Add atleast one element to queue
        queue.add(root);

        // Initialize result
        List<Integer> result = new ArrayList<>();

        while(!queue.isEmpty()) {
            int rightMostElementIdx = queue.size() - 1;
            int queueSize = queue.size();

            for (int i=0; i < queueSize; i++) {

                Node node = queue.pop();

                // if current index is equal to rightmost element index
                // at this level, then add it to result
                if (i == rightMostElementIdx) {
                    result.add((Integer) node.val);
                }

                // Add children to queue
                if (node.left != null) { queue.add(node.left); }
                if (node.right != null) { queue.add(node.right); }

            }
        }

        return result;
    }
}
