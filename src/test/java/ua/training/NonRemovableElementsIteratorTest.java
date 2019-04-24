package ua.training;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class NonRemovableElementsIteratorTest {

    private NonRemovableElementsIterator<Integer> iterator;
    private Integer [] elements;

    @BeforeEach
    void init() {
        elements = new Integer[] {1, 2, 3};
        iterator = new NonRemovableElementsIterator<Integer>(elements);
    }

    @Test
    void hasNext() {
        int index;

        index = assertTimeout(Duration.ofSeconds(10), () -> {
            int res = 0;

            while (iterator.hasNext()) {
                res++;
                iterator.next();
            }

            return res;
        });


        assertFalse(iterator.hasNext());
        assertEquals(elements.length, index);
    }

    @Test
    void next() {
        for (int element : elements) {
            assertEquals(element, (int)iterator.next());
        }

        Exception exception = assertThrows(NoSuchElementException.class, () -> iterator.next());
        assertEquals("The next item doesn't exist", exception.getMessage());
    }

    @Test
    void remove() {
        Exception exception = assertThrows(UnsupportedOperationException.class, () -> iterator.remove());

        assertEquals("Remove doesn't supported.", exception.getMessage());
    }
}