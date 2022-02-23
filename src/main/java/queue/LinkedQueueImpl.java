package main.java.queue;

public class LinkedQueueImpl implements Queue{
    private Node head;
    private Node tail;
    private int size;

    private static class Node {
        private Object value;
        private Node next;

        public Node(Object value) {
            this.value = value;
        }
    }

    @Override
    public void clear() {
        size = 0;
        head = null;
        tail = null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(Object element) {
        Node n = new Node(element);
        if (isEmpty()) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            tail = tail.next;
        }
        size++;
    }

    @Override
    public Object dequeue() {
        if (isEmpty()) {
            return null;
        }
        Node n = head;
        head = n.next;
        size--;
        return n.value;
    }

    @Override
    public Object top() {
        return head.value;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        Node current = head;
        while (current != null) {
            stringBuilder.append(current.value);
            if (current.next != null) {
                stringBuilder.append(", ");
            }
            current = current.next;
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

}
