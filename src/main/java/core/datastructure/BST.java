package core.datastructure;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class BST {

    public BST left;
    public BST right;
    public BST parent;
    public Integer value;
    public Integer depth;

    public BST(Integer value) {
        this.value = value;
    }

    public boolean equals(BST compareTo) {
        return BST.equals(this, compareTo);
    }

    private static boolean equals(BST compareFrom, BST compareTo) {
        if(Objects.isNull(compareFrom) && Objects.isNull(compareTo)) return true;
        return compareFrom.value == compareTo.value && BST.equals(compareFrom.left, compareTo.left) && BST.equals(compareFrom.right, compareTo.right);
    }

    @Override
    public String toString() {
        return String.format("BST(value: %s, left: %s, right: %s)", this.value,
                Objects.nonNull(this.left) ? this.left.value : null,
                Objects.nonNull(this.right) ? this.right.value : null);
    }

    public static BST toBinaryTree(List<Integer> values) {

        return toBinaryTreeHelper(values , 0);
    }

    private static BST toBinaryTreeHelper(List<Integer> values, int currIndex) {
        if (currIndex >= values.size()) {
            return null;
        } else if(values.get(currIndex) == null) {
            return null;
        }

        BST tree = new BST(values.get(currIndex));

        tree.left = toBinaryTreeHelper(values, (2 * currIndex) + 1);
        tree.right = toBinaryTreeHelper(values, (2 * currIndex) + 2);

        return tree;
    }

    public void printBinaryTree() {

        BST tree = this;

        int level = 0;

        printBinaryTreeRecursive(tree, level);

    }

    /*
     * Algorithm:
     * Perform an In - order traversal of the binary tree
     * starting from right most leaf node, recursively print node value
     */
    public static void printBinaryTreeRecursive(BST tree, int level) {

        if(tree == null) {
            return;
        }

        BST right = tree.right;
        BST left = tree.left;

        printBinaryTreeRecursive(right, level + 1);
        printStr(" ", level);
        System.out.print(tree.value);
        System.out.println("\n");
        printBinaryTreeRecursive(left, level + 1);

    }

    private static void printStr(String s, int times) {
        for(int i = 0; i < times*10; i++) {
            System.out.print(s);
        }
    }

    public Optional<BST> search(Integer value) {

        BST currentNode = this;

        while (Objects.nonNull(currentNode)) {
            if (currentNode.value == value) {
                return Optional.of(currentNode);
            }
            if (currentNode.value < value) {
                currentNode = currentNode.right;
                continue;
            }

            if (currentNode.value > value) {
                currentNode = currentNode.left;
                continue;
            }

        }

        return Optional.empty();

    }

    public void delete(Integer value) {

        Optional<BST> node = this.search(value);

        if (node.isPresent()) {
            BST foundNode = node.get();

            /* Both left and right trees of node are not null */

            if (foundNode.left != null && foundNode.right != null) {

                int leftOfRightMin = foundNode.right.getMinimumValueInSubTree();

                foundNode.value = leftOfRightMin;

                foundNode.right.delete(leftOfRightMin);

            }

            /* Node is a root node and either left or right sub tree is null */

            else if (foundNode.parent == null) {

                if (foundNode.left != null) {
                    foundNode.value = foundNode.left.value;
                    foundNode.left = foundNode.left.left;
                    foundNode.right = foundNode.left.right;
                } else if (foundNode.right != null) {
                    foundNode.value = foundNode.right.value;
                    foundNode.left = foundNode.right.left;
                    foundNode.right = foundNode.right.right;
                } else {
                    /* Single node tree, don't delete */
                    return;
                }
                /* Update parent node of shifted nodes */
                if (foundNode.left != null) {
                    foundNode.left.parent = foundNode;
                }
                if (foundNode.right != null) {
                    foundNode.right.parent = foundNode;
                }
            }

            /* Node is not a root node and either left or right sub tree is null
             * For each case, update parent and set child of root to child of
             * left or right child.
             */

            else {

                if (foundNode.parent.left == foundNode) {
                    if (foundNode.left != null) {
                        foundNode.left.parent = foundNode.parent;
                        foundNode.parent.left = foundNode.left;
                    } else if (foundNode.right != null) {
                        foundNode.right.parent = foundNode.parent;
                        foundNode.parent.left = foundNode.right;
                    } else {
                        foundNode.parent.left = null;
                    }
                } else if (foundNode.parent.right == foundNode) {
                    if (foundNode.left != null) {
                        foundNode.left.parent = foundNode.parent;
                        foundNode.parent.right = foundNode.left;
                    } else if (foundNode.right != null) {
                        foundNode.right.parent = foundNode.parent;
                        foundNode.parent.right = foundNode.right;
                    } else {
                        foundNode.parent.right = null;
                    }
                }
            }

        }

    }

    public int getMinimumValueInSubTree() {
        BST current = this;

        while (current.left != null) {
            current = current.left;
        }

        return current.value;
    }

    public BST insert(Integer value) {

        BST currentNode = this;

        while (Objects.nonNull(currentNode)) {
            if (value < currentNode.value) {
                if (Objects.isNull(currentNode.left)) {
                    currentNode.left = new BST(value);
                    currentNode.left.parent = currentNode;
                    break;
                }
                currentNode = currentNode.left;
            } else {
                if (Objects.isNull(currentNode.right)) {
                    currentNode.right = new BST(value);
                    currentNode.right.parent = currentNode;
                    break;
                }
                currentNode = currentNode.right;
            }
        }

        return this;

    }
}
