package solver.impl.graph;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import model.io.ProblemInput;

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
