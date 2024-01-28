package solver.impl.practice;

import com.google.common.reflect.TypeToken;
import model.testcase.TestCases;
import parser.Parser;
import compare.Compare;
import solver.output.GenericOutput;
import solver.impl.BaseSolver;
import model.solver.SolverType;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;

@SolverType
public class MergeSortedArraySolver extends BaseSolver<MergeSortedArrayInput, GenericOutput<int[]>> {
    @Inject
    public MergeSortedArraySolver(
            @Named("jsonParser")
            Parser parser,
            @Named("mergeSortedArrayProblem")
            String fileName,
            Map<String, Compare> compareMap) {
        super(parser, fileName, compareMap);
    }

    @Override
    protected TestCases<MergeSortedArrayInput, GenericOutput<int[]>> getTestCases() {
        return parser.parse(getConfigFile(), new TypeToken<>() {
        });
    }

    @Override
    public GenericOutput<int[]> solveProblem(MergeSortedArrayInput input) {
        int m = input.getM();
        int n = input.getN();
        int[] nums1 = input.getNums1();
        int[] nums2 = input.getNums2();
        int[] result = new int[m + n];

        int i=0;
        int j=0;

        int k=0;

        while (i < m && j < n) {
            if (nums1[i] > nums2[j]) {
                result[k] = nums2[j];
                k++; j++;
            } else if(nums1[i] < nums2[j]) {
                result[k] = nums1[i];
                k++; i++;
            } else {
                result[k] = nums1[i];
                k++; i++;
                result[k] = nums2[j];
                k++; j++;
            }
        }

        while (i < m) {
            result[k] = nums1[i];
            k++; i++;
        }

        while (j < n) {
            result[k] = nums2[j];
            k++; j++;
        }

        for (k = 0;k < m + n; k++) {
            nums1[k] = result[k];
        }

        GenericOutput<int[]> op = new GenericOutput<>();
        op.setValue(nums1);

        return op;
    }

}
