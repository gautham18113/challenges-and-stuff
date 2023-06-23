package problem.input.impl;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import problem.input.ProblemInput;

@Setter
@Getter
@EqualsAndHashCode
@ToString
public class HandOfStraightInput implements ProblemInput {
    private int[] hand;
    private int groupSize;
}
