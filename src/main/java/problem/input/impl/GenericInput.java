package problem.input.impl;

import lombok.Getter;
import lombok.Setter;
import problem.input.ProblemInput;

@Getter
@Setter
public class GenericInput<T> implements ProblemInput {
    T value;
}
