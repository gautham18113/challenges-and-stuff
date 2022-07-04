package solutions.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import core.Solution;
import core.io.Input;
import core.io.Output;

public class RemoveIslandsSolution implements Solution {

    @Override
    public Output<?> solve(Input<?> input) {
        int[][] matrix = (int[][]) input.getInput();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (visited[row][col])
                    continue;
                traverse(matrix, row, col, visited);
            }

        }
        return new Output<>(matrix);
    }

    /**
     * <p>
     * This is graph traversal problem where we use BFS or DFS to
     * traverse the graph and keep note of "islands" in the graph.
     * </p>
     * <p>
     * <b>T</b> O(width * height) <b>S</b> O(width * height)
     * </p>
     * <p>
     *
     * The space complexity is because of the "toSwap" array created, In the
     * worst case, if all elements in the array are valid array elements. Then
     * the size of that array will be (width - 1) * (height - 1) excluding corners.
     *
     * </p>
     *
     * @param matrix The graph
     * @param row starting row of graph
     * @param col starting column of graph
     * @param visited visited nodes matrix
     */
    public void traverse(int[][] matrix, int row, int col, boolean[][] visited) {

        Queue<Integer[]> queue = new LinkedList<>();

        List<Integer[]> toSwap = new ArrayList<>();

        queue.add(new Integer[] { row, col });

        boolean maybeIsland = true;

        while (!queue.isEmpty()) {

            Integer[] current = queue.poll();

            int cRow = current[0];
            int cCol = current[1];

            if (visited[cRow][cCol])
                continue;

            visited[cRow][cCol] = true;

            if (matrix[cRow][cCol] == 0)
                continue;

            maybeIsland &= isIsland(matrix, cRow, cCol);

            addUnvisitedNeighbors(matrix, cRow, cCol, visited, queue);

            if (maybeIsland) {
                toSwap.add(new Integer[] { cRow, cCol });
            } else {
                toSwap = new ArrayList<>();
            }
        }

        if (toSwap.size() > 0) {
            toSwap.forEach(e -> matrix[e[0]][e[1]] = 0);
        }
    }

    private boolean isIsland(int[][] matrix, int row, int col) {
        if (row - 1 < 0 || (row - 1 == 0 && matrix[row - 1][col] == 1) || col - 1 < 0
                || (col - 1 == 0 && matrix[row][col - 1] == 1) || row + 1 > matrix.length - 1
                || (row + 1 == matrix.length - 1 && matrix[row + 1][col] == 1) || col + 1 > matrix[0].length - 1
                || (col + 1 == matrix[0].length - 1 && matrix[row][col + 1] == 1)) {
            return false;
        }
        return true;
    }

    private void addUnvisitedNeighbors(int[][] matrix, int row, int col, boolean[][] visited, Queue<Integer[]> queue) {

        if (row > 0 && !visited[row - 1][col])
            queue.add(new Integer[] { row - 1, col });
        if (col > 0 && !visited[row][col - 1])
            queue.add(new Integer[] { row, col - 1 });
        if (row < matrix.length - 1 && !visited[row + 1][col])
            queue.add(new Integer[] { row + 1, col });
        if (col < matrix[0].length - 1 && !visited[row][col + 1])
            queue.add(new Integer[] { row, col + 1 });

    }
}
