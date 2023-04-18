package module;

import com.google.gson.reflect.TypeToken;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.multibindings.MapBinder;
import com.google.inject.name.Names;
import constants.AppConstants;
import model.TestCases;
import parser.impl.JsonParser;
import parser.Parser;
import problem.compare.Compare;
import problem.compare.impl.ArrayDeepCompare;
import problem.input.impl.FloodFillInput;
import problem.input.impl.GenericInput;
import problem.input.impl.OpenTheLockInput;
import problem.input.impl.WordLadderInput;
import problem.output.impl.GenericOutput;
import problem.output.impl.GridOutput;
import solver.impl.FloodFillSolver;

public class AppModule extends AbstractModule {
    @Override
    protected void configure() {

        configureProblems();
        configureComparatorModule();
    }

    private void configureComparatorModule() {
        MapBinder<String, Compare> compareMapBinder = MapBinder.newMapBinder(
                binder(), String.class, Compare.class);

        compareMapBinder.addBinding(AppConstants.CompareEnum.ARRAY_DEEP_COMPARE.toString())
                .toInstance(new ArrayDeepCompare());
    }

    private void configureProblems() {
        bindProblemModules(
                "floodFillProblem",
                "FloodFillProblem.json"
        );
        bindProblemModules(
                "noOfIslandProblem",
                "FindNumberOfIslands.json"
        );
        bindProblemModules(
                "openTheLockProblem",
                "OpenTheLock.json"
        );
        bindProblemModules(
                "wordLadderProblem",
                "WordLadder.json"
        );
        bindProblemModules(
                "wordLadderProblem",
                "WordLadder.json"
        );
        bindProblemModules(
                "slidingPuzzleProblem",
                "SlidingPuzzle.json"
        );
        bindProblemModules(
                "reconstructingSequenceProblem",
                "ReconstructingSequence.json"
        );
    }

    private void bindProblemModules(String problemName, String problemFileName) {
        bind(new TypeLiteral<Parser>() {
        })
                .annotatedWith(Names.named("jsonParser"))
                .to(new TypeLiteral<JsonParser>() {
                });
        bind(String.class).annotatedWith(Names.named(problemName)).toInstance(problemFileName);
    }

}
