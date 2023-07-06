package solver.impl.graph;

import com.google.common.reflect.TypeToken;
import com.google.inject.name.Named;
import core.datastructure.Coord;
import model.TestCases;
import solver.SolverType;
import parser.Parser;
import problem.compare.Compare;
import problem.input.impl.GenericInput;
import problem.output.impl.GenericOutput;
import solver.BaseSolver;

import javax.inject.Inject;
import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/number-of-islands/
 */
@SolverType
public class FindNoOfIslandsSolver
        extends BaseSolver<GenericInput<Integer[][]>, GenericOutput<Integer>> {

    private final Parser<TestCases<GenericInput<Integer[][]>, GenericOutput<Integer>>> parser;

    @Inject
    public FindNoOfIslandsSolver(
            @Named("jsonParser")
            Parser parser,
            @Named("noOfIslandProblem") String fileName,
            Map<String, Compare> compareMap
    ) {
        super(parser, fileName, compareMap);
        assert (Objects.nonNull(parser));
        this.parser = parser;
    }

    public GenericOutput<Integer> solveProblem(GenericInput<Integer[][]> input) {
        Integer[][] grid = input.getValue();

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Integer islandCount = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col ++) {
                if(!visited[row][col] && grid[row][col] == 1) {
                    islandCount++;
                    bfs(grid, visited, new Coord(row, col));
                }
            }
        }

        GenericOutput output = new GenericOutput();

        output.setValue(islandCount);

        return output;
    }

    private void bfs(Integer[][] grid, boolean[][] visited, Coord start) {
        Deque<Coord> queue = new ArrayDeque<>();
        queue.add(start);

        while(!queue.isEmpty()) {

            Coord current = queue.pop();
            int row = current.getRow();
            int col = current.getCol();

            visited[row][col] = true;

            List<Coord> neighbors = getNeighbors(grid, current).stream()
                    .filter(c -> !visited[c.getRow()][c.getCol()])
                    .filter(c -> grid[c.getRow()][c.getCol()] == 1)
                    .collect(Collectors.toList());

            queue.addAll(neighbors);

        }
    }

    private List<Coord> getNeighbors(Integer[][] grid, Coord current) {
        int[] rowOffsets = new int[]{-1, 0, 1, 0};
        int[] colOffsets = new int[]{0, 1, 0, -1};

        int rowSize = grid.length;
        int colSize = grid[0].length;

        int currentRow = current.getRow();
        int currentCol = current.getCol();

        List<Coord> neighbors = new ArrayList<>();

        for(int rowOffsetIdx = 0; rowOffsetIdx < rowOffsets.length; rowOffsetIdx++) {
            int rowOffset = rowOffsets[rowOffsetIdx];
            int colOffset = colOffsets[rowOffsetIdx];

            int neighborRowIdx = currentRow + rowOffset;
            int neighborColIdx = currentCol + colOffset;

            if (neighborRowIdx >= 0 && neighborRowIdx < rowSize && neighborColIdx >=0 && neighborColIdx < colSize) {
                neighbors.add(new Coord(neighborRowIdx, neighborColIdx));
            }
        }

        return neighbors;
    }

    protected TestCases<GenericInput<Integer[][]>, GenericOutput<Integer>> getTestCases() {
        return parser.parse(getConfigFile(), new TypeToken<>() {
        });
    }

}
