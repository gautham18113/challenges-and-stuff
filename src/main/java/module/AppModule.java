package module;

import com.google.common.reflect.TypeToken;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.multibindings.MapBinder;
import com.google.inject.name.Names;
import constants.AppConstants;
import parser.Parser;
import parser.impl.JsonParser;
import compare.Compare;
import compare.impl.ArrayCompareNonPositional;
import compare.impl.ArrayComparePositional;
import compare.impl.ArrayDeepCompare;

import java.lang.reflect.Type;
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
        compareMapBinder.addBinding(AppConstants.CompareEnum.ARRAY_POSITIONAL_COMPARE.toString())
                .toInstance(new ArrayComparePositional());
        compareMapBinder.addBinding(
                        AppConstants.CompareEnum.ARRAY_NON_POSITIONAL_COMPARE.toString())
                .toInstance(new ArrayCompareNonPositional());
    }

    private void configureProblems() {
        Type typeToken = new TypeToken<Map<String, String>>() { }.getType();
        final Map<String, String> problems =
                (Map<String, String>) new JsonParser<>().parse("problems/problemList.json", typeToken);

        problems.entrySet()
                .forEach((entry) -> bindProblemModules(entry.getKey(), entry.getValue()));
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
