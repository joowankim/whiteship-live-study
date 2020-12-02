package Homeworks;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Homeworks.DataStructures.LinkedList;
import Homeworks.DataStructures.ListNode;


public class LinkedListTest {
    @Test
    public void ListNodeAddTest() {
        LinkedList linkedList = new LinkedList();
        ListNode first = new ListNode(23);
        ListNode last = new ListNode(23);

        assertEquals(first, linkedList.add(first, 1));
        linkedList.add(new ListNode(-43), 1);
        linkedList.add(new ListNode(232), 1);
        linkedList.add(new ListNode(2), 1);
        linkedList.add(new ListNode(1), 1);
        linkedList.add(new ListNode(0), 1);
        linkedList.add(new ListNode(123), 1);
        assertEquals(last, linkedList.add(last, 1));

        assertEquals(first, linkedList.get(8));

        ListNode node = new ListNode(34);
        
        // 1. add to 0 position
        assertNull(linkedList.add(node, 0));

        // 2. add to last position
        assertEquals(node, linkedList.add(node, 9));

        ListNode node2 = new ListNode(0);

        // 3. add to negative position
        assertNull(linkedList.add(node2, -9));
        
        // 4. add to out of range position
        assertNull(linkedList.add(node2, 13));

        // check first node
        assertEquals(last, linkedList.get(1));
    }

    @Test
    public void ListNodeRemove() {
        LinkedList linkedList = new LinkedList();
        ListNode first = new ListNode(23);
        ListNode last = new ListNode(23);

        linkedList.add(first, 1);
        linkedList.add(new ListNode(-43), 1);
        linkedList.add(new ListNode(232), 1);
        linkedList.add(new ListNode(2), 1);
        linkedList.add(new ListNode(1), 1);
        linkedList.add(new ListNode(0), 1);
        linkedList.add(new ListNode(123), 1);
        linkedList.add(last, 1);

        // 1. remove 1st node
        assertEquals(last, linkedList.remove(1));
        assertEquals(linkedList.get(1).getValue(), 123);

        // 2. remove last node
        assertEquals(first, linkedList.remove(7));
        assertEquals(linkedList.get(6).getValue(), -43);

        // 3. remove middle node
        assertEquals(232, linkedList.remove(5).getValue());
        assertEquals(-43, linkedList.get(5).getValue());

        // 4. remove negative node
        assertNull(linkedList.remove(-3));

        // 5. remove out of range node
        assertNull(linkedList.remove(8));

    }

    @Test
    public void ListNodeContains() {
        LinkedList linkedList = new LinkedList();
        ListNode first = new ListNode(23);
        ListNode last = new ListNode(23);

        linkedList.add(first, 1);
        linkedList.add(new ListNode(-43), 1);
        linkedList.add(new ListNode(232), 1);
        linkedList.add(new ListNode(2), 1);
        linkedList.add(new ListNode(1), 1);
        linkedList.add(new ListNode(0), 1);
        linkedList.add(new ListNode(123), 1);
        linkedList.add(last, 1);

        // 1. same value & different node
        assertEquals(-43, linkedList.get(7).getValue());
        assertNotEquals(new ListNode(-43), linkedList.get(7));

        // 2. same value & same node
        assertEquals(23, linkedList.get(1).getValue());
        assertEquals(last, linkedList.get(1));
    }
}
