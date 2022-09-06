package solutions.arrays;

import java.util.ArrayList;
import java.util.List;

import core.Solution;
import core.io.Input;
import core.io.Output;

public class PermutationSolution implements Solution {

    @SuppressWarnings("unchecked")
    @Override
    public Output<?> solve(Input<?> input) {
        List<Integer> array = (List<Integer>) input.getInput();
        List<List<Integer>> result = getPermutations(
            array,
            new ArrayList<>(),
            new ArrayList<>());
        return new Output<>(result);
    }

    private List<List<Integer>> getPermutations(List<Integer> array, List<List<Integer>> collector,
            List<Integer> currentPermutation) {

        if (array.size() == 0 && currentPermutation.size() > 0) {
            collector.add(currentPermutation);
        } else {
            for (int i = 0; i < array.size(); i++) {
                List<Integer> arrayCopy = new ArrayList<>(array);
                int removed = arrayCopy.remove(i);
                List<Integer> newPermutation = new ArrayList<>(currentPermutation);
                newPermutation.add(removed);
                getPermutations(arrayCopy, collector, newPermutation);
            }

        }

        return collector;

    }

}
