package solutions.arrays;

import core.Solution;
import core.io.Input;
import core.io.Output;

import java.util.ArrayList;

/**
 * <p>
 *      Iterate through special array recursively
 *      If current element is a number, then add it to total sum.
 *      After reaching end of array, multiply sum with multiplier.
 * </p>
 * <p>
 *      If current element is a list, create a new recursive call
 *      treating the sub list as a new problem with sum 0 and level
 *      one higher than parent level.
 * </p>
 * <p>
 *      Main idea is to sum all elements in array and multiply by multiplier.
 *      If we encounter another array, treat it as a separate problem and initiate
 *      a new recursive call stack to find the sum of that sub array.
 * </p>
 *
 **/
@SuppressWarnings("unchecked")
public class NestedProductSumSolution implements Solution {
    @Override
    public Output<?> solve(Input<?> input) {
        ArrayList<Object> array = (ArrayList<Object>) input.getInput();
        return new Output<>(productSumHelper(array, 0, 1));
    }

    public int productSumHelper(ArrayList<Object> array, int productSum, int level) {
        if(array.size() == 0) return level * productSum;

        if(array.get(0) instanceof ArrayList) {
            productSum += productSumHelper((ArrayList<Object>)array.get(0), 0,  level + 1);
        }
        else {
            productSum += (Integer) array.get(0);
        }
        array.remove(0);
        return productSumHelper(array, productSum, level);
    }
}
