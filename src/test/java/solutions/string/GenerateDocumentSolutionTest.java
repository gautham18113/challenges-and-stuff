package solutions.string;

import common.TestUtil;
import core.io.Input;
import core.io.Output;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import problems.string.GenerateDocumentProblem;

class GenerateDocumentSolutionTest {
    GenerateDocumentSolution generateDocumentSolution = new GenerateDocumentSolution();
    GenerateDocumentProblem generateDocumentProblem = new GenerateDocumentProblem();

    @Test
    void testSolve() {
        TestUtil.runAssertionsMultipleParams(generateDocumentProblem, generateDocumentSolution);
    }
}