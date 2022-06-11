package core.datastructure;

import java.util.List;

public class BST {

    public BST left;
    public BST right;
    public Integer value;
    public Integer depth;

    public static BST toBinaryTree(List<Integer> values) {

        return toBinaryTreeHelper(values, new BST(), 0);
    }

    private static BST toBinaryTreeHelper(List<Integer> values, BST tree, int currIndex) {


        if(currIndex < values.size()) {
            tree.value = values.get(currIndex);
        }

        if(!((2 * currIndex) + 1 > values.size() - 1)) {
            tree.left = new BST();
            tree.right= new BST();
            toBinaryTreeHelper(values, tree.left, (2 * currIndex) + 1);
            toBinaryTreeHelper(values, tree.right, (2 * currIndex) + 2);
        }

        return tree;
    }

    public static void printBinaryTree(BST tree) {
        printBinaryTreeHelper(tree, 0);
    }

    public static void printBinaryTreeHelper(BST root, int space) {
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



