package problem.compare;

public interface Compare<T> {
    boolean equal(T expected, T actual);
}
