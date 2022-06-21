package problems.graphs.binarytree;

import java.util.Arrays;

import core.Problem;
import core.ProblemInterface;
import core.TestCase;
import core.datastructure.BST;

/*
<p>
  Write three functions that take in a Binary Search Tree (BST) and an empty
  array, traverse the BST, add its nodes' values to the input array, and return
  that array. The three functions should traverse the BST using the in-order,
  pre-order, and post-order tree-traversal techniques, respectively.
</p>
<p>
  If you're unfamiliar with tree-traversal techniques, we recommend watching the
  Conceptual Overview section of this question's video explanation before
  starting to code.
</p>
<p>
  Each <span>BST</span> node has an integer <span>value</span>, a
  <span>left</span> child node, and a <span>right</span> child node. A node is
  said to be a valid <span>BST</span> node if and only if it satisfies the BST
  property: its <span>value</span> is strictly greater than the values of every
  node to its left; its <span>value</span> is less than or equal to the values
  of every node to its right; and its children nodes are either valid
  <span>BST</span> nodes themselves or <span>None</span> / <span>null</span>.
</p>
<h3>Sample Input</h3>
<pre><span class="CodeEditor-promptParameter">tree</span> =   10
       /     \
      5      15
    /   \       \
   2     5       22
 /
1
<span class="CodeEditor-promptParameter">array</span> = []
</pre>
<h3>Sample Output</h3>
<pre><span class="CodeEditor-promptParameter">inOrderTraverse</span>: [1, 2, 5, 5, 10, 15, 22] <span class="CodeEditor-promptComment">// where the array is the input array</span>
<span class="CodeEditor-promptParameter">preOrderTraverse</span>: [10, 5, 2, 1, 5, 15, 22] <span class="CodeEditor-promptComment">// where the array is the input array</span>
<span class="CodeEditor-promptParameter">postOrderTraverse</span>: [1, 2, 5, 5, 22, 15, 10] <span class="CodeEditor-promptComment">// where the array is the input array</span>
</pre>
 */
public class BSTTraversalProblem implements ProblemInterface{

    public class BSTTraversalProblemInput{
        String traversalType;
        BST tree;

        BSTTraversalProblemInput(String traversalType, BST tree) {
            this.traversalType = traversalType;
            this.tree = tree;
        }

        public String getTraversalType() {
            return this.traversalType;
        }

        public BST getTree() {
            return this.tree;
        }
    }

    @Override
    public Problem getProblem() {
        BST tree1 = new BST(10);
        Arrays.asList(5,15,2,5,22,1).forEach(i -> tree1.insert(i));

        return Problem.builder()
            .withTestCase(TestCase.builder().withInput(new BSTTraversalProblemInput("IN_ORDER", tree1)).withOutput(Arrays.asList(1,2,5,5,10,15,22)).build())
            .withTestCase(TestCase.builder().withInput(new BSTTraversalProblemInput("PRE_ORDER", tree1)).withOutput(Arrays.asList(10,5,2,1,5,15,22)).build())
            .withTestCase(TestCase.builder().withInput(new BSTTraversalProblemInput("POST_ORDER", tree1)).withOutput(Arrays.asList(1,2,5,5,22,15,10)).build())
            .build();
    }

}
