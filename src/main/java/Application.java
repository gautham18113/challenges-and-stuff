import com.google.inject.Guice;
import com.google.inject.Injector;
import module.AppModule;
import solver.Solver;
import solver.impl.*;

import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AppModule());
        runSolvers(Arrays.asList(
                injector.getInstance(FloodFillSolver.class),
                injector.getInstance(FindNoOfIslandsSolver.class),
                injector.getInstance(OpenTheLockSolver.class),
                injector.getInstance(WordLadderSolver.class),
                injector.getInstance(SlidingPuzzleSolver.class),
                injector.getInstance(ReconstructingSequenceSolver.class),
                injector.getInstance(MinimumTimeTaskSchedulingSolver.class),
                injector.getInstance(CourseScheduleSolver.class),
                injector.getInstance(MergeKSortedListsSolver.class),
                injector.getInstance(KthSmallestInSortedMatrixSolver.class),
                injector.getInstance(AlienDictionarySolver.class)
        ));
    }

    private static void runSolvers(List<Solver> solvers) {
        for (Solver solver : solvers) {
            solver.solve();
        }
    }
}
