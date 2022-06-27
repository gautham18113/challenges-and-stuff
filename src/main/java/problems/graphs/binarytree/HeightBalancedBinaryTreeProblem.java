package problems.graphs.binarytree;

import core.Problem;
import core.ProblemInterface;
import core.TestCase;
import core.datastructure.BST;

public class HeightBalancedBinaryTreeProblem implements ProblemInterface{

    /**
     * <div class="html">
     * <p>
     *   You're given the root node of a Binary Tree. Write a function that returns
     *   <span>true</span> if this Binary Tree is height balanced and
     *   <span>false</span> if it isn't.
     * </p>
     * <p>
     *   A Binary Tree is height balanced if for each node in the tree, the difference
     *   between the height of its left subtree and the height of its right subtree is
     *   at most <span>1</span>.
     * </p>
     * <p>
     *   Each <span>BinaryTree</span> node has an integer <span>value</span>, a
     *   <span>left</span> child node, and a <span>right</span> child node. Children
     *   nodes can either be <span>BinaryTree</span> nodes themselves or
     *   <span>None</span> / <span>null</span>.
     * </p>
     * <h3>Sample Input</h3>
     * <pre><span class="CodeEditor-promptParameter">tree</span> = 1
     *      /   \
     *     2     3
     *   /   \     \
     *  4     5     6
     *      /   \
     *     7     8
     * </pre>
     * <h3>Sample Output</h3>
     * <pre>true
     * </pre>
     * </div>
     */
    @Override
    public Problem getProblem() {
        BST tree1 = new BST(1);
        tree1.left = new BST(2);
        tree1.right = new BST(3);
        tree1.left.left = new BST(4);
        tree1.left.right = new BST(5);
        tree1.left.right.left = new BST(7);
        tree1.left.right.right = new BST(8);
        tree1.right.right = new BST(6);

        return Problem.builder()
        .withTestCase(TestCase.builder().withInput(tree1).withOutput(true).build())
        .build();
    }

}
