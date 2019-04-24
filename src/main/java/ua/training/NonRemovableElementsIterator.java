package ua.training;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NonRemovableElementsIterator<T> implements Iterator<T> {
    private int index = 0;
    private Object [] values;

    NonRemovableElementsIterator(Object [] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return index < values.length;
    }

    @Override
    public T next() {
        if (index >= values.length) {
            throw new NoSuchElementException("The next item doesn't exist");
        }

        return (T)values[index++];
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove doesn't supported.");
    }


}
