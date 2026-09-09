import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.example.Factorial;

@DisplayName("Автотест по факториалу")

class FactorialTest {

    @Test
    void zero() {
        assertEquals(1, Factorial.calculate(0));
    }

    @Test
    void five() {
        assertEquals(120, Factorial.calculate(5));
    }

    @Test
    void negative() {
        assertThrows(
                IllegalArgumentException.class,
                () -> Factorial.calculate(-1)
        );
    }
}