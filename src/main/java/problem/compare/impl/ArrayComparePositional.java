package problem.compare.impl;

import problem.compare.Compare;

public class ArrayComparePositional<T> implements Compare<T[]> {
    @Override
    public boolean equal(T[] expected, T[] actual) {
        if (expected.length != actual.length) {
            return false;
        }
        for (int i = 0; i < expected.length; i++) {
            if (!expected[i].equals(actual[i])) {
                return false;
            }
        }
        return true;
    }
}
