package test.java;

import main.java.list.ArrayImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayImplTest {

    private ArrayImpl array;

    @BeforeEach
    void setup() {
        array = new ArrayImpl();
    }

    @Test
    public void test_add_and_remove() {
        array.add("A");
        array.add("B");
        assertEquals(2, array.size());

        array.remove(0);
        assertEquals("B", array.get(0));
        assertEquals(1, array.size());
    }

    @Test
    public void test_set_and_get_by_index() {
        array.add("A");
        array.add("B");
        array.add("C");
        array.set(1, "D");

        assertEquals("D", array.get(1));
    }

    @Test
    public void test_array_is_empty_after_remove() {
        array.add("A");
        array.add("B");
        array.remove(0);
        array.remove(0);

        assertTrue(array.isEmpty());
    }

    @Test
    public void test_array_is_empty_after_clear() {
        array.add("A");
        array.add("B");
        array.clear();

        assertTrue(array.isEmpty());
    }

    @Test
    public void test_is_empty_new_array() {
         assertTrue(array.isEmpty());
    }

    @Test
    public void test_array_with_data_is_empty_return_false() {
        array.add("A");
        array.add("B");

        assertFalse(array.isEmpty());
    }

    @Test
    public void test_remove() {
        array.add("A");
        array.add("B");
        array.add("C");

        array.remove(1);

        assertEquals("[A, C]", array.toString());
        assertEquals(2, array.size());
    }

    @Test
    public void test_get_index_of() {
        array.add("A");
        array.add("B");
        array.add("C");

        assertEquals(1, array.indexOf("B"));
        assertEquals(-1, array.indexOf("D"));
    }

    @Test
    public void test_throw_exception_when_get_on_empty_array() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            array.get(2);
        });
    }

    @Test
    public void test_throw_exception_when_get_wrong_index() {
        array.add("A");
        array.add("B");

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            array.get(2);
        });
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            array.get(-2);
        });
    }

    @Test
    public void test_throw_exception_when_remove_wrong_index() {
        array.add("A");

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            array.get(2);
        });
    }

    @Test
    public void test_array_to_string() {
        array.add("A");
        array.add("B");
        array.add("C");

        assertEquals("[A, B, C]", array.toString());
    }

    @Test
    public void test_empty_array_to_string() {
        assertEquals("[]", array.toString());
    }

}
