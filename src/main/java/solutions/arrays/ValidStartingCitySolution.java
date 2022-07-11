package solutions.arrays;

import java.util.List;

import core.Solution;
import core.io.Input;
import core.io.Output;

public class ValidStartingCitySolution implements Solution {

    @SuppressWarnings("all")
    @Override
    public Output<?> solve(Input<?> input) {
        List<Input> inputs = (List<Input>) input.getInput();

        int[] distances = (int[]) inputs.get(0).getInput();
        int[] fuel = (int[]) inputs.get(1).getInput();
        int mpg = (int) inputs.get(2).getInput();
        int validCity = validStartingCity(distances, fuel, mpg);
        return new Output<>(validCity);
    }

    /**
     * <b>T</b> O(n) <b>S</b> O(1)
     * @param distances
     * @param fuel
     * @param mpg
     * @return
     */
    private int validStartingCity(int[] distances, int[] fuel, int mpg) {
        int minRemainFuel = Integer.MAX_VALUE;
        int minRemainIndex = 0;
        int currRemainFuel = 0;

        for(int i = 1; i<distances.length; i++) {
          currRemainFuel = (fuel[i - 1] * mpg) - distances[i - 1] + currRemainFuel;
          if(minRemainFuel > currRemainFuel) {
            minRemainIndex = i;
            minRemainFuel = currRemainFuel;
          }
        }

        currRemainFuel = (fuel[distances.length - 1] * mpg) - distances[distances.length - 1] + currRemainFuel;

        if(minRemainFuel > currRemainFuel) {
          minRemainIndex = 0;
          minRemainFuel = currRemainFuel;
        }
        return minRemainIndex;
      }

}
