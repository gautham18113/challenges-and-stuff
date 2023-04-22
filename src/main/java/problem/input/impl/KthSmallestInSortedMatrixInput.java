package problem.input.impl;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import problem.input.ProblemInput;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class KthSmallestInSortedMatrixInput implements ProblemInput {
    private Integer[][] matrix;
    private Integer k;
}
