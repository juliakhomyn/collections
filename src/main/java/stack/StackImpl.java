package main.java.stack;

public class StackImpl implements Stack {
    private Node top;
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
        top = null;
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
    public void push(Object element) {
        Node n = new Node(element);
        if (isEmpty()) {
            top = n;
        } else {
            n.next = top;
            top = n;
        }
        size++;
    }

    @Override
    public Object pop() {
        Node n = top;
        top = top.next;
        size--;
        return n.value;
    }

    @Override
    public Object peek() {
        if (isEmpty()) {
            return null;
        }
        return top.value;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        Node current = top;
        Node[] arr = new Node[size];
        for (int i = size - 1; i >= 0; i--) {
            arr[i] = current;
            current = current.next;
        }
        for (int i = 0; i < size; i++) {
            stringBuilder.append(arr[i].value);
            if (i != size - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

}
