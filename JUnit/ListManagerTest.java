import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class ListManagerTest {
    private ListManager listManager;
    private List<Integer> testList;

    @BeforeEach
    void setUp() {
        listManager = new ListManager();
        testList = new ArrayList<>();
    }

    @Test
    void testAddElement() {
        listManager.addElement(testList, 5);
        listManager.addElement(testList, 10);
        assertEquals(2, testList.size());
        assertTrue(testList.contains(5));
        assertTrue(testList.contains(10));
    }

    @Test
    void testRemoveElement() {
        testList.add(5);
        testList.add(10);
        assertTrue(listManager.removeElement(testList, 5));
        assertEquals(1, testList.size());
        assertFalse(testList.contains(5));

        assertFalse(listManager.removeElement(testList, 99)); // Element not in list
    }

    @Test
    void testGetSize() {
        assertEquals(0, listManager.getSize(testList));
        testList.add(1);
        testList.add(2);
        assertEquals(2, listManager.getSize(testList));
    }
}
