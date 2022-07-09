package solutions.graphs;

import java.util.ArrayDeque;

import core.Solution;
import core.io.Input;
import core.io.Output;

public class MinimumPassesOfmatrixSolution implements Solution{

    @Override
    public Output<?> solve(Input<?> input) {
        int[][] matrix = (int[][]) input.getInput();
        return new Output<>(findMinpasses(matrix));
    }

    /**
     * <b>T</b>O(wh) <b>S</b> O(wh)
     * @param matrix
     * @return
     */
    private final int findMinpasses(int[][] matrix) {

        int passes = 0;
        ArrayDeque<Integer[]> queue = new ArrayDeque<>();
        addPositivesToQueue(matrix, queue);
        int currQueueSize = queue.size();

        while(currQueueSize > 0 && !queue.isEmpty()) {
            Integer[] nextIdx = queue.removeFirst();
            currQueueSize--;
            flipAndAddAdjacentNegatives(matrix, queue, nextIdx);
            if(currQueueSize == 0) {
                passes++;
                currQueueSize = queue.size();
            }
        }

        return containsNegatives(matrix) ? -1 : passes - 1;

    }

    private final boolean containsNegatives(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] < 0) return true;
            }
        }
        return false;
    }

    private final void addPositivesToQueue(int[][] matrix, ArrayDeque<Integer[]> queue) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                int currentVal = matrix[i][j];
                if(currentVal > 0) queue.addLast(new Integer[]{i, j});
            }
        }
    }

    private final void flipAndAddAdjacentNegatives(int[][] matrix, ArrayDeque<Integer[]> queue, Integer[] currentPosition) {
        int row = currentPosition[0];
        int column = currentPosition[1];

        if(row > 0 && matrix[row - 1][column] < 0) {
            queue.addLast(new Integer[]{row - 1, column});
            matrix[row - 1][column] *= -1;
        }
        if(row < matrix.length - 1 && matrix[row + 1][column] < 0){
            queue.addLast(new Integer[]{row + 1, column});
            matrix[row + 1][column] *= -1;
        }
        if(column > 0 && matrix[row][column - 1] < 0) {
            queue.addLast(new Integer[]{row, column - 1});
            matrix[row][column - 1] *= -1;
        }
        if(column < matrix[0].length - 1 && matrix[row][column + 1] < 0){
            queue.addLast(new Integer[]{row, column + 1});
            matrix[row][column + 1] *= -1;
        }
    }

}
