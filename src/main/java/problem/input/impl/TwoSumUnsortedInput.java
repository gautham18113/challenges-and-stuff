package problem.input.impl;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import problem.input.ProblemInput;

import java.util.List;

@Getter
@Setter
@ToString
public class TwoSumUnsortedInput implements ProblemInput {
    private List<Integer> array;
    private Integer target;
}
