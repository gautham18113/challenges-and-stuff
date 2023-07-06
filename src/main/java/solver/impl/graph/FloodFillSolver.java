package solver.impl.graph;


import com.google.common.reflect.TypeToken;
import com.google.inject.name.Named;
import core.datastructure.Coord;
import model.TestCases;
import module.SolverType;
import parser.Parser;

import com.google.inject.Inject;
import problem.compare.Compare;
import problem.input.impl.FloodFillInput;
import problem.output.impl.GridOutput;
import solver.BaseSolver;

import java.util.*;

/**
 * https://leetcode.com/problems/flood-fill/
 */
@SolverType
public class FloodFillSolver extends BaseSolver<FloodFillInput, GridOutput<Integer>> {

    @Inject
    public FloodFillSolver(
            @Named("jsonParser") Parser parser,
            @Named("floodFillProblem") String fileName,
            Map<String, Compare> compareMap){
        super(parser, fileName, compareMap);
        assert(Objects.nonNull(parser));
        this.parser = parser;

    }

    @Override
    public GridOutput solveProblem(FloodFillInput input) {

        int r = input.getR();
        int c = input.getC();
        int replacement = input.getReplacement();
        Integer[][] image = input.getImage();

        bfs(image, replacement, new Coord(r, c));

        GridOutput output1 = new GridOutput();

        output1.setValue(image);

        return output1;

    }

    private void bfs(Integer[][] matrix, int replacement, Coord targetCoord) {

        Deque<Coord> queue = new ArrayDeque<>();

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        queue.add(targetCoord);

        int target = matrix[targetCoord.getRow()][targetCoord.getCol()];

        while (queue.size() > 0) {
            Coord curr = queue.pop();

            if (visited[curr.getRow()][curr.getCol()]) {
                continue;
            }

            visited[curr.getRow()][curr.getCol()] = true;

            for (Coord neighbor: getNeighbors(curr)) {
                if (matrix[neighbor.getRow()][neighbor.getCol()] == target) {
                    queue.add(neighbor);
                    matrix[neighbor.getRow()][neighbor.getCol()] = replacement;
                }
            }
        }
    }

    private List<Coord> getNeighbors(Coord c) {
        int[] rowOffsets = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
        int[] colOffsets = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
        List<Coord> neighbors = new ArrayList<>();
        for (int i=0; i<8; i++) {
            neighbors.add(new Coord(c.getRow() + rowOffsets[i], c.getCol() + colOffsets[i]));
        }

        return neighbors;
    }

    @Override
    protected TestCases getTestCases() {
        return parser.parse(getConfigFile(), new TypeToken<>(){});
    }

}
