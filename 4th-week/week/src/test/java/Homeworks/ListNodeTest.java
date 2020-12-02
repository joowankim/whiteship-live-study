package Homeworks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import Homeworks.DataStructures.ListNode;

public class ListNodeTest {
    @Test
    public void ListNodeAddTest() {
        ListNode head = new ListNode();
        ListNode first = new ListNode(23);
        ListNode last = new ListNode(23);

        assertEquals(first, ListNode.add(head, first, 1));
        ListNode.add(head, new ListNode(-43), 1);
        ListNode.add(head, new ListNode(232), 1);
        ListNode.add(head, new ListNode(2), 1);
        ListNode.add(head, new ListNode(1), 1);
        ListNode.add(head, new ListNode(0), 1);
        ListNode.add(head, new ListNode(123), 1);
        assertEquals(last, ListNode.add(head, last, 1));

        assertEquals(first, ListNode.get(head, 8));

        ListNode node = new ListNode(34);
        
        // 1. add to 0 position
        assertNull(ListNode.add(head, node, 0));

        // 2. add to last position
        assertEquals(node, ListNode.add(head, node, 9));

        ListNode node2 = new ListNode(0);

        // 3. add to negative position
        assertNull(ListNode.add(head, node2, -9));
        
        // 4. add to out of range position
        assertNull(ListNode.add(head, node2, 13));

        // check first node
        assertEquals(last, ListNode.get(head, 1));
    }

    @Test
    public void ListNodeRemove() {
        ListNode head = new ListNode();
        ListNode first = new ListNode(23);
        ListNode last = new ListNode(23);

        ListNode.add(head, first, 1);
        ListNode.add(head, new ListNode(-43), 1);
        ListNode.add(head, new ListNode(232), 1);
        ListNode.add(head, new ListNode(2), 1);
        ListNode.add(head, new ListNode(1), 1);
        ListNode.add(head, new ListNode(0), 1);
        ListNode.add(head, new ListNode(123), 1);
        ListNode.add(head, last, 1);

        // 1. remove 1st node
        assertEquals(last, ListNode.remove(head, 1));
        assertEquals(ListNode.get(head, 1).getValue(), 123);

        // 2. remove last node
        assertEquals(first, ListNode.remove(head, 7));
        assertEquals(ListNode.get(head, 6).getValue(), -43);

        // 3. remove middle node
        assertEquals(232, ListNode.remove(head, 5).getValue());
        assertEquals(-43, ListNode.get(head, 5).getValue());

        // 4. remove negative node
        assertNull(ListNode.remove(head, -3));

        // 5. remove out of range node
        assertNull(ListNode.remove(head, 8));

    }

    @Test
    public void ListNodeContains() {
        ListNode head = new ListNode();
        ListNode first = new ListNode(23);
        ListNode last = new ListNode(23);

        ListNode.add(head, first, 1);
        ListNode.add(head, new ListNode(-43), 1);
        ListNode.add(head, new ListNode(232), 1);
        ListNode.add(head, new ListNode(2), 1);
        ListNode.add(head, new ListNode(1), 1);
        ListNode.add(head, new ListNode(0), 1);
        ListNode.add(head, new ListNode(123), 1);
        ListNode.add(head, last, 1);

        // 1. same value & different node
        assertEquals(-43, ListNode.get(head, 7).getValue());
        assertNotEquals(new ListNode(-43), ListNode.get(head, 7));

        // 2. same value & same node
        assertEquals(23, ListNode.get(head, 1).getValue());
        assertEquals(last, ListNode.get(head, 1));
    }
}
