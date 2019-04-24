package ua.training;

import java.util.Iterator;

public class NonRemovableElementArrayList<T> implements NonRemovableElementList<T> {
    static final int BEGIN_SIZE = 8;
    static final double INCREASE_SIZE_FACTOR = 2;
    private Object [] elements;
    private int size;

    NonRemovableElementArrayList(T [] elements) {
        int newSize = BEGIN_SIZE;
        if (elements.length >= BEGIN_SIZE) {
            int factor = (int)Math.ceil(Math.log(elements.length/BEGIN_SIZE)/Math.log(INCREASE_SIZE_FACTOR));
            newSize = factor * BEGIN_SIZE;
        }

        this.elements = new Object[newSize];

        System.arraycopy(elements, 0, this.elements, 0, elements.length);
        size = elements.length;
    }

    public NonRemovableElementArrayList() {
        elements = new Object[BEGIN_SIZE];
        size = 0;
    }

    @Override
    public void add(T e) {
        if (size + 1 >= elements.length) {
            ensureCapacity();
        }

        elements[size++] = e;
    }

    @Override
    public void add(int index, T e) {
        int lengthBefore = elements.length;

        if (size + 1 >= elements.length) {
            ensureCapacity();
        }

        System.arraycopy(elements, index, elements, index + 1, lengthBefore - index - 1);
        elements[index] = e;
        size++;
    }

    @Override
    public T get(int index) {
        return (T)elements[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new NonRemovableElementsIterator<T>(elements);
    }

    void ensureCapacity() {
        int newSize = (int)(elements.length * INCREASE_SIZE_FACTOR);
        Object [] temp = elements;
        elements = new Object[newSize];
        System.arraycopy(temp, 0, elements, 0, temp.length);
    }

    int capacity() {
        return elements.length;
    }

    Object [] getElements() {
        return elements;
    }
}
