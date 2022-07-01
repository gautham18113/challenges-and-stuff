package solutions.string;

import java.util.List;

import core.Solution;
import core.io.Input;
import core.io.Output;

public class LevenshteinDistanceSolution implements Solution {

    @SuppressWarnings("all")
    @Override
    public Output<?> solve(Input<?> input) {
        List<Input> inputs = (List<Input>) input.getInput();

        String source = (String) inputs.get(0).getInput();
        String dest = (String) inputs.get(1).getInput();

        int distance = levenshtein(source, dest);

        return new Output<>(distance);
    }

    /**
     * <p>
     * To calculate minimum cost to convert a source string to destination string,
     * we are going to calculate the minium cost required to calculate every
     * possible combination of a given substring from the source string to a
     * substring in the destination string.
     * </p>
     * <p>
     * Since a lot of these substring conversions are shared among other bigger
     * strings, we will use a 2d array to store optimal costs that have already been
     * calculated.
     * </p>
     * <pre>
     * +--------+--------+
     * |        |        |
     * |REPLACE | DELETE |
     * |        |        |
     * +--------+--------+
     * |        |
     * | INSERT | CURRENT
     * +--------+
     * </pre>
     * <pre>
     * |   | N | A | B |
     * |---|---|---|---|
     * | N | 0 | 1b| 2a|
     * | Y | 1 | 1c| 2x|
     * | A | 2 | 1d| 2 |
     * </pre>
     *
     * <p> N -> Null string, source -> AB, destination -> YA </p>
     * <p> cost to create x = min(cost to create a, cost to create b, cost to create c) </p>
     * <p> a -> cost for AB -> "" + Insert Y </p>
     * <p> b -> cost for A -> "" + Replace B with Y </p>
     * <p> c -> cost for A -> Y + Delete B </p>
     *
     * <p> If char At i == char At j, then cost of creating that character is 0 </p>
     * <p> ex: </p>
     * <p> d -> cost of creating A -> A + cost of creating "" -> Y </p>
     * @param source
     * @param dest
     * @return minimum cost to modify source string to dest string
     */
    private final int levenshtein(String source, String dest) {
        int[][] dpArray = new int[dest.length() + 1][source.length() + 1];

        for (int destIdx = 0; destIdx <= dest.length(); destIdx++) {
            for (int srcIdx = 0; srcIdx <= source.length(); srcIdx++) {

                if (destIdx == 0 && srcIdx == 0)
                    dpArray[destIdx][srcIdx] = 0;
                else if (destIdx == 0)
                    dpArray[destIdx][srcIdx] = 1 + dpArray[destIdx][srcIdx - 1];
                else if (srcIdx == 0)
                    dpArray[destIdx][srcIdx] = 1 + dpArray[destIdx - 1][srcIdx];
                else if (source.charAt(srcIdx - 1) == dest.charAt(destIdx - 1)) {
                    dpArray[destIdx][srcIdx] = dpArray[destIdx - 1][srcIdx - 1];
                }
                else {
                    int costToInsert = dpArray[destIdx - 1][srcIdx] + 1;
                    int costToReplace = dpArray[destIdx - 1][srcIdx - 1] + 1;
                    int costToDelete = dpArray[destIdx][srcIdx - 1] + 1;

                    int optimalCost = Math.min(costToDelete, Math.min(costToInsert, costToReplace));

                    dpArray[destIdx][srcIdx] = optimalCost;
                }
            }
        }

        return dpArray[dest.length()][source.length()];
    }

}
