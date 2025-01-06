import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class TestArrayDeque {
    @org.junit.Test
    public void testGet() {
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        arr.addLast(10);
        arr.addLast(20);
        arr.addLast(30);
        int output1 = arr.get(0);
        int output2 = arr.get(1);
        int output3 = arr.get(2);

        assertEquals(output1, 10);
        assertEquals(output2, 20);
        assertEquals(output3, 30);
    }

    @org.junit.Test
    public void addLastTest() {
        ArrayDeque<String> arr1 = new ArrayDeque<>();
        arr1.addLast("hello");
        arr1.addLast("hi");
        arr1.addLast("nihao");
        arr1.addLast("bye");
        String output1 = arr1.get(0);
        String output2 = arr1.get(1);
        String output3 = arr1.get(2);
        String output4 = arr1.get(3);

        assertEquals(output1, "hello");
        assertEquals(output2, "hi");
        assertEquals(output3, "nihao");
        assertEquals(output4, "bye");
    }

    @org.junit.Test
    public void addFirstTest() {
        ArrayDeque<String> arr1 = new ArrayDeque<>();
        arr1.addFirst("hello");
        arr1.addFirst("hi");
        arr1.addFirst("nihao");
        arr1.addFirst("bye");
        String output4 = arr1.get(0);
        String output3 = arr1.get(1);
        String output2 = arr1.get(2);
        String output1 = arr1.get(3);

        assertEquals(output1, "hello");
        assertEquals(output2, "hi");
        assertEquals(output3, "nihao");
        assertEquals(output4, "bye");
    }

    @org.junit.Test
    public void testSize() {
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        assertEquals(arr.size(), 0);

        arr.addFirst(10);
        assertEquals(arr.size(), 1);

        arr.addLast(20);
        assertEquals(arr.size(), 2);

        arr.addFirst(30);
        assertEquals(arr.size(), 3);
    }

    @Test
    public void testResize() {
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) arr.addLast(i);

        List<Integer> list = arr.toList();
        assertEquals(10, list.size());

        for (int i = 0; i < 10; i++) {
            assertEquals(Integer.valueOf(i), list.get(i));
        }
    }


    @Test
    public void testRemoveLast() {
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        arr.addFirst(10);
        arr.addLast(20);
        arr.addLast(30);
        arr.addLast(40);

        int removed = arr.removeLast();
        assertEquals(40, removed);
        assertEquals(3, arr.size());
        assertEquals(Integer.valueOf(10), arr.get(0));
        assertEquals(Integer.valueOf(20), arr.get(1));
        assertEquals(Integer.valueOf(30), arr.get(2));

        removed = arr.removeLast();
        assertEquals(30, removed);
        assertEquals(2, arr.size());
        assertEquals(Integer.valueOf(10), arr.get(0));
        assertEquals(Integer.valueOf(20), arr.get(1));
    }
}
