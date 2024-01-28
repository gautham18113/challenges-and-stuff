package compare.impl;

import compare.Compare;
import java.util.Arrays;


public class ArrayDeepCompare<T extends Object> implements Compare<T[]> {

    @Override
    public boolean equal(T[] expected, T[] actual) {
        return Arrays.deepEquals(expected, actual);
    }
}
