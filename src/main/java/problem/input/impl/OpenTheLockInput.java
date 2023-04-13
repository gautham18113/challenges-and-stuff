package problem.input.impl;

import lombok.Getter;
import lombok.Setter;
import problem.input.ProblemInput;

import java.util.List;

@Getter
@Setter
public class OpenTheLockInput implements ProblemInput {
    private String targetCombo;
    private List<String> trappedCombos;
}
