package solver.impl.practice;

import com.google.gson.reflect.TypeToken;
import model.testcase.TestCases;
import compare.Compare;
import solver.impl.AbstractSolver;
import model.solver.SolverType;
import solver.output.GenericOutput;

import javax.inject.Inject;
import javax.inject.Named;
import java.lang.reflect.Type;

import java.util.Map;

@SolverType
public class MergeSortedArraySolver extends AbstractSolver {

    @Inject
    public MergeSortedArraySolver(
            @Named("mergeSortedArrayProblem")
            String fileName,
            Map<String, Compare> compareMap) {
        super(fileName, compareMap);
    }


    @Override
    public Object solve(Object input) {
        MergeSortedArrayInput problemInput = (MergeSortedArrayInput) input;
        int m = problemInput.getM();
        int n = problemInput.getN();
        int[] nums1 = problemInput.getNums1();
        int[] nums2 = problemInput.getNums2();
        int[] result = new int[m + n];

        int i = 0;
        int j = 0;

        int k = 0;

        while (i < m && j < n) {
            if (nums1[i] > nums2[j]) {
                result[k] = nums2[j];
                k++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                result[k] = nums1[i];
                k++;
                i++;
            } else {
                result[k] = nums1[i];
                k++;
                i++;
                result[k] = nums2[j];
                k++;
                j++;
            }
        }

        while (i < m) {
            result[k] = nums1[i];
            k++;
            i++;
        }

        while (j < n) {
            result[k] = nums2[j];
            k++;
            j++;
        }

        for (k = 0; k < m + n; k++) {
            nums1[k] = result[k];
        }

        GenericOutput<int[]> op = new GenericOutput<>();
        op.setValue(nums1);

        return op;
    }

    @Override
    protected Type getType() {
        return new TypeToken<TestCases<MergeSortedArrayInput, GenericOutput<int[]>>>() {
        }.getType();
    }

}
