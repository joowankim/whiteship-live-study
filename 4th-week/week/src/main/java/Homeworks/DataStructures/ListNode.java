package Homeworks.DataStructures;

public class ListNode {
    private Integer value;
    private ListNode next;
    
    public ListNode() {}

    public ListNode(Integer value) {
        this.value = value;
        this.next = null;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public ListNode getNext() {
        return this.next;
    }

    public void setNext(ListNode node) {
        this.next = node;
    }

    static public ListNode get(ListNode head, int position) {
        if (position <= 0) {
            System.out.println("Position should be positve.");
            return null;
        }
        ListNode current = head;
        while (position-- > 0) {
            current = current.getNext();
            if (current == null && position > 0) {
                System.out.println("Out of range");
                return null;
            }
        }
        return current;
    }

    static public ListNode add(ListNode head, ListNode nodeToAdd, int position) {
        if (position <= 0) {
            System.out.println("Invalid position");
            return null;
        }
        ListNode before = null;
        ListNode current = head;
        while (position-- > 0) {
            before = current;
            current = current.getNext();
            if (current == null && position > 0) {
                System.out.println("Out of range");
                return null;
            }
        }
        before.setNext(nodeToAdd);
        nodeToAdd.setNext(current);
        return nodeToAdd;
    }

    static public ListNode remove(ListNode head, int positionToRemove) {
        if (positionToRemove <= 0) {
            System.out.println("Invalid position");
            return null;
        }
        ListNode before = null;
        ListNode current = head;
        while (positionToRemove-- > 0) {
            before = current;
            current = current.getNext();
            if (current == null && positionToRemove >= 0) {
                System.out.println("Out of range");
                return null;
            }
        }
        ListNode next = current.getNext();
        if (next == null) {
            before.setNext(null);
        } else {
            before.setNext(next);
        }
        return current;
    }

    static public boolean contains(ListNode head, ListNode nodeToCheck) {
        ListNode current = head;
        while (current.getNext() != null) {
            if (current.getNext() == nodeToCheck) return true;
            current = current.getNext();
        }
        return false;
    }
}
