package problem.input.impl;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import problem.input.ProblemInput;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class CourseScheduleInput implements ProblemInput {
    private int n;
    private Integer[][] prerequisites;
}
