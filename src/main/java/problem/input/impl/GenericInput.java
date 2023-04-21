package problem.input.impl;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import problem.input.ProblemInput;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class GenericInput<T> implements ProblemInput {
    T value;
}
