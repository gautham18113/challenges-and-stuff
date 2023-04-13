package problem.input.impl;

import lombok.Getter;
import lombok.Setter;
import problem.input.ProblemInput;

import java.util.List;

@Getter
@Setter
public class WordLadderInput implements ProblemInput {
    private String from;
    private String to;
    private List<String> wordList;
}
