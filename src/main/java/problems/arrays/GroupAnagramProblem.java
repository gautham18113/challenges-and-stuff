package problems.arrays;

import java.util.Arrays;

import core.Problem;
import core.ProblemInterface;
import core.TestCase;

public class GroupAnagramProblem implements ProblemInterface {

    /**
     * <div class="html">
<p>
  Write a function that takes in an array of strings and groups anagrams together.
</p>
<p>
  Anagrams are strings made up of exactly the same letters, where order doesn't
  matter. For example, <span>"cinema"</span> and <span>"iceman"</span> are
  anagrams; similarly, <span>"foo"</span> and <span>"ofo"</span> are anagrams.
</p>
<p>
  Your function should return a list of anagram groups in no particular order.
</p>
<h3>Sample Input</h3>
<pre><span class="CodeEditor-promptParameter">words</span> = ["yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp"]
</pre>
<h3>Sample Output</h3>
<pre>[["yo", "oy"], ["flop", "olfp"], ["act", "tac", "cat"], ["foo"]]
</pre>
</div>
     */
    @Override
    public Problem getProblem() {
        return Problem.builder()
        .withTestCase(
            TestCase.builder()
            .withInput(Arrays.asList("yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp"))
            .withOutput(Arrays.asList(
                Arrays.asList("yo", "oy"),
                Arrays.asList("act", "tac", "cat"),
                Arrays.asList("flop", "olfp"),
                Arrays.asList("foo")
            ))
            .build()
        )
        .build();
    }

}
