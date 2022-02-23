package main.java.list;

import java.util.StringJoiner;

public class ArrayImpl implements Array {
    private Object[] arr;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;

    public ArrayImpl() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayImpl(int capacity) {
        arr = new Object[capacity];
    }

    private void checkCapacity() {
        if (arr.length == size) {
            Object[] newArr = new Object[arr.length * 3 / 2];
            System.arraycopy(arr, 0, newArr, 0, size - 1);
            arr = newArr;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Index Error");
        }
    }

    @Override
    public void add(Object element) {
        checkCapacity();
        arr[size] = element;
        size++;
    }

    @Override
    public void set(int index, Object element) {
        checkIndex(index);
        arr[index] = element;
    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        return arr[index];
    }

    @Override
    public int indexOf(Object element) {
        if (element != null ) {
            for (int i = 0; i < size; i++) {
                if (arr[i].equals(element)) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        System.arraycopy(arr, index + 1, arr, index, size - 1 - index);
        size--;
    }

    @Override
    public void clear() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        for (int i = 0; i < size; i++) {
            stringBuilder.append(arr[i]);
            if (i != size - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

}
