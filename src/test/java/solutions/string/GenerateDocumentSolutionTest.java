package solutions.string;

import common.TestUtil;
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