package solutions.arrays;

import core.Solution;
import core.io.Input;
import core.io.Output;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *      <ul>
 *          <li>
 *              Sort both arrays in ascending order. Initialize a variable to
 *              hold the smallest difference seen so far.
 *          </li>
 *          <li>
 *              Initialize two pointers, one each at start of both arrays
 *              respectively.
 *          </li>
 *          <li>
 *              Store absolute difference and increment pointer of array that has
 *              the smallest current element among the two.
 *              If absolute difference is less than smallest so far, set the current
 *              difference as smallest.
 *          </li>
 *          <li>
 *              Repeat this until you find two equal elements or one of the pointers reaches
 *              the end of the array.
 *          </li>
 *      </ul>
 * </p>
 */
@SuppressWarnings("unchecked")
public class SmallestDifferenceSolution implements Solution {
    @Override
    public Output<?> solve(Input<?> input) {
        List<Input> inputList = (List<Input>) input.getInput();
        int[] arrayOne = (int[]) inputList.get(0).getInput();
        int[] arrayTwo = (int[]) inputList.get(1).getInput();

        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int i = 0;
        int j = 0;

        int[] result = new int[]{0, 0};

        int difference;
        int smallest = Integer.MAX_VALUE;


        while(i < arrayOne.length && j < arrayTwo.length) {

            difference = Math.abs(arrayOne[i] - arrayTwo[j]);

            if(smallest > difference) {
                smallest = difference;
                result[0] = arrayOne[i];
                result[1] = arrayTwo[j];
            }

            if (arrayOne[i] < arrayTwo[j]) i++;

            else if (arrayOne[i] > arrayTwo[j]) j++;

            else {
                result[0] = arrayOne[i];
                result[1] = arrayTwo[j];
                break;
            }

        }

        return new Output<>(result);
    }

}
