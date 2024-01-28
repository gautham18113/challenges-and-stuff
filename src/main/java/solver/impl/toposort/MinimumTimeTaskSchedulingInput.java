package solver.impl.toposort;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import model.io.ProblemInput;

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
