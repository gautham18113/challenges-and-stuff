package problems.graphs.binarytree;

import java.util.Arrays;

import core.Problem;
import core.ProblemInterface;
import core.TestCase;
import core.datastructure.BST;

/*
 * <div class="html">
 * <p>
 *  Write a function that takes in a potentially invalid Binary Search Tree (BST)
 *  and returns a boolean representing whether the BST is valid.
 *</p>
 *<p>
 *  Each <span>BST</span> node has an integer <span>value</span>, a
 *  <span>left</span> child node, and a <span>right</span> child node. A node is
 *  said to be a valid <span>BST</span> node if and only if it satisfies the BST
 *  property: its <span>value</span> is strictly greater than the values of every
 *  node to its left; its <span>value</span> is less than or equal to the values
 *  of every node to its right; and its children nodes are either valid
 *  <span>BST</span> nodes themselves or <span>None</span> / <span>null</span>.
 *</p>
 *<p>
 *  A BST is valid if and only if all of its nodes are valid
 *  <span>BST</span> nodes.
 *</p>
 *<h3>Sample Input</h3>
 *<pre><span>tree</span> =   10
 *       /     \
 *      5      15
 *    /   \   /   \
 *   2     5 13   22
 * /           \
 *1            14
 *</pre>
 *<h3>Sample Output</h3>
 *<pre>true</pre>
 *</div>
 */
public class ValidateBSTProblem implements ProblemInterface{

    @Override
    public Problem getProblem() {
        BST tree1 = new BST(10);
        Arrays.asList(5,15,2,5,13,22,1,14).forEach(i -> tree1.insert(i));
        BST tree2 = new BST(10);
        Arrays.asList(5,15,2,5,13,22,1,14).forEach(i -> tree2.insert(i));
        tree2.left.value = 20;
        BST tree3 = new BST(10);
        Arrays.asList(5,15,2,5,13,22,1,14).forEach(i -> tree3.insert(i));
        tree3.right.right.left = new BST(9);

        return Problem.builder()
            .withTestCase(TestCase.builder().withInput(tree1).withOutput(true).build())
            .withTestCase(TestCase.builder().withInput(tree2).withOutput(false).build())
            .withTestCase(TestCase.builder().withInput(tree3).withOutput(false).build())
            .build();
    }


}
