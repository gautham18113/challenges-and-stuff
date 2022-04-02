package solutions.general;

import core.Solution;
import core.io.Input;
import core.io.Output;

import java.util.HashMap;
import java.util.Map;

public class NthFibonacciRecursiveCachedSolution implements Solution {
    /**
     * <p>
     *      O(n) time | O(n) space
     * </p>
     *
     * <p>
     *     <b>Time Complexity Explanation:</b>
     * </p>
     * <p>
     *     Since we store the result of every fibonacci number, any time
     *     that number is encountered again in the call stack, it is returned
     *     from the cache instead of initiating a series of calls for that number.
     *     Hence fibonacci of every number in n will be calculated once. This gives
     *     a time complexity of O(n).
     * </p>
     * <p>
     *     <b>Space Complexity Explanation:</b>
     * </p>
     * <p>
     *     Since we maintain a hash table whose size will be at the most, n. And
     *     a call stack that can be at the most, n - the space is O(n).
     * </p>
     *
     * @param input {@link Input} wrapper that contains n, the length of fibonacci series
     * @return {@link Integer} nth member of fibonacci series
     */
    @Override
    public Output<?> solve(Input<?> input) {

        Map<Integer, Integer> cache = new HashMap<>();

        cache.put(1, 0);
        cache.put(2, 1);

        int result = nthFiboRecursiveCached(
            (Integer) input.getInput(), cache
        );

        return new Output<>(result);
    }

    public int nthFiboRecursiveCached(int n, Map<Integer, Integer> cache) {

        if(!cache.containsKey(n))
        cache.put(
            n,
            nthFiboRecursiveCached(n - 1, cache) + nthFiboRecursiveCached(n - 2, cache)
        );

        return cache.getOrDefault(n, 0);
    }
}
