package core.datastructure;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class BSTTest {

    @Test
    public void testInsert() {
        BST node = new BST(10);
        node.insert(14);
        node.insert(8);

        assert(node.search(14).isPresent());
        assert(node.search(8).isPresent());
    }

    @Test
    public void testDelete() {
        BST node = new BST(10);
        node.insert(14);
        node.insert(8);

        node.delete(14);


        assert(!node.search(14).isPresent());

    }

    @Test
    public void testContains() {
        BST node = new BST(10);
        insertHelper(node, Arrays.asList(5,15,2,5,13,22,1,14,12));
        node.delete(10);
        assert(node.search(15).isPresent());
    }

    @Test
    public void testMultipleOps() {
        BST node = new BST(10);
        insertHelper(node, Arrays.asList(5, 15));
        node.delete(5);
        node.delete(15);
        node.delete(10);

    }

    @Test
    public void testMultipleOps2() {
        BST node = new BST(1);
        insertHelper(node, Arrays.asList(2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));
        node.delete(2);
        node.delete(4);
        node.delete(6);
        node.delete(8);
        node.delete(11);
        node.delete(13);
        node.delete(15);
        node.delete(17);
        node.delete(19);
        insertHelper(node, Arrays.asList(1,2,3,4,5,6,7,8,9,10));
    }

    @Test
    public void testMultipleOps3(){

        BST node = new BST(10);
        insertHelper(node, Arrays.asList(2,15,14,22,1));

        node.delete(14);
    }

    private void insertHelper(BST tree, List<Integer> values) {

        values.forEach(e -> tree.insert(e));

    }

}
