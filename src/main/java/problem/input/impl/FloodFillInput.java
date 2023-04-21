package problem.input.impl;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import problem.input.ProblemInput;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class FloodFillInput implements ProblemInput {
    private int r;
    private int c;
    private int replacement;
    private Integer[][] image;
}
