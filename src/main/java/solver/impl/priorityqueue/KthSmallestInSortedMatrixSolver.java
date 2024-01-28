package solver.impl.priorityqueue;

import com.google.common.reflect.TypeToken;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import lombok.Getter;
import model.testcase.TestCases;
import model.solver.SolverType;
import parser.Parser;
import compare.Compare;
import solver.output.GenericOutput;
import solver.impl.BaseSolver;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

@SolverType
public class KthSmallestInSortedMatrixSolver
        extends BaseSolver<KthSmallestInSortedMatrixInput, GenericOutput<Integer>> {

    @Inject
    public KthSmallestInSortedMatrixSolver(
            @Named("jsonParser")
            Parser parser,
            @Named("kthSmallestInSortedMatrixProblem")
            String fileName,
            Map<String, Compare> compareMap) {
        super(parser, fileName, compareMap);
    }

    public GenericOutput<Integer> solveProblem(KthSmallestInSortedMatrixInput input) {
        Integer[][] matrix = input.getMatrix();
        Integer k = input.getK();

        // Since every row in the matrix is sorted, we will use a pointer in each row to point
        // to the smallest element in each row.
        // We will then select the smallest element among the three rows and increment the
        // corresponding pointer to next position in the row. For this purpose we will use a
        // PriorityQueue.
        PriorityQueue<Pointer> queue =
                new PriorityQueue<>(Comparator.comparingInt(Pointer::getValue));

        // Initialize pointer at first element of each row
        for (int i = 0; i < matrix.length; i++) {
            queue.add(new Pointer(matrix[i][0], i, 0));
        }

        int colSize = matrix[0].length;
        int smallestNumber = 0;

        while (!queue.isEmpty()) {
            // Get the pointer with the smallest value
            Pointer smallestPointer = queue.poll();
            k--;
            // Increment pointer to point to next element
            // Do not increment if pointer reaches the last column in the matrix
            if (smallestPointer.getColumn() + 1 < colSize) {
                int row = smallestPointer.getRow();
                int col = smallestPointer.getColumn() + 1;
                int val = matrix[row][col];
                queue.add(new Pointer(val, row, col));
            }

            // Return the smallest value if k becomes 0
            if (k == 0) {
                smallestNumber = smallestPointer.value;
                break;
            }
        }

        GenericOutput<Integer> output = new GenericOutput<>();
        output.setValue(smallestNumber);
        return output;
    }

    public TestCases getTestCases() {
        return parser.parse(getConfigFile(), new TypeToken<>() {
        });
    }

    @Getter
    private class Pointer {
        private final int value;
        private final int row;
        private final int column;

        public Pointer(int value, int row, int column) {
            this.value = value;
            this.row = row;
            this.column = column;
        }
    }
}
