import com.google.inject.Guice;
import com.google.inject.Injector;
import module.AppModule;
import solver.impl.FloodFillSolver;

public class Application {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AppModule());
        FloodFillSolver solver = injector.getInstance(FloodFillSolver.class);
        solver.solve();
    }
}
