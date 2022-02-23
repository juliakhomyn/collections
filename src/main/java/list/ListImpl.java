package main.java.list;

import main.java.list.List;
import main.java.queue.LinkedQueueImpl;

import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class ListImpl implements List {
    Node head;
    Node tail;
    private int size;

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Node {
        private Object value;
        private Node prev;
        private Node next;

        public Node(Object value) {
            this.value = value;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void addFirst(Object element) {
        Node node = new Node(element);
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            Node n = head;
            head = node;
            head.next = n;
            head.prev = n;
        }
        size++;
    }

    @Override
    public void addLast(Object element) {
        Node node = new Node(element);
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            Node n = tail;
            n.next = node;
            node.prev = n;
            tail = node;
        }
        size++;
    }

    @Override
    public void removeFirst() {
        if (size != 0) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    @Override
    public void removeLast() {
        if (size != 0) {
            tail = tail.prev;
            tail.next = null;
            size--;
        }
    }

    @Override
    public Object getFirst() {
        return size == 0 ? null : head.value;
    }

    @Override
    public Object getLast() {
        return size == 0 ? null : tail.value;
    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    @Override
    public Object search(Object element) {
        if (size == 0 || element == null || head == null) {
            return null;
        }
        Node current = head;
        while (current != null) {
            if (element.equals(current.value)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public boolean remove(Object element) {
        if (size == 0) {
            return false;
        }
        if ((element != null && element.equals(head.value)) || (element == null && head.value == null)) {
            head = head.next;
            head.prev = null;
            size--;
            return true;
        }
        if ((element != null && element.equals(tail.value)) || (element == null && tail.value == null)) {
            tail = tail.prev;
            tail.next = null;
            size--;
            return true;
        }
        Node current = head;
        while (current != tail) {
            if (element.equals(current.value)) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Index Error");
        }
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
