package model.testcase;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import solver.input.GenericInput;
import solver.output.GenericOutput;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class TestCase<I, O> {

    private I input;
    private O output;
}
