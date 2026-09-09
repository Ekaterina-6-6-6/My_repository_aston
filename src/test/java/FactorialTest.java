import org.testng.annotations.Test;

import static org.testng.Assert.*;

import org.example.Factorial;

public class FactorialTest {

    @Test
    public void zero() {
        assertEquals(Factorial.calculate(0), 1L);
    }

    @Test
    public void five() {
        assertEquals(Factorial.calculate(5), 120L);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void negative() {
        Factorial.calculate(-1);
    }
}