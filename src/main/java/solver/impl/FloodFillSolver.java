package solver.impl;


import com.google.common.reflect.TypeToken;
import com.google.inject.name.Named;
import core.datastructure.Coord;
import model.TestCase;
import model.TestCases;
import parser.Parser;

import com.google.inject.Inject;
import parser.impl.JsonParser;
import problem.compare.Compare;
import problem.input.impl.FloodFillInput;
import problem.output.FloodFillOutput;
import problem.output.ProblemOutput;
import solver.AbstractSolver;
import solver.BaseSolver;
import solver.Solver;
import solver.SolverOutput;

import java.util.*;

/**
 * <div>
 *     <div><h1>Problem Statement</h1></div>
 *     <div>
 *         In computer graphics, an uncompressed raster image is presented as a matrix of numbers.
 *         Each entry of the matrix represents the color of a pixel. A flood fill algorithm takes a
 *         coordinate r, c and a replacement color, and replaces all pixels connected to r, c that
 *         have the same color (i.e., the pixels connected to the given coordinate with same color
 *         and all the other pixels connected to the those pixels of the same color) with the
 *         replacement color. (e.g. MS-Paint's paint bucket tool).
 *     </div>
 *     <div><h1>Input</h1></div>
 *     <div>r: row</div>
 *     <div>c: column</div>
 *     <div>replacement: replacement color</div>
 *     <h1>Output</h1>
 * </div>
 */
public class FloodFillSolver extends BaseSolver<FloodFillInput, FloodFillOutput> {

    private Parser<TestCases<FloodFillInput, FloodFillOutput>> parser;

    @Inject
    public FloodFillSolver(
            @Named("floodFillParser") Parser<TestCases<FloodFillInput, FloodFillOutput>> parser,
            @Named("floodFillProblem") String fileName,
            Map<String, Compare> compareMap){
        super(parser, fileName, compareMap);
        assert(Objects.nonNull(parser));
        this.parser = parser;

    }

    @Override
    public FloodFillOutput solveProblem(FloodFillInput input) {

        int r = input.getR();
        int c = input.getC();
        int replacement = input.getReplacement();
        Integer[][] image = input.getImage();

        bfs(image, replacement, new Coord(r, c));

        FloodFillOutput output1 = new FloodFillOutput();

        output1.setOp(image);

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
    protected TestCases<FloodFillInput, FloodFillOutput> getTestCases() {
        return parser.parse(
                getConfigFile(),
                new TypeToken<>(){});
    }

}
