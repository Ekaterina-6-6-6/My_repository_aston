import org.testng.annotations.Test;

import static org.testng.Assert.*;

import org.example.Arithmetic;

public class ArithmeticTest {

    @Test
    public void add() {
        assertEquals(Arithmetic.add(3, 4), 7);
    }

    @Test
    public void subtract() {
        assertEquals(Arithmetic.subtract(3, 4), -1);
    }

    @Test
    public void multiply() {
        assertEquals(Arithmetic.multiply(3, 4), 12);
    }

    @Test
    public void divide() {
        assertEquals(Arithmetic.divide(8, 4), 2);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void divideByZero() {
        Arithmetic.divide(8, 0);
    }
}