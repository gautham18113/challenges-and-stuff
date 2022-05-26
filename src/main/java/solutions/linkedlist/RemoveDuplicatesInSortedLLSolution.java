package solutions.linkedlist;

import core.io.Input;
import core.io.Output;
import core.Solution;
import core.datastructure.SinglyLinkedList;

public class RemoveDuplicatesInSortedLLSolution implements Solution {
    @Override
    @SuppressWarnings("unchecked")
    public Output<?> solve(Input<?> input) {
        SinglyLinkedList<Integer> head = (SinglyLinkedList<Integer>) input.getInput();
        SinglyLinkedList<Integer> current = head;
        SinglyLinkedList<Integer> prev = null;

        while(current != null) {

            if(prev != null && prev.value == current.value) {
                while(current!=null && prev.value == current.value) {
                    current = current.next;
                }
                prev.next = current;
            }
            else {
                prev = current;
                current = current.next;
            }
        }
        return new Output<>(head);
    }
}
