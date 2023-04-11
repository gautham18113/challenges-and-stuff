package problem.output.impl;

import lombok.Getter;
import lombok.Setter;
import problem.output.ProblemOutput;

@Getter
@Setter
public class GridOutput<T> implements ProblemOutput<T[][]> {
    T[][] op;
}
