import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.example.TriangleArea;

@DisplayName("Автотест по площади треугольника")

class TriangleAreaTest {

    @Test
    void area() {
        assertEquals(
                12.0,
                TriangleArea.calculate(6, 4),
                0.000001
        );
    }

    @Test
    void invalidBase() {
        assertThrows(
                IllegalArgumentException.class,
                () -> TriangleArea.calculate(0, 4)
        );
    }

    @Test
    void invalidHeight() {
        assertThrows(
                IllegalArgumentException.class,
                () -> TriangleArea.calculate(6, -1)
        );
    }
}