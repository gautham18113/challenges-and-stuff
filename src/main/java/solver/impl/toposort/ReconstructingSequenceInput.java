package solver.impl.toposort;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import model.io.ProblemInput;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ReconstructingSequenceInput implements ProblemInput {
    private Integer[] original;
    private Integer[][] seqs;
}
