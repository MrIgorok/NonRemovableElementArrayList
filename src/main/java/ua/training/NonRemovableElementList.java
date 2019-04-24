package ua.training;

public interface NonRemovableElementList<T> extends Iterable<T> {
    void add(T e);
    void add(int index, T e);
    T get(int index);
    int size();
}
