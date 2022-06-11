package solutions.linkedlist;

import core.io.Input;
import core.io.Output;
import core.Solution;
import core.datastructure.LL;

public class RemoveDuplicatesInSortedLLSolution implements Solution {
    @Override
    @SuppressWarnings("unchecked")
    public Output<?> solve(Input<?> input) {
        LL<Integer> head = (LL<Integer>) input.getInput();
        LL<Integer> current = head;
        LL<Integer> prev = null;

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
