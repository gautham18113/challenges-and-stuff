package solver.impl;

import com.google.common.reflect.TypeToken;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import model.TestCases;
import parser.Parser;
import problem.compare.Compare;
import problem.input.impl.GenericInput;
import problem.input.impl.WordLadderInput;
import problem.output.impl.GenericOutput;
import solver.BaseSolver;

import java.util.*;
import java.util.stream.Collectors;

public class WordLadderSolver extends BaseSolver<WordLadderInput, GenericOutput<Integer>> {

    private Parser<TestCases<WordLadderInput, GenericOutput<Integer>>> parser;
    @Inject
    public WordLadderSolver(
            @Named("wordLadderParser")
            Parser<TestCases<WordLadderInput, GenericOutput<Integer>>> parser,
            @Named("wordLadderProblem")
            String fileName,
            Map<String, Compare> map) {
        super(parser, fileName, map);
        this.parser = parser;
    }

    @Override
    public GenericOutput<Integer> solveProblem(WordLadderInput input) {
        GenericOutput<Integer> output = new GenericOutput<>();

        Integer steps = bfs(input.getFrom(), input.getTo(), input.getWordList());

        output.setValue(steps);

        return output;
    }

    private Integer bfs(String from, String to, List<String> wordLadder) {

        Deque<String> queue = new ArrayDeque<>();
        queue.add(from);
        Set<String> visited = new HashSet<>();

        int level = 0;

        while(queue.size()>0) {

            int queueSize = queue.size();

            for(int queueIdx = 0; queueIdx < queueSize; queueIdx++) {

                String word = queue.pop();

                if(word.equals(to)) {
                    return level;
                }

                for(int idx = 0; idx < from.length(); idx++) {
                    for(String neighbor: getNeighbors(String.valueOf(word.charAt(idx)))) {

                        String newWord = substitute(word, idx, neighbor);

                        if (visited.contains(newWord)) {
                            continue;
                        }

                        visited.add(newWord);

                        int finalIdx = idx;
                        List<Boolean> wordAtIndexInDictionary = wordLadder
                                .stream()
                                .map(s -> substringEquals(s, newWord, 0, finalIdx))
                                .filter(b -> b)
                                .collect(Collectors.toList());

                        if (wordAtIndexInDictionary.size() > 0) {
                            queue.add(newWord);
                        }
                    }
                }
            }

            level++;
        }

        return -1;
    }

    private String substitute(String word, int idx, String replacement) {
        List<String> newWordList =  Arrays.asList(word.split(""));
        newWordList.set(idx, replacement);
        return newWordList.stream().collect(Collectors.joining());
    }

    private boolean substringEquals(String compareFrom, String compareTo, int idxFrom, int idxTo) {
        String compareFromSubstring = compareFrom.substring(idxFrom, idxTo + 1);
        String compareToSubstring = compareTo.substring(idxFrom, idxTo + 1);
        return compareFromSubstring.equals(compareToSubstring);
    }

    private List<String> getNeighbors(String c) {
        List<String> neighbors = new ArrayList<>();

        // ASCII of a = 97, z = 122
        for(int i=97; i<=122; i++) {
            if(String.valueOf((char) i).equals(c)) {
                continue;
            }
            neighbors.add(String.valueOf((char) i));
        }
        return neighbors;
    }

    @Override
    protected TestCases<WordLadderInput, GenericOutput<Integer>> getTestCases() {
        return parser.parse(getConfigFile(), new TypeToken<>() {});
    }
}
