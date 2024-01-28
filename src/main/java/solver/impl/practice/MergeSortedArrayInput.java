package solver.impl.practice;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import model.io.ProblemInput;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class MergeSortedArrayInput implements ProblemInput {
    private int m;
    private int n;
    private int[] nums1;
    private int[] nums2;
}
