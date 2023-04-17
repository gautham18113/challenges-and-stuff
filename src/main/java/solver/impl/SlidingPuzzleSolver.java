package solver.impl;

import com.google.common.reflect.TypeToken;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import core.datastructure.Coord;
import model.TestCases;
import org.checkerframework.checker.units.qual.A;
import parser.Parser;
import problem.compare.Compare;
import problem.input.impl.GenericInput;
import problem.output.impl.GenericOutput;
import solver.BaseSolver;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SlidingPuzzleSolver
        extends BaseSolver<GenericInput<Integer[][]>, GenericOutput<Integer>> {

    @Inject
    public SlidingPuzzleSolver(
            @Named("jsonParser")
            Parser parser,
            @Named("slidingPuzzleProblem")
            String fileName,
            Map<String, Compare> compareMap) {
        super(parser, fileName, compareMap);
    }

    public GenericOutput<Integer> solveProblem(GenericInput<Integer[][]> input) {
        GenericOutput<Integer> output = new GenericOutput<>();
        output.setValue(bfs(input.getValue()));
        return output;
    }

    private Integer bfs(Integer[][] puzzle) {
        int level = 0;
        String expectedState = "123450";

        Deque<String> queue = new ArrayDeque<>();
        queue.add(serialize(puzzle));
        Set<String> visited = new HashSet<>();

        while (!queue.isEmpty()) {

            int queueSize = queue.size();

            for (int queueIdx = 0; queueIdx < queueSize; queueIdx++) {
                String currentState = queue.pop();

                if (visited.contains(currentState)) {
                    continue;
                }

                visited.add(currentState);

                if (currentState.equals(expectedState)) {
                    return level;
                }

                Integer[][] currentStateDeser = deSerialize(currentState);
                Coord start = getBlankSpace(currentStateDeser);

                for (Coord neighbor : getNeighbors(start, currentStateDeser.length,
                        currentStateDeser[0].length)) {
                    // Arrange
                    int neiRow = neighbor.getRow();
                    int neiCol = neighbor.getCol();
                    int curRow = start.getRow();
                    int curCol = start.getCol();

                    // Swap
                    int temp = currentStateDeser[neiRow][neiCol];
                    currentStateDeser[neiRow][neiCol] = currentStateDeser[curRow][curCol];
                    currentStateDeser[curRow][curCol] = temp;

                    // Serialize
                    String newState = serialize(currentStateDeser);

                    if (newState.equals(expectedState)) {
                        return level;
                    }

                    // Enqueue new state
                    queue.push(newState);

                    // un-swap
                    temp = currentStateDeser[neiRow][neiCol];
                    currentStateDeser[neiRow][neiCol] = currentStateDeser[curRow][curCol];
                    currentStateDeser[curRow][curCol] = temp;

                }
            }

            level++;
        }

        return -1;
    }

    private List<Coord> getNeighbors(Coord current, int rowSize, int colSize) {
        // starting from top
        int[] rowOffsets = new int[]{-1, 0, 1, 0};
        int[] colOffsets = new int[]{0, 1, 0, -1};

        List<Coord> neighbors = new ArrayList<>(4);

        for (int offsetIdx = 0; offsetIdx < rowOffsets.length; offsetIdx++) {
            int neighborRowIdx = current.getRow() + rowOffsets[offsetIdx];
            int neighborColIdx = current.getCol() + colOffsets[offsetIdx];

            if (neighborRowIdx >= 0 && neighborRowIdx < rowSize && neighborColIdx >= 0 &&
                    neighborColIdx < colSize) {
                neighbors.add(new Coord(neighborRowIdx, neighborColIdx));
            }
        }

        return neighbors;
    }

    private String serialize(Integer[][] puzzle) {
        StringBuilder serialized = new StringBuilder();

        for (Integer[] row : puzzle) {

            serialized.append(
                    Arrays.stream(row).map(String::valueOf).collect(Collectors.joining())
            );
        }

        return serialized.toString();
    }

    private Integer[][] deSerialize(String serialized) {
        StringBuilder deser = new StringBuilder();
        deser.append(serialized);
        Integer[][] result = new Integer[2][3];
        IntStream.range(0, 6).forEach(
                idx -> {
                    if (idx <= 2) {
                        result[0][idx] = Integer.valueOf(String.valueOf(deser.charAt(idx)));
                    } else {
                        result[1][idx - 3] = Integer.valueOf(String.valueOf(deser.charAt(idx)));
                    }
                }
        );

        return result;
    }

    private Coord getBlankSpace(Integer[][] puzzle) {

        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[i].length; j++) {
                if (puzzle[i][j] == 0) {
                    return new Coord(i, j);
                }
            }
        }
        return null;
    }

    public TestCases getTestCases() {
        return this.parser.parse(getConfigFile(), new TypeToken<>() {
        });
    }
}
