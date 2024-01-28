package solver.input;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import model.io.ProblemInput;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class GenericInput<T> implements ProblemInput {
    T value;
}
