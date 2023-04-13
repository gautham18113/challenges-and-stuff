package problem.output.impl;

import lombok.Getter;
import lombok.Setter;
import problem.output.ProblemOutput;

@Getter
@Setter
public class GenericOutput<T> implements ProblemOutput<T> {
    private T value;
}
