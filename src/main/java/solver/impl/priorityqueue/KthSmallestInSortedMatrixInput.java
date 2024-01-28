package solver.impl.priorityqueue;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import model.io.ProblemInput;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class KthSmallestInSortedMatrixInput implements ProblemInput {
    private Integer[][] matrix;
    private Integer k;
}
