package problems.linkedlist;

import core.io.Input;
import core.io.Output;
import core.Problem;
import core.ProblemInterface;
import core.TestCase;
import core.datastructure.SinglyLinkedList;

import java.util.Arrays;
import java.util.List;

public class RemoveDuplicatesInSortedLLProblem implements ProblemInterface {

    /**
     * <p>
     *   You're given the head of a Singly Linked List whose nodes are in sorted order
     *   with respect to their values. Write a function that returns a modified version
     *   of the Linked List that doesn't contain any nodes with duplicate values. The
     *   Linked List should be modified in place (i.e., you shouldn't create a brand
     *   new list), and the modified Linked List should still have its nodes sorted
     *   with respect to their values.
     * </p>
     * <p>
     *   Each <span>LinkedList</span> node has an integer <span>value</span> as well as
     *   a <span>next</span> node pointing to the next node in the list or to
     *   <span>None</span> / <span>null</span> if it's the tail of the list.
     * </p>
     * <p>  </p>
     * <h3>Sample Input</h3>
     * <pre><span class="CodeEditor-promptParameter">linkedList</span> = 1 -&gt; 1 -&gt; 3 -&gt; 4 -&gt; 4 -&gt; 4 -&gt; 5 -&gt; 6 -&gt; 6 <span class="CodeEditor-promptComment">// the head node with value 1</span>
     * </pre>
     * <h3>Sample Output</h3>
     * <pre>1 -&gt; 3 -&gt; 4 -&gt; 5 -&gt; 6 <span>// the head node with value 1</span></pre>
     */
    @Override
    public Problem getProblem() {
        SinglyLinkedList<Integer> ll = new SinglyLinkedList<>();
        List<TestCase> testCaseList = Arrays.asList(
            TestCase.builder()
                .withInput(new Input<>(ll.buildSinglyLinkedList(Arrays.asList(1,1,3,4,4,4,5,6,6))))
                .withOutput(new Output<>(ll.buildSinglyLinkedList(Arrays.asList(1,3,4,5,6))))
                .build(),
            TestCase.builder()
                .withInput(new Input<>(ll.buildSinglyLinkedList(Arrays.asList(1,1))))
                .withOutput(new Output<>(ll.buildSinglyLinkedList(Arrays.asList(1))))
                .build(),
            TestCase.builder()
                .withInput(new Input<>(ll.buildSinglyLinkedList(Arrays.asList(1))))
                .withOutput(new Output<>(ll.buildSinglyLinkedList(Arrays.asList(1))))
                .build(),
            TestCase.builder()
                .withInput(new Input<>(ll.buildSinglyLinkedList(Arrays.asList())))
                .withOutput(new Output<>(ll.buildSinglyLinkedList(Arrays.asList())))
                .build()
        );
        return Problem.builder().withTestCaseList(testCaseList).build();
    }

}
