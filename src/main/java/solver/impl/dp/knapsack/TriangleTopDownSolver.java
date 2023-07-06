package solver.impl.dp.knapsack;

import com.google.common.reflect.TypeToken;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import core.datastructure.Coord;
import model.TestCases;
import module.SolverType;
import parser.Parser;
import problem.compare.Compare;
import problem.input.impl.GenericInput;
import problem.output.impl.GenericOutput;
import solver.BaseSolver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SolverType
public class TriangleTopDownSolver
        extends BaseSolver<GenericInput<Integer[][]>, GenericOutput<Integer>> {

    @Inject
    public TriangleTopDownSolver(
            @Named("jsonParser")
            Parser parser,
            @Named("triangleProblem")
            String fileName,
            Map<String, Compare> compareMap) {
        super(parser, fileName, compareMap);
    }

    public TestCases getTestCases() {
        return parser.parse(getConfigFile(), new TypeToken<>() {
        });
    }

    @Override
    public GenericOutput<Integer> solveProblem(GenericInput<Integer[][]> input) {

        GenericOutput<Integer> output = new GenericOutput<>();
        output.setValue(dfs(input.getValue(), new Coord(0,0), new HashMap<>()));
        return output;
    }

    /**
     * Clarifying questions:
     * - are negative values allowed
     * @param triangle
     * @param node
     * @param memo
     * @return
     */
    public Integer dfs(Integer[][] triangle, Coord node, Map<Coord, Integer> memo) {
        // leaf condition
        if (node.getRow() == triangle.length) {
            return 0;
        }

        // return minimum sum at node if node was already visited
        if (memo.containsKey(node)) {
            return memo.get(node);
        }

        // initialize the minimum branch sum to infinity initially
        int minimumBranchSum = Integer.MAX_VALUE;

        for (Coord neighbor : getNeighbor(node, triangle)) {
            // get the minimum branch sum from all child nodes
            minimumBranchSum = Math.min(minimumBranchSum, dfs(triangle, neighbor, memo));
        }

        memo.put(node, triangle[node.getRow()][node.getCol()] + minimumBranchSum);

        return memo.get(node);
    }

    private List<Coord> getNeighbor(Coord node, Integer[][] triangle) {
        Integer[] rowOffsets = new Integer[]{1, 1};
        Integer[] colOffsets = new Integer[]{0, 1};
        int rowSize = triangle.length;
        int colSize = triangle[node.getRow()].length;

        List<Coord> neighbors = new ArrayList<>();

        for (int offsetIdx = 0; offsetIdx < 2; offsetIdx++) {
            int r = node.getRow() + rowOffsets[offsetIdx];
            int c = node.getCol() + colOffsets[offsetIdx];

            // add rows + 1 to indicate a leaf
            if (r >= 0 && r <= rowSize && c >= 0 && c < colSize) {
                neighbors.add(new Coord(r, c));
            }
        }

        return neighbors;
    }
}
