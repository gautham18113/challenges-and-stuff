package solver.impl.priorityqueue;

import com.google.common.reflect.TypeToken;
import model.TestCases;
import solver.SolverType;
import parser.Parser;
import problem.compare.Compare;
import problem.input.impl.HandOfStraightInput;
import problem.output.impl.GenericOutput;
import solver.BaseSolver;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.*;

/**
 * https://leetcode.com/problems/hand-of-straights
 * <p>
 * T: O(n log n) S: O(n)
 * n: number of cards in hand
 * g: group size
 */
@SolverType
public class HandOfStraightsSolver extends BaseSolver<HandOfStraightInput, GenericOutput<Boolean>> {
    @Inject
    public HandOfStraightsSolver(
            @Named("jsonParser")
            Parser parser,
            @Named("handOfStraightsProblem")
            String fileName,
            Map<String, Compare> compareMap) {
        super(parser, fileName, compareMap);
    }

    @Override
    protected TestCases<HandOfStraightInput, GenericOutput<Boolean>> getTestCases() {
        return parser.parse(getConfigFile(), new TypeToken<>() {
        });
    }

    @Override
    public GenericOutput<Boolean> solveProblem(HandOfStraightInput input) {
        int[] hand = input.getHand();
        int groupSize = input.getGroupSize();

        GenericOutput<Boolean> output = new GenericOutput<>();

        // If total number of cards cannot be split into group size
        if (hand.length % groupSize != 0) {
            output.setValue(false);
            return output;
        }

        // create a map of card and count: O(n)
        // max heapify card numbers
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        Map<Integer, Integer> cardCounts = new HashMap<>();

        // O(n log n)
        for (int i = 0; i < hand.length; i++) {
            if (!cardCounts.containsKey(hand[i])) {
                cardCounts.put(hand[i], 1);
                heap.offer(hand[i]);
            } else {
                cardCounts.put(hand[i], cardCounts.get(hand[i]) + 1);
            }

        }

        // while heap has cards:
        while (heap.size() > 0) {
            if (heap.size() < groupSize) {
                // it means that there are not enough consecutive
                // cards that can be used to form a group.
                output.setValue(false);
                return output;
            }
            // initialize group array
            List<Integer> group = new ArrayList<>(groupSize);
            // for cards in group size: O(1)
            for (int i = 0; i < groupSize; i++) {
                // O(1)
                int cardInHand = heap.poll();

                if (group.size() > 0 && cardInHand - group.get(group.size() - 1) > 1) {
                    // consecutive group cannot be formed
                    output.setValue(false);
                    return output;
                }
                //  heap pop and store in group array
                group.add(cardInHand);
                //  reduce count of card in card count dictionary
                cardCounts.put(cardInHand, cardCounts.get(cardInHand) - 1);
            }

            // O(g log n - g)
            for (int i = 0; i < groupSize; i++) {
                int cardInGroup = group.get(i);

                // if card count > 0, add to heap
                if (cardCounts.getOrDefault(cardInGroup, 0) > 0) {
                    heap.offer(cardInGroup);
                }
            }

        }
        output.setValue(true);
        return output;
    }
}
