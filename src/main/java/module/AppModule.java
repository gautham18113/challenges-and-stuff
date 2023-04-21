package module;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.multibindings.MapBinder;
import com.google.inject.name.Names;
import constants.AppConstants;
import parser.impl.JsonParser;
import parser.Parser;
import problem.compare.Compare;
import problem.compare.impl.ArrayDeepCompare;


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
        bindProblemModules(
                "minimumTimeTaskSchedulingProblem",
                "MinimumTimeTaskScheduling.json"
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
