package solutions.arrays;

import core.io.Input;
import core.io.Output;
import core.Solution;

import java.util.Collections;
import java.util.List;

public class MinimumWaitingTimeSolution implements Solution {

    /**
     *
     * @param input
     * We store waiting time so far in a variable and cumulative
     * waiting time in another variable.
     *
     * so, new waiting time = previous query waiting time + previous query duration
     * new cumulative waiting time = previous cumulative waiting time + new waiting time
     *
     * This can also be done using another method
     *
     * Since we know that the current query duration will add to the waiting time of any other queries executed after it,
     *
     * for each query:
     *      total waiting time = total waiting time + (length of remaining queries * duration of current query)
     *
     * @return Output
     */
    @Override
    public Output<?> solve(Input<?> input) {
        List<Integer> queries = (List<Integer>) input.getInput();
        Collections.sort(queries);

        int waitingTime = 0;
        int cumulativeDuration = 0;

        for(int i=1; i < queries.size(); i++) {
            waitingTime += queries.get(i - 1);
            cumulativeDuration += waitingTime;
        }
        return new Output<>(cumulativeDuration);
    }
}
