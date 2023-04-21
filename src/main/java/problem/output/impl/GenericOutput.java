package problem.output.impl;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import problem.output.ProblemOutput;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class GenericOutput<T> implements ProblemOutput<T> {
    private T value;
}
