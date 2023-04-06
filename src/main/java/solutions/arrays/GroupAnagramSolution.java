package solutions.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import core.Solution;
import core.io.Input;
import core.io.Output;

public class GroupAnagramSolution implements Solution {

    @SuppressWarnings("unchecked")
    @Override
    public Output<?> solve(Input<?> input) {
        List<String> words = (List<String>) input.getInput();

        List<List<String>> anagrams = getAnagrams(words);
        return new Output<>(anagrams);
    }

    private List<List<String>> getAnagrams(List<String> words) {

        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String word : words) {
            String orderedWord = sortAlphabetical(word);
            List<String> tmp = anagramMap.getOrDefault(orderedWord, new ArrayList<>());
            tmp.add(word);
            anagramMap.put(orderedWord, tmp);
        }

        return anagramMap.values().stream().collect(Collectors.toList());

    }

    private String sortAlphabetical(String word) {
        char[] wordList = word.toCharArray();
        Arrays.sort(wordList);
        return new String(wordList);
    }

}
