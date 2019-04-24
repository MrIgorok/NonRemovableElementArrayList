package ua.training;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class NonRemovableElementArrayListTest {
    private NonRemovableElementArrayList<Integer> array;
    private Integer [] elements;

    @BeforeEach
    void init() {
        elements = new Integer[] {1, 2, 3};
        array = new NonRemovableElementArrayList<>(elements);
    }

    @RepeatedTest(NonRemovableElementArrayList.BEGIN_SIZE)
    void add() {
        int lengthBefore = array.capacity();

        array.add(4);

        Object [] valuesAfter = array.getElements();

        assertEquals(4, (int)valuesAfter[elements.length]);
    }

    @RepeatedTest(NonRemovableElementArrayList.BEGIN_SIZE)
    void add1() {
        Object [] valuesBefore = Arrays.copyOf(array.getElements(), array.getElements().length);

        array.add(1, 4);

        Object [] valuesAfter = array.getElements();

        assertEquals(valuesBefore[0], valuesAfter[0]);
        assertEquals(4, (int)valuesAfter[1]);
        assertEquals(valuesBefore[1], valuesAfter[2]);
    }

    @Test
    void get() {
        assertEquals(elements[1], array.get(1));
    }

    @Test
    void size() {
        assertEquals(elements.length, array.size());
    }

    @Test
    void ensureCapacity() {
        int lengthBefore = array.capacity();

        array.ensureCapacity();

        int lengthAfter = array.capacity();

        assertEquals(lengthBefore, lengthAfter/NonRemovableElementArrayList.INCREASE_SIZE_FACTOR);
    }
}