package problems.graphs.binarytree;

import core.Problem;
import core.ProblemInterface;
import core.TestCase;
import core.datastructure.BST;

public class FindSuccessorProblem implements ProblemInterface{

    @Override
    public Problem getProblem() {
        BST tree1 = new BST(1);
        tree1.left = new BST(2);
        tree1.right = new BST(3);
        tree1.left.left = new BST(4);
        tree1.left.right = new BST(5);
        tree1.left.left.left = new BST(6);

        BST tree2 = new BST(1);
        tree2.left = new BST(2);
        tree2.right = new BST(3);
        tree2.left.left = new BST(4);
        tree2.left.right = new BST(5);
        tree2.left.right.left = new BST(7);
        tree2.left.right.left.right = new BST(10);
        tree2.left.right.left.left = new BST(8);
        tree2.left.left.left = new BST(6);


        return Problem.builder()
        .withTestCase(TestCase.builder().withInput(tree1).withInput(2).withOutput(5).build())
        .withTestCase(TestCase.builder().withInput(tree2).withInput(2).withOutput(8).build())
        .build();
    }

}
