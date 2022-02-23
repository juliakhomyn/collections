package test.java;

import main.java.list.ListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListImplTest {

    private ListImpl list;

    @BeforeEach
    void setup() {
        list = new ListImpl();
    }

    @Test
    public void test_add_first_and_change_size() {
        list.addFirst("B");
        list.addFirst("A");

        assertEquals(2, list.size());
        assertEquals("[A, B]", list.toString());
    }

    @Test
    public void test_add_last_and_change_size() {
        list.addFirst("B");
        list.addFirst("A");
        list.addLast("C");

        assertEquals(3, list.size());
        assertEquals("[A, B, C]", list.toString());
    }

    @Test
    public void test_remove_first_and_last() {
        list.addFirst("C");
        list.addFirst("B");
        list.addFirst("A");
        assertEquals(3, list.size());

        list.removeFirst();
        assertEquals(2, list.size());
        assertEquals("B", list.getFirst());
    }

    @Test
    public void test_remove_object_returns_true() {
        list.addFirst("C");
        list.addFirst("B");
        list.addFirst("A");
        assertEquals(3, list.size());

        assertTrue(list.remove("B"));
        assertEquals(2, list.size());
    }

    @Test
    public void test_remove_object_returns_false() {
        list.addFirst("C");
        list.addFirst("B");
        list.addFirst("A");
        assertEquals(3, list.size());

        assertFalse(list.remove("D"));
        assertEquals(3, list.size());
    }

    @Test
    public void test_get_first_and_last() {
        list.addFirst("C");
        list.addFirst("B");
        list.addFirst("A");

        assertEquals("A", list.getFirst());
        assertEquals("C", list.getLast());
    }

    @Test
    public void test_get_element_by_index() {
        list.addFirst("C");
        list.addFirst("B");
        list.addFirst("A");

        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
    }

    @Test
    public void test_array_is_empty_after_clear() {
        list.addFirst("B");
        list.addFirst("A");
        list.clear();

        assertTrue(list.isEmpty());
    }

    @Test
    public void test_is_empty_new_array() {
        assertTrue(list.isEmpty());
    }

    @Test
    public void test_array_with_data_is_empty_return_false() {
        list.addFirst("B");
        list.addFirst("A");

        assertFalse(list.isEmpty());
    }

    @Test
    public void test_list_to_string() {
        list.addFirst("C");
        list.addFirst("B");
        list.addFirst("A");

        assertEquals("[A, B, C]", list.toString());
    }

    @Test
    public void test_empty_array_to_string() {
        assertEquals("[]", list.toString());
    }

}
