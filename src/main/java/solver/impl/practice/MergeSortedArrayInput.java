package solver.impl.practice;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import model.io.ProblemInput;
import solver.input.GenericInput;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class MergeSortedArrayInput extends GenericInput {
    private int m;
    private int n;
    private int[] nums1;
    private int[] nums2;
}
