package solutions.string;

import core.Solution;
import core.io.Input;
import core.io.Output;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacterSolution implements Solution {
    @Override
    public Output<?> solve(Input<?> input) {
        String s = (String) input.getInput();

        Map<Character, Integer> characters = new HashMap<>();

        for(Character c: s.toCharArray()) {
            int count = characters.getOrDefault(c, 0);
            characters.put(c, count + 1);
        }

        for(int i=0; i<s.length(); i++) {
            if(characters.get(s.charAt(i))==1) return new Output<>(i);
        }

        return new Output<>(-1);
    }
}
