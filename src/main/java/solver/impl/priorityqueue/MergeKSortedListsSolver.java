package solver.impl.priorityqueue;

import com.google.common.reflect.TypeToken;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import core.datastructure.LL;
import model.TestCases;
import parser.Parser;
import problem.compare.Compare;
import problem.input.impl.GenericInput;
import problem.output.impl.GenericOutput;
import solver.BaseSolver;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists
 */
public class MergeKSortedListsSolver
        extends BaseSolver<GenericInput<List<List<Integer>>>, GenericOutput<List<Integer>>> {

    @Inject
    public MergeKSortedListsSolver(
            @Named("jsonParser")
            Parser parser,
            @Named("mergeKSortedListsProblem")
            String fileName,
            Map<String, Compare> compareMap) {
        super(parser, fileName, compareMap);
    }

    @Override
    public TestCases getTestCases() {
        return parser.parse(getConfigFile(), new TypeToken<>() {
        });
    }

    @Override
    public GenericOutput<List<Integer>> solveProblem(GenericInput<List<List<Integer>>> input) {

        List<List<Integer>> sortedLists = input.getValue();

        // Since the sub lists are all sorted, the smallest number among the first
        // index element in all the lists would be the smallest number in the consolidated list.
        // Similarly, for the second number, the smallest among the second index elements from all
        // the lists and smallest among remaining first index numbers will be the second smallest.
        // And so on for third, fourth, etc.

        // Convert to linked list to traverse the k lists head by head
        List<LL<Integer>> listOfLinkedList = sortedLists.stream().map(LL::new).collect(Collectors.toList());

        List<Integer> consolidatedList = new ArrayList<>();
        PriorityQueue<LL<Integer>> heap = new PriorityQueue<>(Comparator.comparingInt(e -> e.value));

        for(int idx = 0; idx < listOfLinkedList.size(); idx++) {
            if(Objects.nonNull(listOfLinkedList.get(idx))) {
                heap.add(listOfLinkedList.get(idx));
            }
        }

        while(!heap.isEmpty()) {
            LL<Integer> head = heap.poll();
            consolidatedList.add(head.value);

            if(Objects.nonNull(head.next)) {
                // O(Nlog(k)) since log(k) is time to insert to heap, where k is the number
                // of sub-lists
                heap.add(head.next);
            }
        }

        GenericOutput<List<Integer>> output = new GenericOutput<>();
        output.setValue(consolidatedList);
        return output;
    }
}
