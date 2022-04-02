package solutions.string;

import core.io.Input;
import core.io.Output;
import core.Solution;

import java.util.Arrays;

public class LongestPalindromeDpSolution implements Solution {
    /**
     *
     * <p>
     * This problem can be solved using tabular dynamic programming.
     * The following elements of dynamic programming exist in the problem:
     * </p>
     *
     * <p>
     * <b>Optimal Substructure</b>: Optimal solution to the problem lies within optimal solutions to sub problems.
     * </p>
     * <ul>
     * <li> You show that solution to the problem consists of making a choice, such as whether the current character
     * is part of the palindrome or not. </li>
     * <li> You suppose that for a given problem, you are given a choice that leads to an optimal solution.</li>
     * <li> Given this choice, you determine which sub problems are created and how to best characterize the resulting space of sub problems </li>
     * <li>You show that the solutions to sub problems in an optimal solution must themselves be optimal.</li>
     * </ul>
     * <p>
     * In the longest palindrome problem, the optimal substructure is to join certain characters in the string such that we maximize
     * the length and that the sequence of characters is a palindrome.
     * </p>
     * <p>
     * In other words, we need to find Sij such that Sij is a palindrome and len(Sij) is the maximum possible.
     * At every step, there is a choice that we make, either the new character is a part of the longest palindrome or it is not.
     * </p>
     * <p>Let {@code p[i][j]} be a table that holds if a <em>Sij </em> is palindrome or not. Then our sub problem is that
     * <em>Sij </em> is a palindrome if
     * <b>{@code p[i+1][j-1]} is palindrome and Si == Sj</b></p>
     *
     * <p>We will keep track of a global string which will be the longest palindrome.</p>
     *
     * @param input {@link Input} wrapper containing a String
     * @return Output
     *
     */
    @Override
    public Output<?> solve(Input<?> input) {

        String s = (String) input.getInput();

        if(s.equals("")) return new Output<>("");

        Boolean[][] resultMatrix = new Boolean[s.length()][s.length()];

        for(Boolean[] arr: resultMatrix) Arrays.fill(arr, null);

        resultMatrix[0][0] = true;

        String palindrome = "";

        for(int subStrSize=0; subStrSize < s.length(); subStrSize++) {
            for(int i=0, j=subStrSize; j<s.length(); i++, j++) {
               if (subStrSize==0) {
                   resultMatrix[i][j] = true;
               }
               else if (subStrSize == 1) {
                   resultMatrix[i][j] = isPalindrome(s.substring(i, j+1));
               }
               else {
                   resultMatrix[i][j] = resultMatrix[i+1][j-1] && s.charAt(i)==s.charAt(j);
               }

               if(resultMatrix[i][j]) {
                   palindrome = s.substring(i, j+1);
               }
            }
        }

        return new Output<>(palindrome);

    }

    private boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        return sb.reverse().toString().equals(s);
    }
}
