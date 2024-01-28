package compare.impl;

import compare.Compare;

import java.util.Arrays;

public class ArrayCompareNonPositional<T> implements Compare<T[]> {
    @Override
    public boolean equal(T[] expected, T[] actual) {
        if(expected.length != actual.length) {
            return false;
        }
        Arrays.sort(expected);
        Arrays.sort(actual);
        return new ArrayComparePositional<>().equal(expected, actual);
    }
}
