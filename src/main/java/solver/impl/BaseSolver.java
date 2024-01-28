package solver.impl;

import model.testcase.TestCases;
import parser.Parser;
import compare.Compare;
import model.io.ProblemInput;
import problem.output.ProblemOutput;

import java.util.Map;
import java.util.Objects;

public abstract class BaseSolver<I extends ProblemInput, O extends ProblemOutput>
        extends AbstractSolver<I, O>{

    protected Parser<TestCases<I, O>> parser;
    private String fileName;
    private Map<String, Compare> compareMap;

    public BaseSolver(
            Parser<TestCases<I, O>> parser,
            String fileName,
            Map<String, Compare> compareMap){
        assert(Objects.nonNull(parser));
        this.parser = parser;
        this.fileName = fileName;
        this.compareMap = compareMap;
    }
    protected Parser getParser() {
        return this.parser;
    }

    protected String getConfigFile() {
        return this.fileName;
    }

    protected Map<String, Compare> getCompareMap() {
        return this.compareMap;
    }

    // This needs to be overridden by the child class
    // to infer the correct type to be rendered.
    protected abstract TestCases<I, O> getTestCases();

    public abstract O solveProblem(I input);
}
