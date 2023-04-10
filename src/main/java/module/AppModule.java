package module;

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
import problem.output.FloodFillOutput;

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

        bind(new TypeLiteral<Parser<TestCases<FloodFillInput, FloodFillOutput>>>(){})
                .annotatedWith(Names.named("floodFillParser"))
                .to(new TypeLiteral<JsonParser<TestCases<FloodFillInput, FloodFillOutput>>>(){});
        bind(String.class)
                .annotatedWith(Names.named("floodFillProblem"))
                .toInstance("FloodFillProblem.json");
    }

}
