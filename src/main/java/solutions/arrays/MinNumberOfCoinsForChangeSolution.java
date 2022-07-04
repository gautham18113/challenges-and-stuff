package solutions.arrays;

import java.util.List;

import core.Solution;
import core.io.Input;
import core.io.Output;

public class MinNumberOfCoinsForChangeSolution implements Solution {

    @SuppressWarnings("all")
    @Override
    public Output<?> solve(Input<?> input) {
        List<Input> inputs = (List<Input>) input.getInput();
        int n = (int) inputs.get(1).getInput();
        int[] denoms = (int[]) inputs.get(0).getInput();
        int minCoins = minCoins(n, denoms);
        return new Output<>(minCoins);
    }

    private int minCoins(int n, int[] denoms) {

        int[] coins = new int[n + 1];
        coins[0] = 0;

        for (int denom : denoms) {
            for (int amount = 0; amount < coins.length; amount++) {
                if (denom <= amount) {
                    int remain = amount - denom;

                    if (remain > 0 && coins[remain] == 0) {
                        continue;
                    }

                    if (coins[amount] == 0) {
                        coins[amount] = 1 + coins[remain];
                    } else {
                        coins[amount] = Math.min(coins[amount], 1 + coins[remain]);
                    }
                }
            }
        }
        return coins[coins.length - 1] == 0 ? -1 : coins[coins.length - 1];
    }
}
