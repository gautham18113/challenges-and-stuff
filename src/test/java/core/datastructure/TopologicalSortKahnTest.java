package core.datastructure;

import core.algorithm.TopologicalSortKahn;
import org.junit.jupiter.api.Test;

import java.util.*;

public class TopologicalSortKahnTest {

    @Test
    public void testHappyCase() {
        TopologicalSortKahn<Integer> classUnderTest = new TopologicalSortKahn<>(
                buildHappyCaseGraph());

        List<Integer> actual = classUnderTest.sort();
        Map<Integer, List<Integer>> levelMap = new HashMap<>() {{
            put(1, Arrays.asList(4, 5, 6));
            put(2, Arrays.asList(2, 3));
            put(3, List.of(1));
        }};

        assert (compareSortResultToLevelMap(levelMap, actual));
    }

    @Test
    public void test2() {
        Map<Integer, List<Integer>> testGraph = new HashMap<>(){{
            put(4, List.of(2));
            put(5, List.of(2));
            put(6, List.of(3));
            put(2, List.of(1));
            put(3, List.of(1));
            put(3, List.of(2));
            put(1, Collections.emptyList());
        }};
        TopologicalSortKahn<Integer> classUnderTest = new TopologicalSortKahn<>(
                testGraph);
        Map<Integer, List<Integer>> levelMap = new HashMap<>() {{
            put(1, Arrays.asList(4, 5, 6));
            put(2, Arrays.asList(3));
            put(3, Arrays.asList(2));
            put(4, List.of(1));
        }};

        List<Integer> actual = classUnderTest.sort();

        assert (compareSortResultToLevelMap(levelMap, actual));
    }

    @Test
    public void test3() {
        Map<Integer, List<Integer>> testGraph = new HashMap<>(){{
            put(4, List.of(2));
            put(5, List.of(2));
            put(6, List.of(3));
            put(2, List.of(3));
            put(3, List.of(2));
            put(1, List.of(2));
        }};
        TopologicalSortKahn<Integer> classUnderTest = new TopologicalSortKahn<>(
                testGraph);

        assert(Objects.isNull(classUnderTest.sort()));
    }

    private Map<Integer, List<Integer>> buildHappyCaseGraph() {
        return new HashMap<>() {{
            put(4, List.of(2));
            put(5, List.of(2));
            put(6, List.of(3));
            put(2, List.of(1));
            put(3, List.of(1));
            put(1, Collections.emptyList());
        }};
    }

    private boolean compareSortResultToLevelMap(Map<Integer, List<Integer>> levelMap,
                                                List<Integer> topoSortedResult) {

        int subListIdx = 0;

        int currLevel = 1;

        while (subListIdx < topoSortedResult.size()) {

            int startIdx = subListIdx;

            int endIdx = subListIdx + levelMap.get(currLevel).size();

            List<Integer> sublist = topoSortedResult.subList(startIdx, endIdx);

            if (!levelMap.get(currLevel).containsAll(sublist) &&
                    sublist.size() == levelMap.get(currLevel).size()) {
                return false;
            }

            subListIdx = endIdx;
            currLevel++;

        }

        return true;

    }


}
