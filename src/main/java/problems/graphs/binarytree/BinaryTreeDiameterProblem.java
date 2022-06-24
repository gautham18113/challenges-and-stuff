package problems.graphs.binarytree;

import java.util.Arrays;

import core.Problem;
import core.ProblemInterface;
import core.TestCase;
import core.datastructure.BST;

public class BinaryTreeDiameterProblem implements ProblemInterface{

    /**
     * <div class="html">
     * <p>
     *   Write a function that takes in a Binary Tree and returns its diameter. The
     *   diameter of a binary tree is defined as the length of its longest path, even
     *   if that path doesn't pass through the root of the tree.
     * </p>
     * <p>
     *   A path is a collection of connected nodes in a tree, where no node is
     *   connected to more than two other nodes. The length of a path is the number of
     *   edges between the path's first node and its last node.
     * </p>
     * <p>
     *   Each <span>BinaryTree</span> node has an integer <span>value</span>, a
     *   <span>left</span> child node, and a <span>right</span> child node. Children
     *   nodes can either be <span>BinaryTree</span> nodes themselves or
     *   <span>None</span> / <span>null</span>.
     * </p>
     * <h3>Sample Input</h3>
     * <pre><span >tree</span> =        1
     *             /   \
     *            3     2
     *          /   \
     *         7     4
     *        /       \
     *       8         5
     *      /           \
     *     9             6
     * </pre>
     * <h3>Sample Output</h3>
     * <pre>6 <span >// 9 -&gt; 8 -&gt; 7 -&gt; 3 -&gt; 4 -&gt; 5 -&gt; 6</span>
     * <span >// There are 6 edges between the</span>
     * <span >// first node and the last node</span>
     * <span >// of this tree's longest path.</span>
     * </pre>
     * </div>
     */
    @Override
    public Problem getProblem() {
        BST tree1 = new BST(1);
        Arrays.asList(3,2,7,4,8,5,9,6).forEach(i -> tree1.insert(i));
        tree1.left = new BST(3);
        tree1.left.left = new BST(7);
        tree1.left.left.left = new BST(8);
        tree1.left.left.left.left = new BST(9);

        tree1.right = new BST(2);
        tree1.left.right = new BST(4);
        tree1.left.right.right = new BST(5);
        tree1.left.right.right.right = new BST(6);

        return Problem.builder().withTestCase(TestCase.builder().withInput(tree1).withOutput(6).build()).build();
    }

}
