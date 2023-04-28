import com.google.inject.Guice;
import com.google.inject.Injector;
import module.AppModule;
import solver.Solver;
import solver.impl.TwoSumUnsortedSolver;
import solver.impl.bfs.OpenTheLockSolver;
import solver.impl.bfs.SlidingPuzzleSolver;
import solver.impl.dp.*;
import solver.impl.graph.FindNoOfIslandsSolver;
import solver.impl.graph.FloodFillSolver;
import solver.impl.priorityqueue.KthSmallestInSortedMatrixSolver;
import solver.impl.priorityqueue.MergeKSortedListsSolver;
import solver.impl.priorityqueue.WordLadderSolver;
import solver.impl.toposort.AlienDictionarySolver;
import solver.impl.toposort.CourseScheduleSolver;
import solver.impl.toposort.MinimumTimeTaskSchedulingSolver;
import solver.impl.toposort.ReconstructingSequenceSolver;

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
                injector.getInstance(AlienDictionarySolver.class),
                injector.getInstance(TwoSumUnsortedSolver.class),
                injector.getInstance(KnapsackWeightOnlyTopDownSolver.class),
                injector.getInstance(KnapsackWeightOnlyBottomUpSolver.class),
                injector.getInstance(PartitionTwoEqualSumSubsetsTopDownSolver.class),
                injector.getInstance(TriangleTopDownSolver.class),
                injector.getInstance(TriangleBottomUpSolver.class),
                injector.getInstance(CoinChangeTopDownSolver.class),
                injector.getInstance(CoinChangeBottomUpSolver.class)
        ));
    }

    private static void runSolvers(List<Solver> solvers) {
        for (Solver solver : solvers) {
            solver.solve();
        }
    }
}
