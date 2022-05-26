package solutions.string;

import core.Solution;
import core.io.Input;
import core.io.Output;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateDocumentSolution implements Solution {

    /**
     * <p>
     *     We will store all available characters and their counts in a hashmap.
     *     Then we will iterate through the document to check if a character is available.
     *     If it is available (count > 0), then we decrement the available count for that character
     *     and proceed with the next character in the document.
     *     If the character is not available (count <=0) then we return false.
     * </p>
     * @param input List<Input> contains two Strings, one for characters and one for document
     * @return boolean
     */
    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public Output<?> solve(Input<?> input) {
        List<Input> params = (List<Input>) input.getInput();

        String characters = (String) params.get(0).getInput();
        String document = (String) params.get(1).getInput();

        Map<Character, Integer> availableChars = new HashMap<>();

        for(Character c: characters.toCharArray()) {
            if(availableChars.containsKey(c)) availableChars.put(c, availableChars.get(c)+1);
            else availableChars.put(c, 1);
        }

        for(Character c: document.toCharArray()){
            int availableCount = availableChars.getOrDefault(c, 0);
            if(availableCount<=0) return new Output<>(false);
            else availableChars.put(c, availableCount - 1);
        }
        return new Output<>(true);
    }
}
