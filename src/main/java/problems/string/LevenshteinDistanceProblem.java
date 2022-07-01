package problems.string;

import core.Problem;
import core.ProblemInterface;
import core.TestCase;

public class LevenshteinDistanceProblem implements ProblemInterface{

    @Override
    public Problem getProblem() {
        return Problem.builder()
        .withTestCase(TestCase.builder()
            .withInput("abc")
            .withInput("yabd")
            .withOutput(2)
            .build())
        .build();
    }

}
