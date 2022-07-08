package solutions.graphs;

import java.util.ArrayDeque;

import core.Solution;
import core.io.Input;
import core.io.Output;

public class CycleInGraphSolution implements Solution {

    @Override
    public Output<?> solve(Input<?> input) {
        int[][] matrix = (int[][]) input.getInput();

        boolean cycle = hasCycle(matrix);
        return new Output<>(cycle);
    }

    private boolean hasCycle(int[][] matrix) {
        boolean hasCycle = false;
        for (int i = 0; i < matrix.length; i++) {
            hasCycle = traverse(i, matrix);
            if (hasCycle)
                return hasCycle;
        }
        return false;
    }

    /**
     * <p>
     * This traversal method traverrses the entire graph from the
     * starting node to check if the starting node is visited again at
     * any point in the traversal.
     * </p>
     * <p>
     * This is inefficient since as a part of traversing, there might be
     * a cycle within the tree that might not necessarily end with the starting
     * node.
     * </p>
     * <b>T</b> O(ve) <b>S</b> O(v)
     *
     * @param currentIdx
     * @param matrix
     * @return
     */
    private boolean traverse(int currentIdx, int[][] matrix) {

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.add(currentIdx);
        boolean[] visited = new boolean[matrix.length];

        while (!stack.isEmpty()) {
            int curr = stack.pop();
            if (visited[curr]) {
                if (curr == currentIdx)
                    return true;
                continue;
            }
            ;
            visited[curr] = true;
            for (int i = 0; i < matrix[curr].length; i++)
                stack.add(matrix[curr][i]);
        }
        return false;
    }

}
