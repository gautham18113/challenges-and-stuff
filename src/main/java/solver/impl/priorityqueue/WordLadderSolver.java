package solver.impl.priorityqueue;

import com.google.common.reflect.TypeToken;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import model.testcase.TestCases;
import model.solver.SolverType;
import parser.Parser;
import compare.Compare;
import solver.output.GenericOutput;
import solver.impl.BaseSolver;

import java.util.*;
import java.util.stream.Collectors;

@SolverType
public class WordLadderSolver extends BaseSolver<WordLadderInput, GenericOutput<Integer>> {

    private Parser<TestCases<WordLadderInput, GenericOutput<Integer>>> parser;
    @Inject
    public WordLadderSolver(
            @Named("jsonParser")
            Parser parser,
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
        Set<String> uniqueLetters = wordLadder.stream()
                .map(e -> Arrays.stream(e.split("")).collect(Collectors.toList()))
                .flatMap(List::stream)
                .map(String::valueOf)
                .collect(Collectors.toSet());

        int level = 0;

        while(queue.size()>0) {

            int queueSize = queue.size();

            for(int queueIdx = 0; queueIdx < queueSize; queueIdx++) {
                String word = queue.pop();

                for(int idx = 0; idx < from.length(); idx++) {

                    if(word.equals(to)) {
                        return level;
                    }

                    for(String neighbor: getNeighbors(String.valueOf(word.charAt(idx)), uniqueLetters)) {

                        String newWord = substitute(word, idx, neighbor);

                        if (visited.contains(newWord)) {
                            continue;
                        }

                        visited.add(newWord);

                        if (wordLadder.contains(newWord)) {
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

    private List<String> getNeighbors(String c, Set<String> letters) {
        List<String> neighbors = new ArrayList<>();
        for(String letter: letters) {
            if(letter.equals(c)) {
                continue;
            }
            neighbors.add(letter);
        }
        return neighbors;
    }

    @Override
    protected TestCases<WordLadderInput, GenericOutput<Integer>> getTestCases() {
        return parser.parse(getConfigFile(), new TypeToken<>() {});
    }
}
