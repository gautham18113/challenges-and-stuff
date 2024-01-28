package solver;

import model.solver.SolverOutput;

public interface Solver<I, O> {
    SolverOutput solve();

    O solveProblem(I input);

}
