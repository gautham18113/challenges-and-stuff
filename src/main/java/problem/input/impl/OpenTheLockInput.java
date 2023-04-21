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
public class OpenTheLockInput implements ProblemInput {
    private String targetCombo;
    private List<String> trappedCombos;
}
