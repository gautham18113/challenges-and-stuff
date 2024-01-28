package solver.impl.dp.coinchange;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import model.io.ProblemInput;


@Getter
@Setter
@EqualsAndHashCode
@ToString
public class CoinChangeInput implements ProblemInput {
   private int[] coins;
   private int target;
}
