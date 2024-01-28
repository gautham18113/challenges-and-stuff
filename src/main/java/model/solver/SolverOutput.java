package model.solver;

import lombok.*;
import model.testcase.TestCase;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@Builder
@AllArgsConstructor
public class SolverOutput {

    private List<TestCase> failedTestCases;
    private List<TestCase> passedTestCases;

}
