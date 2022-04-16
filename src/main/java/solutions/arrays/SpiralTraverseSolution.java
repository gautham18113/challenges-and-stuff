package solutions.arrays;

import core.Solution;
import core.io.Input;
import core.io.Output;

import java.util.ArrayList;
import java.util.List;

/**
 * First column increases, then row increases, then column decreases, then row decreases.
 *
 * Each iteration has a predefined start and end. First iteration is 0 to n for column and
 * 0 to m for row. Then again n to 0 for column and m to 0 for row.
 *
 * Next iteration is 1 to n-1 for column and 1 to m-1 for row.
 */
public class SpiralTraverseSolution implements Solution {

    @Override
    public Output<?> solve(Input<?> input) {
        int[][] array = (int[][]) input.getInput();
        int numRows = array.length;
        int numCols = array[0].length;

        List<Integer> result = new ArrayList<>();

        int startCol = 0;
        int endCol = numCols - 1;
        int startRow = 0;
        int endRow = numRows - 1;

        while(startCol <= endCol && startRow <= endRow) {

            for(int col = startCol; col <= endCol; col++) {
                result.add(array[startRow][col]);
            }
            for(int row = startRow + 1; row <= endRow; row++) {
                result.add(array[row][endCol]);
            }
            for(int col = endCol - 1; col >= startCol; col--) {
                /*
                 * Handle the edge case where there is only one row
                 * in the middle. We don't want to double count this row.
                 * Since we have counted it in the first for loop above.
                 * Example:
                 *
                 *      |  1   2   3   4  |
                 *      |  10  11  12  15 |
                 *      |  9   8   7   6  |
                 */
                if(startRow == endRow) break;
                result.add(array[endRow][col]);
            }
            for(int row = endRow - 1; row > startRow; row--) {
                /*
                 * Handle the edge case where there is only one col
                 * in the middle. We don't want to double count the values in this column.
                 * Since we have counted it in the second for loop above.
                 * Example:
                 * [ 1,  2,  3],
                 * [ 12, 13, 4],
                 * [ 11, 14, 5],
                 * [ 10, 15, 6],
                 * [ 9,  8,  7]
                 *
                 */
                if(startCol == endCol) break;
                result.add(array[row][startCol]);
            }
            startCol++;
            endCol--;
            startRow++;
            endRow--;
        }

        int[] resultArray = new int[result.size()];

        for(int i=0; i<result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return new Output<>(resultArray);
    }
}
