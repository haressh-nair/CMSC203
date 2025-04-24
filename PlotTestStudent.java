/*
 * Class: CMSC203 CRN33083
 * Instructor:Professor Monshi
 * Description: JUnit tests for the Plot Class.
 * Due: 04/23/2025
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Haressh Nair
 */


import static org.junit.Assert.*;
import org.junit.Test;

public class PlotTestStudent {

    @Test
    public void testDefaultConstructor() {
        Plot plot = new Plot();
        assertEquals(0, plot.getX());
        assertEquals(0, plot.getY());
        assertEquals(1, plot.getWidth());
        assertEquals(1, plot.getDepth());
    }

    @Test
    public void testParameterizedConstructor() {
        Plot plot = new Plot(1, 2, 3, 4);
        assertEquals(1, plot.getX());
        assertEquals(2, plot.getY());
        assertEquals(3, plot.getWidth());
        assertEquals(4, plot.getDepth());
    }

    @Test
    public void testCopyConstructor() {
        Plot original = new Plot(5, 6, 7, 8);
        Plot copy = new Plot(original);
        assertEquals(5, copy.getX());
        assertEquals(6, copy.getY());
        assertEquals(7, copy.getWidth());
        assertEquals(8, copy.getDepth());
    }

    @Test
    public void testSettersAndGetters() {
        Plot plot = new Plot();
        plot.setX(2);
        plot.setY(3);
        plot.setWidth(10);
        plot.setDepth(5);
        assertEquals(2, plot.getX());
        assertEquals(3, plot.getY());
        assertEquals(10, plot.getWidth());
        assertEquals(5, plot.getDepth());
    }

    @Test
    public void testOverlaps() {
        Plot a = new Plot(0, 0, 4, 4);
        Plot b = new Plot(2, 2, 3, 3);
        assertTrue(a.overlaps(b));
    }

    @Test
    public void testDoesNotOverlap() {
        Plot a = new Plot(0, 0, 4, 4);
        Plot b = new Plot(5, 5, 2, 2);
        assertFalse(a.overlaps(b));
    }

    @Test
    public void testEncompasses() {
        Plot a = new Plot(0, 0, 10, 10);
        Plot b = new Plot(2, 2, 3, 3);
        assertTrue(a.encompasses(b));
    }

    @Test
    public void testToString() {
        Plot plot = new Plot(1, 2, 3, 4);
        assertEquals("1,2,3,4", plot.toString());
    }
}
