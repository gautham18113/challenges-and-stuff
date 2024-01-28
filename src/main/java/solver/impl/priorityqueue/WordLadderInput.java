package solver.impl.priorityqueue;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import model.io.ProblemInput;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class WordLadderInput implements ProblemInput {
    private String from;
    private String to;
    private List<String> wordList;
}
