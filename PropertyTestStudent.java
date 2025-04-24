/*
 * Class: CMSC203 CRN33083
 * Instructor:Professor Monshi
 * Description: JUnit tests for the Property Class.
 * Due: 04/23/2025
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Haressh Nair
 */
import static org.junit.Assert.*;
import org.junit.Test;

public class PropertyTestStudent {

    @Test
    public void testDefaultConstructor() {
        Property prop = new Property();
        assertEquals("", prop.getPropertyName());
        assertEquals("", prop.getCity());
        assertEquals("", prop.getOwner());
        assertEquals(0.0, prop.getRentAmount(), 0.001);
    }

    @Test
    public void testParameterizedConstructor() {
        Property prop = new Property("Lakehouse", "Austin", 3500.00, "Alice");
        assertEquals("Lakehouse", prop.getPropertyName());
        assertEquals("Austin", prop.getCity());
        assertEquals("Alice", prop.getOwner());
        assertEquals(3500.00, prop.getRentAmount(), 0.001);
    }

    @Test
    public void testFullConstructorWithPlot() {
        Property prop = new Property("Loft", "NYC", 5000.00, "Bob", 1, 2, 3, 4);
        assertEquals("Loft", prop.getPropertyName());
        assertEquals("NYC", prop.getCity());
        assertEquals("Bob", prop.getOwner());
        assertEquals(5000.00, prop.getRentAmount(), 0.001);
        assertEquals("1,2,3,4", prop.getPlot().toString());
    }

    @Test
    public void testCopyConstructor() {
        Property original = new Property("Villa", "Miami", 4000.0, "Carol", 2, 3, 4, 5);
        Property copy = new Property(original);
        assertEquals(original.toString(), copy.toString());
        assertEquals(original.getPlot().toString(), copy.getPlot().toString());
    }

    @Test
    public void testSettersAndGetters() {
        Property prop = new Property();
        prop.setCity("Chicago");
        prop.setOwner("Dan");
        prop.setPropertyName("Townhouse");
        prop.setRentAmount(2700.0);
        prop.setPlot(3, 3, 2, 2);
        assertEquals("Chicago", prop.getCity());
        assertEquals("Dan", prop.getOwner());
        assertEquals("Townhouse", prop.getPropertyName());
        assertEquals(2700.0, prop.getRentAmount(), 0.001);
        assertEquals("3,3,2,2", prop.getPlot().toString());
    }

    @Test
    public void testToString() {
        Property prop = new Property("Cabin", "Denver", 2200.0, "Eve");
        assertEquals("Cabin,Denver,Eve,2200.0", prop.toString());
    }
}
