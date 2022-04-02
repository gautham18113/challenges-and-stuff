package core.datastructure;

import java.util.List;

public class CustomBinaryTree {

    public CustomBinaryTree left;
    public CustomBinaryTree right;
    public Integer value;
    public Integer depth;

    public static CustomBinaryTree toBinaryTree(List<Integer> values) {

        return toBinaryTreeHelper(values, new CustomBinaryTree(), 0);
    }

    private static CustomBinaryTree toBinaryTreeHelper(List<Integer> values, CustomBinaryTree tree, int currIndex) {


        if(currIndex < values.size()) {
            tree.value = values.get(currIndex);
        }

        if(!((2 * currIndex) + 1 > values.size() - 1)) {
            tree.left = new CustomBinaryTree();
            tree.right= new CustomBinaryTree();
            toBinaryTreeHelper(values, tree.left, (2 * currIndex) + 1);
            toBinaryTreeHelper(values, tree.right, (2 * currIndex) + 2);
        }

        return tree;
    }

    public static void printBinaryTree(CustomBinaryTree tree) {
        printBinaryTreeHelper(tree, 0);
    }

    public static void printBinaryTreeHelper(CustomBinaryTree root, int space) {
        if (root == null)
            return;

        space += 10;

        printBinaryTreeHelper(root.right, space);

        System.out.print("\n");

        for (int i = 10; i < space; i++)
            System.out.print(" ");

        System.out.print(root.value + "\n");

        printBinaryTreeHelper(root.left, space);
    }
}



