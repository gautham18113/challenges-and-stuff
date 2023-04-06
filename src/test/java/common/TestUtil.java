package common;

import core.ProblemInterface;
import core.Solution;
import core.TestCase;
import core.datastructure.BST;
import core.io.Input;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.assertj.core.api.Assertions;

public class TestUtil {

    @SuppressWarnings("all")
    public static void runAssertions(ProblemInterface problem, Solution solution) {
        for (TestCase test : problem.getProblem().getTestCases()) {
            Input input = test.getInputs().get(0);

            Object actual = solution.solve(input).getOutput();
            Object expected = test.getOutput().getOutput();

            if (actual instanceof BST && expected instanceof BST) {
                Assertions.assertThat(actual.equals(expected));
            } else if (actual instanceof List && expected instanceof  List) {
                assert(((List<?>) actual).containsAll((List<?>) expected));
            } else {
                Assertions.assertThat(actual).isEqualTo(expected);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static void runAssertionsWithComparator(ProblemInterface problem, Solution solution, Comparator comparator) {
        for (TestCase test : problem.getProblem().getTestCases()) {
            Input input = test.getInputs().get(0);

            Object actual = solution.solve(input).getOutput();
            Object expected = test.getOutput().getOutput();

            if (actual instanceof List) {
                Collections.sort((List) actual, new ListComparator<>());
                Collections.sort((List) expected, new ListComparator<>());
            }

            Assertions.assertThat(actual).isEqualTo(expected);

        }
    }

    public static void runAssertionsMultipleParams(ProblemInterface problem, Solution solution) {
        for (TestCase test : problem.getProblem().getTestCases()) {
            Assertions.assertThat(solution.solve(new Input<>(test.getInputs())).getOutput())
                    .isEqualTo(test.getOutput().getOutput());
        }
    }
}
