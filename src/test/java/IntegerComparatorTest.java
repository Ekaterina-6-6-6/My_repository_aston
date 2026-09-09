import org.testng.annotations.Test;

import static org.testng.Assert.*;

import org.example.IntegerComparator;

public class IntegerComparatorTest {

    @Test
    public void greater() {
        assertTrue(IntegerComparator.compare(5, 3) > 0);
    }

    @Test
    public void equal() {
        assertEquals(IntegerComparator.compare(5, 5), 0);
    }

    @Test
    public void less() {
        assertTrue(IntegerComparator.compare(3, 5) < 0);
    }
}