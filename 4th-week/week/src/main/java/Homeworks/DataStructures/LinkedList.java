package Homeworks.DataStructures;

public class LinkedList {
    private ListNode head;

    public LinkedList() {
        this.head = new ListNode();
    }

    public ListNode get(int position) {
        if (position <= 0) {
            System.out.println("Position should be positve.");
            return null;
        }
        ListNode current = this.head;
        while (position-- > 0) {
            current = current.getNext();
            if (current == null && position > 0) {
                System.out.println("Out of range");
                return null;
            }
        }
        return current;
    }

    public ListNode add(ListNode nodeToAdd, int position) {
        if (position <= 0) {
            System.out.println("Position should be positve.");
            return null;
        }
        ListNode before = null;
        ListNode current = this.head;
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

    public ListNode remove(int positionToRemove) {
        if (positionToRemove <= 0) {
            System.out.println("Position should be positve.");
            return null;
        }
        ListNode before = null;
        ListNode current = this.head;
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

    public boolean contains(ListNode nodeToCheck) {
        ListNode current = this.head;
        while(current.getNext() != null) {
            if (current.getNext() == nodeToCheck) return true;
            current = current.getNext();
        }
        return false;
    }
}
