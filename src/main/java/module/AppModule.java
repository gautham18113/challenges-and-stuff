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

        // Flood fill
        bindProblemModules(
                new TypeLiteral<Parser<TestCases<FloodFillInput, GridOutput>>>() {
                },
                new TypeLiteral<JsonParser<TestCases<FloodFillInput, GridOutput>>>() {
                },
                "floodFillParser",
                "floodFillProblem",
                "FloodFillProblem.json"
        );

        bindProblemModules(
                new TypeLiteral<Parser<TestCases<GenericInput<Integer[][]>, GenericOutput<Integer>>>>() {
                },
                new TypeLiteral<JsonParser<TestCases<GenericInput<Integer[][]>, GenericOutput<Integer>>>>() {
                },
                "noOfIslandParser",
                "noOfIslandProblem",
                "FindNumberOfIslands.json"
        );

        bindProblemModules(
                new TypeLiteral<Parser<TestCases<OpenTheLockInput, GenericOutput<Integer>>>>() {
                },
                new TypeLiteral<JsonParser<TestCases<OpenTheLockInput, GenericOutput<Integer>>>>() {
                },
                "openTheLockParser",
                "openTheLockProblem",
                "OpenTheLock.json"
        );

        bindProblemModules(
                new TypeLiteral<Parser<TestCases<WordLadderInput, GenericOutput<Integer>>>>() {
                },
                new TypeLiteral<JsonParser<TestCases<WordLadderInput, GenericOutput<Integer>>>>() {
                },
                "wordLadderParser",
                "wordLadderProblem",
                "WordLadder.json"
        );
    }

    private void bindProblemModules(TypeLiteral from, TypeLiteral to, String parserName,
                                    String problemName, String problemFileName) {
        bind(from).annotatedWith(Names.named(parserName)).to(to);
        bind(String.class).annotatedWith(Names.named(problemName)).toInstance(problemFileName);
    }

}
