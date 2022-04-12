package solutions.arrays;

import core.Solution;
import core.Util;
import core.io.Input;
import core.io.Output;

import java.util.List;

/**
 * Initialize two pointers one at start and other at end
 * Decrement right pointer if it is equal to element to move
 * Increment left pointer if it is not equal to element to move.
 * If left = element to move and right !=element to move, then swap.
 */
@SuppressWarnings("unchecked")
public class MoveElementToEndSolution implements Solution {
    @Override
    public Output<?> solve(Input<?> input) {
        List<Input<?>> params = (List<Input<?>>) input.getInput();
        int[] array = (int[]) params.get(0).getInput();
        int toMove = (int) params.get(1).getInput();

        int start = 0, end = array.length - 1;

        while(start < end) {
            while(array[start] != toMove && start < end) start++;
            while(array[end] == toMove && start < end) end--;
            Util.swap(start, end, array);
        }

        return new Output<>(array);
    }
}
