package solver.output;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import problem.output.ProblemOutput;

import java.util.Arrays;

@Getter
@Setter
@EqualsAndHashCode
public class GenericOutput<T> extends Object implements ProblemOutput<T>{
    private T value;

    @Override
    public String toString() {
        String result;
        if (value instanceof int[]) {
            result = Arrays.toString((int[]) value);
        }
        else {
            result = value.toString();
        }
        return "GenericOutput{" +
                "value=" + result +
                '}';
    }
}
