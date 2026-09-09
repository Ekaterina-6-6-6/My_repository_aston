import org.testng.annotations.Test;

import static org.testng.Assert.*;

import org.example.TriangleArea;

public class TriangleAreaTest {

    @Test
    public void area() {
        assertEquals(
                TriangleArea.calculate(6, 4),
                12.0,
                0.000001
        );
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void invalidBase() {
        TriangleArea.calculate(0, 4);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void invalidHeight() {
        TriangleArea.calculate(6, -1);
    }
}