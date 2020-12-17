package ClassStudy.Tree;

import java.util.*;

public class BinaryTree {
    private Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return this.root;
    }

    public void setRoot(Node node) {
        this.root = node;
    } 

    public void addNode(Node node) {
        Node current = this.root;
        while (current != null) {
            if (current.getValue() < node.getValue()) {
                if (current.getRight() == null) {
                    current.setRight(node);
                    break;
                } else { 
                    current = current.getRight();
                }
            } else {
                if (current.getLeft() == null) {
                    current.setLeft(node);
                    break;
                } else { 
                    current = current.getLeft();
                }
            }
        }
    }
    
    private Queue<Node> initQueue(Node node) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        return queue;
    }

    private void bfsVisit(Queue<Node> queue, Node node) {
        if (node.getLeft() != null) queue.add(node.getLeft());
        if (node.getRight() != null) queue.add(node.getRight());
    }

    public List<Integer> bfs() {
        List<Integer> result = new ArrayList<>();
        Queue<Node> queue = initQueue(this.root);
        while (!queue.isEmpty()) {
            Node current = queue.remove();
            result.add(current.getValue());
            bfsVisit(queue, current);
        }
        return result;
    }

    private Stack<Node> initStack(Node node) {
        Stack<Node> stack = new Stack<Node>();
        stack.push(node);
        return stack;
    }

    private void dfsVisit(Stack<Node> stack, Node node) {
        if (node.getRight() != null) stack.push(node.getRight());
        stack.push(node);
        if (node.getLeft() != null) stack.push(node.getLeft());
    }

    private Map<Integer, Boolean> initVisited() {
        return new HashMap<Integer, Boolean>();
    }

    public List<Integer> dfs() {
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = initStack(this.root);
        Map<Integer, Boolean> visited = initVisited();
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            if (visited.getOrDefault(current.getValue(), false)) {
                result.add(current.getValue());
                continue;
            }
            dfsVisit(stack, current);
            visited.put(current.getValue(), true);
        }
        return result;
    }

    public List<Integer> recursiveDfs(Node node, List<Integer> result) {
        if (node.getLeft() != null) recursiveDfs(node.getLeft(), result);
        result.add(node.getValue());
        if (node.getRight() != null) recursiveDfs(node.getRight(), result);
        return result;
    }
}
