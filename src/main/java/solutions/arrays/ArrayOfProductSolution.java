package solutions.arrays;

import core.Solution;
import core.io.Input;
import core.io.Output;

public class ArrayOfProductSolution implements Solution{

    @Override
    public Output<?> solve(Input<?> input) {
        int[] array = (int[]) input.getInput();

        int[] product = new int[array.length];

        int runningProduct = 1;

        /* forward cycle */
        for(int i = 0; i < array.length; i++) {

            product[i] = runningProduct;
            runningProduct *= array[i];

        }

        runningProduct = 1;

        /* reverse cycle */

        for(int i = array.length - 1; i >=0; i--) {
            product[i] = product[i] * runningProduct;

            runningProduct *= array[i];
        }

        return new Output<>(product);
    }

}
