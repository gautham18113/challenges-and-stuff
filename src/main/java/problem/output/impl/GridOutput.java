package problem.output.impl;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import problem.output.ProblemOutput;

import java.util.Arrays;

@Getter
@Setter
@EqualsAndHashCode
public class GridOutput<T> implements ProblemOutput<T[][]> {
    T[][] value;

    @Override
    public String toString() {
        return "GridOutput{" +
                "value=" + Arrays.toString(value) +
                '}';
    }
}
