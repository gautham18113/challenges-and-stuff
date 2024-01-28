package solver.impl.bfs;

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
public class OpenTheLockInput implements ProblemInput {
    private String targetCombo;
    private List<String> trappedCombos;
}
