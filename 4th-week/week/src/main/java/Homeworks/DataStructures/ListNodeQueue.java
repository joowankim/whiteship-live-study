package Homeworks.DataStructures;

public class ListNodeQueue {
    private ListNode head;
    private int last;

    public ListNodeQueue() {
        this.head = new ListNode();
        this.last = 0;
    }

    public void add(int data) {
        ListNode node = new ListNode(data);
        this.last += 1;
        ListNode.add(this.head, node, this.last);
    }

    public int remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("No more queue");
        }
        this.last -= 1;
        return ListNode.remove(this.head, 1).getValue();

    }

    public int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("No more queue");
        }
        return this.head.getNext().getValue();
    }

    public boolean isEmpty() {
        if (this.last == 0) {
            return true;
        } else {
            return false;
        }
    }

}
