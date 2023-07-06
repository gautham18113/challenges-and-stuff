import com.google.inject.Guice;
import com.google.inject.Injector;
import module.AppModule;
import module.SolverType;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import solver.Solver;

import java.util.*;

public class Application {

    public static void main(String[] args) throws ClassNotFoundException {
        Injector injector = Guice.createInjector(new AppModule());
        ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
        provider.addIncludeFilter(new AnnotationTypeFilter(SolverType.class));
        Set<BeanDefinition> beanDefs = provider
                .findCandidateComponents("solver.impl");
        for (BeanDefinition bd : beanDefs) {
            if (bd instanceof AnnotatedBeanDefinition) {
                String clazzName= bd.getBeanClassName();
                Solver obj = (Solver) injector.getInstance(ClassLoader.getSystemClassLoader().loadClass(clazzName));
                obj.solve();
            }
        }
    }
}
