package core;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import core.datastructure.Node;

public abstract class AbstractProblem implements ProblemInterface {

    public abstract Problem getProblem();

    protected <T> Node<T> buildTree(Iterator<String> iter, Function<String, T> f) {
        String val = iter.next();
        if (val.equals("x")) return null;
        Node<T> left = buildTree(iter, f);
        Node<T> right = buildTree(iter, f);
        return new Node<T>(f.apply(val), left, right);
    }

    protected List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }
}
