package solutions.graphs;

import java.util.List;
import java.util.Objects;

import core.Solution;
import core.io.Input;
import core.io.Output;
import static problems.graphs.YoungestCommonAncestorProblem.AncestralTree;

public class YoungestCommonAncestorSolution implements Solution {

    @SuppressWarnings("all")
    @Override
    public Output<?> solve(Input<?> input) {
        List<Input> inputs = (List<Input>) input.getInput();
        AncestralTree topAncestor = (AncestralTree) inputs.get(0).getInput();
        AncestralTree descendantOne = (AncestralTree) inputs.get(1).getInput();
        AncestralTree descendantTwo = (AncestralTree) inputs.get(2).getInput();

        AncestralTree youngestAncestor = getYoungestCommonAncestor(topAncestor, descendantOne, descendantTwo);

        return new Output<>(youngestAncestor);
    }

    /**
     * <p>
     * Normalize the heights of the descendant nodes and then find the common ancestor
     * </p>
     * <b>T</b> O(d) <b>S</b> O(1) where d is the depth of the tree.
     * @param topAncestor
     * @param descendantOne
     * @param descendantTwo
     * @return Youngest common ancestor
     */
    public AncestralTree getYoungestCommonAncestor(AncestralTree topAncestor, AncestralTree descendantOne,
            AncestralTree descendantTwo) {

        if (Objects.isNull(descendantOne.ancestor))
            return descendantOne;
        else if (Objects.isNull(descendantTwo.ancestor))
            return descendantTwo;

        AncestralTree currentOne = descendantOne;
        AncestralTree currentTwo = descendantTwo;

        int oneDepth = 0;
        while (currentOne.name != topAncestor.name) {

            oneDepth++;

            currentOne = currentOne.ancestor;

        }

        int twoDepth = 0;
        while (currentTwo.name != topAncestor.name) {

            twoDepth++;

            currentTwo = currentTwo.ancestor;
        }

        AncestralTree deeperNode;
        AncestralTree higherNode;
        int higherDepth;
        int lowerDepth;

        if (oneDepth > twoDepth) {
            deeperNode = descendantOne;
            higherNode = descendantTwo;
            higherDepth = oneDepth;
            lowerDepth = twoDepth;
        } else if (oneDepth < twoDepth) {
            deeperNode = descendantTwo;
            higherNode = descendantOne;
            higherDepth = twoDepth;
            lowerDepth = oneDepth;
        } else {
            deeperNode = descendantTwo;
            higherNode = descendantOne;
            higherDepth = twoDepth;
            lowerDepth = oneDepth;
        }

        while (higherDepth > lowerDepth) {
            higherDepth--;
            deeperNode = deeperNode.ancestor;
        }

        while (deeperNode.name != higherNode.name) {
            deeperNode = deeperNode.ancestor;
            higherNode = higherNode.ancestor;
        }

        return higherNode;
    }

}
