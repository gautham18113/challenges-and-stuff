package solver;

public interface Solver<I, O> {
    SolverOutput solve();

    O solveProblem(I input);

}
