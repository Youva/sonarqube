import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RectangleTest {

    @Test
    void testConstructorAndGetters() {
        Rectangle rect = new Rectangle(5.0, 3.0);

        assertEquals(5.0, rect.getWidth(), "Width should be 5.0");
        assertEquals(3.0, rect.getHeight(), "Height should be 3.0");
        assertEquals(15.0, rect.getArea(), "Area should be 15.0");
        assertEquals(16.0, rect.getPerimeter(), "Perimeter should be 16.0");
    }

    @Test
    void testSetters() {
        Rectangle rect = new Rectangle();

        rect.setWidth(10.0);
        rect.setHeight(4.0);

        // Expectations
        assertEquals(10.0, rect.getWidth(), "Width should be 10.0");
        assertEquals(4.0, rect.getHeight(), "Height should be 4.0");
        assertEquals(40.0, rect.getArea(), "Area should be 40.0");
        assertEquals(28.0, rect.getPerimeter(), "Perimeter should be 28.0");
    }

    @Test
    void testNegativeWidth() {
        Rectangle rect = new Rectangle();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            rect.setWidth(-5.0);
        });

        assertEquals("Width cannot be negative.", exception.getMessage());
    }

    @Test
    void testNegativeHeight() {
        Rectangle rect = new Rectangle();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            rect.setHeight(-3.0);
        });

        assertEquals("Height cannot be negative.", exception.getMessage());
    }

    @Test
    void testNegativeValuesInConstructor() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Rectangle(-5.0, -3.0);
        });

        assertEquals("Width and height cannot be negative.", exception.getMessage());
    }
}
