package problem.input.impl;

import lombok.Getter;
import lombok.Setter;
import problem.input.ProblemInput;

@Getter
@Setter
public class FloodFillInput implements ProblemInput {
    private int r;
    private int c;
    private int replacement;
    private Integer[][] image;
}
