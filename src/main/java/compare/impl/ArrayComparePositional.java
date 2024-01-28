package compare.impl;

import compare.Compare;

import java.util.Arrays;

public class ArrayComparePositional<T> implements Compare<T> {
    @Override
    public boolean equal(T expected, T actual) {
        if (expected instanceof int[] && actual instanceof int[]) {
            return Arrays.compare((int[]) expected, (int[]) actual) == 0;
        }
        return false;
    }
}
