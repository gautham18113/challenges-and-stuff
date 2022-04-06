package solutions.general;

import core.Solution;
import core.io.Input;
import core.io.Output;

import java.util.List;

@SuppressWarnings("unchecked")
public class CaesarCypherEncryptorSolution implements Solution {
    @Override
    public Output<?> solve(Input<?> input) {

        List<Input> inputList= (List<Input>) input.getInput();
        String str = (String) inputList.get(0).getInput();
        int key = (int) inputList.get(1).getInput();

        str = str.toLowerCase();

        char[] chars = str.toCharArray();

        for(int idx = 0; idx < chars.length; idx++) {
            int ascii = chars[idx];

            // normalize key to be within 0 to 26
            int nextAscii = ascii + (key % 26);

            // wrap
            if(nextAscii > 122) nextAscii = (nextAscii % 122) + 96;

            chars[idx] = (char) nextAscii;

        }
        return new Output<>(new String(chars));
    }
}
