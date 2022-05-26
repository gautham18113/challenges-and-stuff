package solutions.arrays;

import core.io.Input;
import core.io.Output;
import core.Solution;

import java.util.Arrays;
import java.util.List;

public class TandemBicycleSolution implements Solution {

    /**
     *
     * The idea is to pair the fastest rider with slowest if <em>fastest </em> flag is true
     * else, pair slowest rider with corresponding slowest rider if <em>fastest </em>is false.<p>
     *
     * In the first case, we sort one array in ascending and the other in descending. So the slowest rider in one
     * array will correspond to the fastest rider in the other.
     * This will make sure max tandem speed possible is obtained.<p>
     *
     * In the second case, we sort both arrays in ascending order.<p>
     * This will make sure min tandem speed possible is obtained.<p>
     *
     * O(nlogn) time | O(1) space
     *
     * @param input {@code Input} Input wrapper containing input required for problem {@link Input}.
     * @return output {@code Output} Output wrapper containing result {@link Output}
     */
    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public Output<?> solve(Input<?> input) {

        List<Input> inputs = (List<Input>) input.getInput();
        int[] redShirtSpeed = (int[]) inputs.get(0).getInput();
        int[] blueShirtSpeed =  (int[]) inputs.get(1).getInput();
        Boolean fastest = inputs.get(2).toBoolean();

        Arrays.sort(redShirtSpeed);
        Arrays.sort(blueShirtSpeed);

        if(fastest) reverseArrayInPlace(blueShirtSpeed);

        int result = 0;

        for(int i = 0; i < redShirtSpeed.length; i++){
            result += Math.max(redShirtSpeed[i], blueShirtSpeed[i]);
        }
        return new Output<>(result);
    }

    public void reverseArrayInPlace(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++; end--;
        }
    }

}
