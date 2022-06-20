# Binary Tree
A Binary tree is a data structure that contains nodes that satisfy the following properties:
1. Each node can have a value of string or integer type.
2. Every node should have a maximum of two child nodes.
# Binary Search Tree

A BST is a binary tree that satisfies the following properties.
A node is a BST if:
1. the value of that node is strictly greater than the value of the child node to it's left.
2. the value of that node is less than or equal to the value of the child node to it's right.
3. the left and right children node of that node should also be BSTs and should satisfy the BST property.

## Insert into BST
Compare value to be inserted with value of current node.

If value is lesser, go left.

If value is greater than or equal to, go right.

If node in direction to go is null, then insert.

## Remove from BST

Algorithm:

```java
delete(value) {
    node = search(value)

    if(node is not null) {
        if(left and right child of node != null) {
            swap node.value with minimum value of right sub tree
            delete(node.value)
        }
        /* Node to be deleted is the root node and either left or right child is null */
        else if(parent of node == null) {
            if(left of node != null) {
                node.value = node.left.value
                node.right = node.left.right
                node.left = node.left.left
                node.left.parent = node
                if(node.right != null) node.right.parent = node
            }
            else if(right of node != null) {
                node.value = node.right.value
                node.left = node.right.left
                node.right = node.right.right
                node.right.parent = node
                if(node.left != null) node.left.parent = node
            }
            else {
                /* Tree with single node, do not delete */
            }
        }
        /* Node to be deleted is the left child of it's parent */
        else if(left node of parent of node == node) {
            if(left of node is null && right of node is null) {
                node.parent.left = null;
            }
            else if (left of node is null) {
                node.right.parent = node.parent
                node.parent.left = node.right
            else {
                node.left.parent = node.parent
                node.parent.left = node.left
            }
        }
        /* Node to be deleted is the right child of it's parent */
        else if(right node of parent of node == node) {
            if(left of node is null && right of node is null) {
                node.parent.left = null;
            }
            else if (left of node is null) {
                node.right.parent = node.parent
                node.parent.right = node.right
            else {
                node.left.parent = node.parent
                node.parent.right = node.left
            }


        }
    }
}

```


## Search in BST
Same as insert but check for node with value equal to value being searched.