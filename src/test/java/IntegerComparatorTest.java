import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.example.IntegerComparator;

@DisplayName("Автотест по сравнению чисел")

class IntegerComparatorTest {

    @Test
    void greater() {
        assertTrue(IntegerComparator.compare(5, 3) > 0);
    }

    @Test
    void equal() {
        assertEquals(0, IntegerComparator.compare(5, 5));
    }

    @Test
    void less() {
        assertTrue(IntegerComparator.compare(3, 5) < 0);
    }
}