package problem.input.impl;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import problem.input.ProblemInput;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class MinimumTimeTaskSchedulingInput implements ProblemInput {
    List<String> tasks;
    List<Integer> times;
    String[][] requirements;
}
