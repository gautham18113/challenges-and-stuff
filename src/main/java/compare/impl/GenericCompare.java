package compare.impl;

import compare.Compare;

public class GenericCompare implements Compare<Object> {
    @Override
    public boolean equal(Object expected, Object actual) {
        return expected.equals(actual);
    }
}
