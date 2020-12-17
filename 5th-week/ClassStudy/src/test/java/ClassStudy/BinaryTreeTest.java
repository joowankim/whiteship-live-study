package ClassStudy;

import org.junit.jupiter.api.Test;

import ClassStudy.Tree.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.*;

public class BinaryTreeTest {

    /**
     * tested tree structure
     * node: <index, value>
     *             10
     *            /  \
     *           0   11
     *          / \    \
     *        -9   2   19
     *              \    \
     *               4   123
     *              / \
     *             3   5
     */

    private BinaryTree makeBinaryTree() {
        Node root = new Node(10);
        List<Node> nodes = new LinkedList<>(Arrays.asList(new Node(0),
                                                          new Node(11),
                                                          new Node(-9),
                                                          new Node(2),
                                                          new Node(19),
                                                          new Node(4),
                                                          new Node(5),
                                                          new Node(123),
                                                          new Node(3)));

        BinaryTree tree = new BinaryTree(root);
        for (int i=0; i<nodes.size(); i++) {
            tree.addNode(nodes.get(i));
        }
        return tree;
    }
    
    @Test
    void bfsTest() {
        BinaryTree tree = makeBinaryTree();
        Object[] expected = {10, 0, 11, -9, 2, 19, 4, 123, 3, 5};
        Object[] actual = tree.bfs().toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    void dfsTest() {
        BinaryTree tree = makeBinaryTree();
        Object[] expected = {-9, 0, 2, 3, 4, 5, 10, 11, 19 ,123};
        Object[] actual = tree.dfs().toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    void recursiveDfsTest() {
        BinaryTree tree = makeBinaryTree();
        Object[] expected = {-9, 0, 2, 3, 4, 5, 10, 11, 19 ,123};
        Object[] actual = tree.recursiveDfs(tree.getRoot(), new ArrayList<Integer>()).toArray();
        assertArrayEquals(expected, actual);
    }

}
