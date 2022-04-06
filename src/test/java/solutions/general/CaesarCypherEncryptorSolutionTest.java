package solutions.general;

import common.TestUtil;
import core.io.Input;
import core.io.Output;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import problems.general.CaesarCypherEncryptorProblem;

class CaesarCypherEncryptorSolutionTest {
    private final CaesarCypherEncryptorSolution caesarCypherEncryptorSolution = new CaesarCypherEncryptorSolution();
    private final CaesarCypherEncryptorProblem caesarCypherEncryptorProblem = new CaesarCypherEncryptorProblem();

    @Test
    void testSolve() {
        TestUtil.runAssertionsMultipleParams(
            caesarCypherEncryptorProblem,
            caesarCypherEncryptorSolution
        );
    }
}