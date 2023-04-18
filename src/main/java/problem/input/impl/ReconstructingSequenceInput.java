package problem.input.impl;

import lombok.Getter;
import lombok.Setter;
import problem.input.ProblemInput;

@Getter
@Setter
public class ReconstructingSequenceInput implements ProblemInput {
    private Integer[] original;
    private Integer[][] seqs;
}
