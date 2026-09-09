import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.example.Arithmetic;

@DisplayName("Автотест по арфметике")

class ArithmeticTest {

    @Test
    void add() {
        assertEquals(7, Arithmetic.add(3, 4));
    }

    @Test
    void subtract() {
        assertEquals(-1, Arithmetic.subtract(3, 4));
    }

    @Test
    void multiply() {
        assertEquals(12, Arithmetic.multiply(3, 4));
    }

    @Test
    void divide() {
        assertEquals(2, Arithmetic.divide(8, 4));
    }

    @Test
    void divideByZero() {
        assertThrows(
                ArithmeticException.class,
                () -> Arithmetic.divide(8, 0)
        );
    }
}