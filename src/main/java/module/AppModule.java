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

import java.util.HashMap;
import java.util.Map;


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
        final Map<String, String> problemNameMap = new HashMap<>() {{
            put("floodFillProblem", "FloodFillProblem.json");
            put("noOfIslandProblem", "FindNumberOfIslands.json");
            put("openTheLockProblem", "OpenTheLock.json");
            put("wordLadderProblem", "WordLadder.json");
            put("slidingPuzzleProblem", "SlidingPuzzle.json");
            put("reconstructingSequenceProblem", "ReconstructingSequence.json");
            put("minimumTimeTaskSchedulingProblem", "MinimumTimeTaskScheduling.json");
            put("courseScheduleProblem", "CourseSchedule.json");
            put("mergeKSortedListsProblem", "MergeKSortedLists.json");
            put("kthSmallestInSortedMatrixProblem", "KthSmallestInSortedMatrix.json");
            put("alienDictionaryProblem","AlienDictionary.json");
        }};

        problemNameMap.entrySet()
                .forEach((entry) -> bindProblemModules(entry.getKey(), entry.getValue()));
    }

    private void bindProblemModules(String problemName, String problemFileName) {
        bind(new TypeLiteral<Parser>() {
        })
                .annotatedWith(Names.named("jsonParser"))
                .to(new TypeLiteral<JsonParser>() {});
        bind(String.class).annotatedWith(Names.named(problemName)).toInstance(problemFileName);
    }

}
