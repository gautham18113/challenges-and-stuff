package problems.string;

import java.util.HashMap;

public class ZigZagConversion {
    /**
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want
     * to display this pattern in a fixed font for better legibility)
     *
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     *
     * And then read line by line: "PAHNAPLSIIGYIR"
     *
     * Write the code that will take a string and make this conversion given a number of rows:
     * string convert(string s, int numRows);
     *
     */
    public ZigZagConversion() {
        HashMap<HashMap<String, Integer>, String> tests = new HashMap<>();

        HashMap<String, Integer> input1 = new HashMap<>();
        input1.put("PAYPALISHIRING", 3);
        tests.put(input1, "PAHNAPLSIIGYIR");

        HashMap<String, Integer> input2 = new HashMap<>();
        input2.put("PAYPALISHIRING", 4);
        tests.put(input2, "PINALSIGYAHRPI");


    }

}
