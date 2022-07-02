package solutions.graphs;

import java.util.List;

import core.Solution;
import core.io.Input;
import core.io.Output;

public class NumberOfWaysToTraverseGraphSolution implements Solution{

    @SuppressWarnings("all")
    @Override
    public Output<?> solve(Input<?> input) {
        List<Input> inputs = (List<Input>) input.getInput();
        int width = (int) inputs.get(0).getInput();
        int height = (int) inputs.get(1).getInput();

        ways(width, height, 0, 0);
        int waysToTraverse = waysOptimized(width, height);

        return  new Output<>(waysToTraverse);
    }

    /**
     * <b>T</b> O(2^(w + h)) <b>S</b> O(1)
     * @param width
     * @param height
     * @param x
     * @param y
     * @return
     */
    private int ways(int width, int height, int x, int y) {

        int paths = 0;

        if(x == width - 1 && y == height - 1) return 1;

        else if(x >= width) return 0;

        else if(y >= height) return 0;

        else {
            paths += ways(width, height, x + 1, y);
            paths += ways(width, height, x, y + 1);
        }

        return paths;
    }

    private int waysOptimized(int width, int height) {
        int[][] dpArray = new int[height][width];

        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                if(x == 0 && y == 0) continue;
                if(x == 0) dpArray[y][x] = 1;
                else if(y == 0) dpArray[y][x] = 1;
                else {
                    dpArray[y][x] = dpArray[y - 1][x] + dpArray[y][x - 1];
                }
            }
        }
        return dpArray[height - 1][width - 1];
    }

}
