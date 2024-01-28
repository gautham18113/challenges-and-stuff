package solver.impl.priorityqueue;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import model.io.ProblemInput;

@Setter
@Getter
@EqualsAndHashCode
@ToString
public class HandOfStraightInput implements ProblemInput {
    private int[] hand;
    private int groupSize;
}
