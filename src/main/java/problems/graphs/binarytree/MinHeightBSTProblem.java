package problems.graphs.binarytree;


import core.Problem;
import core.ProblemInterface;
import core.TestCase;
import core.datastructure.BST;

public class MinHeightBSTProblem implements ProblemInterface{

    /*
     * https://www.algoexpert.io/questions/min-height-bst
     */
    @Override
    public Problem getProblem() {

        BST tree1 = new BST(10);
        tree1.insert(7);
        tree1.insert(5);
        tree1.insert(2);
        tree1.insert(1);
        tree1.insert(13);
        tree1.insert(14);
        tree1.insert(15);
        tree1.insert(22);

        return Problem.builder()

        .withTestCase(
            TestCase.builder()
            .withInput(new int[]{1,2,5,7,10,13,14,15,22})
            .withOutput(tree1)
            .build()
        )
        .build();
    }

}
