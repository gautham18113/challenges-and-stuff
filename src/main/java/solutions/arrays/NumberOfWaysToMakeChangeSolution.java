package solutions.arrays;

import java.util.List;

import core.Solution;
import core.io.Input;
import core.io.Output;

public class NumberOfWaysToMakeChangeSolution implements Solution{

    @Override
    @SuppressWarnings("all")
    public Output<?> solve(Input<?> input) {
        List<Input> inputList = (List<Input>) input.getInput();

        int n = (int) inputList.get(0).getInput();
        int[] denoms = (int[]) inputList.get(1).getInput();
        findNumberOfWaysToMakeChange(n, denoms);
        int numberOfWays = findNumberOfWaysToMakeChangeSimplified(n, denoms);

        return new Output<>(numberOfWays);
    }


    /**
     * A 2d array is created whose cell value represents the number of ways an amount
     * from 0 to n can be constructed whenever we add a denomination to the input.
     *<p>
     * A point in this array represents the number of ways an amount can be constructed
     * using the given denomination.
     * <p>
     * Example:
     * </p>
     * <p>
     * dpArray[1, 5] represents number of ways the amount 5 can be constructed with denom denoms[1-1]=1 (say).
     * </p>
     * <p>
     * dpArray[0, 5] represents the number of ways the amount 5 can be constructed without denom 1.
     * </p>
     * <p>
     * Total number of ways amount 1 can be constructed dpArray[1, 5] = dpArray[1, 5] + dpArray[0, 5]
     * </p>
     * <p>
     * dpArray[0, x] represents constructing an amount with no denomination which is 0 by default.
     * </p>
     * <p>
     * dpArray[x, 0] represents constructing an amount 0 with any denomination and is 1 by default (base case).
     * </p>
     * A point in this array represents the number of ways an amount can be constructed
     * using the given denomination.
     * <p>
     * Example:
     * </p>
     * <p>
     * dpArray[1, 5] represents number of ways the amount 5 can be constructed with denom denoms[1-1]=1 (say).
     * </p>
     * <p>
     * dpArray[0, 5] represents the number of ways the amount 5 can be constructed without denom 1.
     * </p>
     * <p>
     * Total number of ways amount 1 can be constructed dpArray[1, 5] = dpArray[1, 5] + dpArray[0, 5]
     * </p>
     * <p>
     * dpArray[0, x] represents constructing an amount with no denomination which is 0 by default.
     * </p>
     * <p>
     * dpArray[x, 0] represents constructing an amount 0 with any denomination and is 1 by default (base case).
     * </p>
     * <p>Checkout detailed solution here: https://www.youtube.com/watch?v=DJ4a7cmjZY0 </p>
     * @param n
     * @param denoms
     * @return number of ways to construct given amount n using denoms
     */
    private final int findNumberOfWaysToMakeChange(int n, int[] denoms) {
        /*

         */
        int[][] dpArray = new int[denoms.length + 1][n + 1];

        /*
         * <p>
         * The sub problem is to find the number of ways any amount i can be generated
         * using a given coin denomination, where 0 <= i <= n. This will build up from 0
         * to n. At each step, we will have a decision: ways to construct i using given denomination and
         * ways construct i without using given denomination.
         * </p>
         */

        for(int denomIdx = 0; denomIdx <= denoms.length; denomIdx++) {
            int denominationValue = denomIdx > 0 ? denoms[denomIdx - 1] : 0;
            for(int amount = 0; amount <= n; amount++) {

                /* base case */
                if(denomIdx == 0 && amount == 0) dpArray[denomIdx][amount] = 1;
                /*
                 * an amount of 0 can be constructed with
                 * any denomination.
                 */
                else if (amount == 0) dpArray[denomIdx][amount] = 1;
                /*
                 * No denomination, so ways that change can be made is 0. So we
                 * leave it at default value.
                 */
                else if (denomIdx == 0) continue;
                /*
                 * If denomination is less than amount to be constructed, then we
                 * can construct that amount with the given denomination. If not we
                 * cannot construct the amount with the given denomination. In the latter
                 * case, our decision becomes just 1, construct amount without given
                 * denomination.
                 */
                else {

                    if(denominationValue <= amount) {

                        dpArray[denomIdx][amount] =
                            /* Number of ways to create amount with denomination exclusive */
                            dpArray[denomIdx - 1][amount]
                            /* Number of ways to create amount with denomination inclusive */
                            + dpArray[denomIdx][amount - denominationValue];
                    }
                    else {
                        dpArray[denomIdx][amount] = dpArray[denomIdx - 1][amount];
                    }
                }
            }
        }

        return dpArray[denoms.length][n];
    }

    private final int findNumberOfWaysToMakeChangeSimplified(int n, int[] denoms) {

        int[] dpArray = new int[n + 1];

        for(int denomIdx = 0; denomIdx < denoms.length; denomIdx++) {

            int denominationValue = denoms[denomIdx];

            for(int amount = 0; amount <= n; amount++) {

                /*
                 * Base case, an amount of 0 can be constructed with
                 * any denomination.
                 */
                if (amount == 0) dpArray[amount] = 1;

                else {

                    if(denominationValue <= amount) {

                        dpArray[amount] =
                            /* Number of ways to create amount with denomination exclusive */
                            dpArray[amount]
                            /* Number of ways to create amount with denomination inclusive */
                            + dpArray[amount - denominationValue];
                    }

                }
            }
        }

        return dpArray[n];
    }

}
