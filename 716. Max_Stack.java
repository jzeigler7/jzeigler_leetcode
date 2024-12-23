import java.util.*;

class MaxStack {
    private class Node {
        int val;
        Node prev, next;
        Node(int val) {
            this.val = val;
        }
    }

    private Node head, tail;
    private TreeMap<Integer, LinkedList<Node>> map;

    public MaxStack() {
        head = new Node(0); // Dummy head
        tail = new Node(0); // Dummy tail
        head.next = tail;
        tail.prev = head;
        map = new TreeMap<>();
    }

    // Add a node to the tail of the doubly linked list
    private void addNode(Node node) {
        Node prev = tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = tail;
        tail.prev = node;
    }

    // Remove a node from the doubly linked list
    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void push(int x) {
        Node node = new Node(x);
        addNode(node); // O(1)
        map.putIfAbsent(x, new LinkedList<>());
        map.get(x).addFirst(node); // Add to TreeMap (efficient management of max values)
    }

    public int pop() {
        if (tail.prev == head) throw new RuntimeException("Stack is empty");
        Node node = tail.prev;
        removeNode(node); // O(1)
        LinkedList<Node> nodes = map.get(node.val);
        nodes.removeFirst(); // O(1) removal of the node from TreeMap
        if (nodes.isEmpty()) {
            map.remove(node.val); // Clean up TreeMap
        }
        return node.val;
    }

    public int top() {
        if (tail.prev == head) throw new RuntimeException("Stack is empty");
        return tail.prev.val;
    }

    public int peekMax() {
        if (map.isEmpty()) throw new RuntimeException("Stack is empty");
        return map.lastKey(); // O(log n) retrieval of the maximum value
    }

    public int popMax() {
        if (map.isEmpty()) throw new RuntimeException("Stack is empty");
        int max = map.lastKey(); // O(log n)
        LinkedList<Node> nodes = map.get(max);
        Node node = nodes.removeFirst(); // O(1)
        if (nodes.isEmpty()) {
            map.remove(max); // Clean up TreeMap
        }
        removeNode(node); // O(1) removal of the node from the doubly linked list
        return max;
    }
}




/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */