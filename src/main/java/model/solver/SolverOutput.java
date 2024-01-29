package model.solver;

import lombok.*;
import model.testcase.TestCase;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@Builder
@AllArgsConstructor
public class SolverOutput<I, O> {

    private List<TestCase<I, O>> failedTestCases;
    private List<TestCase<I, O>> passedTestCases;

}
