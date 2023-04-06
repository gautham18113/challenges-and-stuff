package core.datastructure;

import java.util.Objects;

public class Node<T> {
    public T val;
    public Node<T> left;
    public Node<T> right;

    public Node(T val) {
        this(val, null, null);
    }

    public Node(T val, Node<T> left, Node<T> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int numberOfNodes() {
        return numberOfNodesHelper(this);
    }

    public int getDepth() {
        return getDepthHelper(this, 0);
    }

    private int getDepthHelper(Node node, int currDepth) {

        if (node == null) {
            return currDepth;
        }

        int leftDepth = getDepthHelper(node.left, currDepth + 1);
        int rightDepth = getDepthHelper(node.right, currDepth + 1);

        return Math.max(leftDepth, rightDepth);
    }

    private int numberOfNodesHelper(Node node) {
        if (Objects.isNull(node)) {
            return 0;
        }

        int count = 1;

        count += numberOfNodesHelper(node.left);
        count += numberOfNodesHelper(node.right);

        return count;
    }
}