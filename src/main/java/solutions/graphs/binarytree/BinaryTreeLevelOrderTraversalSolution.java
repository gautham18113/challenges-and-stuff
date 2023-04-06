package solutions.graphs.binarytree;

import core.Solution;
import core.datastructure.Node;
import core.io.Input;
import core.io.Output;

import java.util.*;

public class BinaryTreeLevelOrderTraversalSolution implements Solution {

    /**
     * When we dequeue a node from the queue, we need to know the level it sits in the tree to add it to the
     * corresponding level in the result. But nodes in the queue do not have any information about level.
     *
     * How do we get a node's level?
     *
     * One observation is that the queue contains at most two levels of nodes.
     * To see why, let's assume our tree is three-level deep.
     * Let's call the nodes of the shallowest level "level 0" nodes and their children "level 1" nodes,
     * whose children are "level 2" nodes. When we do a BFS, we first push "level 0" nodes into the queue,
     * and as we process them, we push their children "level 1" nodes into the queue.
     *
     * To get "level 2" nodes onto the queue, we have to start dequeuing and processing "level 1" nodes but
     * we can't dequeue any "level 1" nodes until we have finished dequeuing and processing "level 0" nodes
     * since a queue is a First-in-First-Out structure.
     *
     * Therefore it's impossible to have 3 levels in the queue at the same time,
     * and we can have at most two levels in the queue.
     *
     * Also, observe that we always push the leftmost node of a level into the queue first. When we dequeue the leftmost node (and before we add its children), the queue contains only one level of nodes. We can save the number of nodes in the queue in a variable n, and dequeue the next n nodes.
     *
     * N -> number of nodes in tree
     * Time: O(N) - We only visit each node once
     * Space: O(N) - to store result
     * @param input
     * @return output
     */
    @Override
    public Output<?> solve(Input<?> input) {

        Node root = (Node) input.getInput();

        return new Output<>(bfs(root));
    }

    private int[][] bfs(Node root) {

        int[][] result = new int[root.getDepth()][];

        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(root);

        int level = 0;

        while(!queue.isEmpty()) {

            // Initially store the size of the queue, this
            // represents all the nodes in that level
            int queueSize = queue.size();

            // Initialize result at that level to queueSize
            // Because whatever is in the queue at this point
            // belong to the same level
            result[level] = new int[queueSize];

            for (int i=0; i < queueSize; i++) {

                Node node = queue.pop();
                result[level][i] = (int) node.val;
                List<Node> children = getChildren(node);

                // Add all children to queue
                // note that it does not affect queueSize
                // since it is already stored in a variable.
                if (children.size() > 0) {
                    queue.addAll(children);
                }
            }
            // Increment level after processing all nodes upto
            // queueSize.
            level++;
        }

        return result;
    }

    private List<Node> getChildren(Node node) {
        List<Node> children = new ArrayList<>(2);
        if (node.left != null) { children.add(node.left); }
        if (node.right != null) { children.add(node.right); }
        return children;
    }
}
