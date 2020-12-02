package Homeworks.DataStructures;

public class ListNodeStack {
    private ListNode head;

    public ListNodeStack() {
        this.head = new ListNode();
    }

    public void push(int data) {
        ListNode node = new ListNode(data);
        ListNode.add(this.head, node, 1);
    }

    public int pop() throws Exception {
        ListNode ret = ListNode.remove(this.head, 1);
        if (ret == null) {
            throw new Exception("No more stack");
        }
        return ret.getValue();
    }
}
