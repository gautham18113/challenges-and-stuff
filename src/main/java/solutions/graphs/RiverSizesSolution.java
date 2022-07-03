package solutions.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import core.Solution;
import core.io.Input;
import core.io.Output;

public class RiverSizesSolution implements Solution{

    @Override
    public Output<?> solve(Input<?> input) {
        int[][] array = (int[][]) input.getInput();

        List<Integer> riverSizes = rivers(array);

        return new Output<>(riverSizes);
    }

    private List<Integer> rivers(int[][] array) {

        boolean[][] visited = new boolean[array.length][array[0].length];

        List<Integer> riverSizes = new ArrayList<>();

        for(int i = 0; i < array.length; i++) {

            for(int j = 0; j < array[0].length; j++) {

                if(visited[i][j]) continue;

                traverse(array, i, j, visited, riverSizes);

            }
        }

        /* For tests */
        Collections.sort(riverSizes);

        return riverSizes;

    }

    private void traverse(int[][] array, int i, int j, boolean[][] visited, List<Integer> riverSizes) {

            int riverSize = 0;

            Queue<Integer[]> queue = new LinkedList<>();

            queue.add(new Integer[]{i, j});

            while(!queue.isEmpty()) {

                Integer[] current = queue.poll();

                if(visited[current[0]][current[1]]) continue;

                visited[current[0]][current[1]] = true;

                /*
                 * The code won't get past this stage if none of the children nodes
                 * are 1
                 */
                if(array[current[0]][current[1]] == 0) continue;

                riverSize++;

                addUnvisitedChildren(array, current[0], current[1], queue, visited);

            }

            if(riverSize > 0) riverSizes.add(riverSize);
    }

    private void addUnvisitedChildren(int[][] array, int i, int j, Queue<Integer[]> queue, boolean[][] visited) {
        if(j>0 && !visited[i][j-1]) queue.add(new Integer[]{i, j-1});
        if(i > 0 && !visited[i-1][j]) queue.add(new Integer[]{i-1, j});
        if(j<array[0].length-1 && !visited[i][j+1]) queue.add(new Integer[]{i, j+1});
        if(i<array.length-1 && !visited[i+1][j]) queue.add(new Integer[]{i+1, j});
    }

}
