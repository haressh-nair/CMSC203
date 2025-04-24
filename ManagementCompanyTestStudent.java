/*
 * Class: CMSC203 CRN33083
 * Instructor:Professor Monshi
 * Description: JUnit tests for the Management Company Class.
 * Due: 04/23/2025
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Haressh Nair
 */

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ManagementCompanyTestStudent {

    private ManagementCompany company;

    @Before
    public void setUp() {
        company = new ManagementCompany("EstateCorp", "987654321", 12.5, 0, 0, 10, 10);
    }

    @Test
    public void testConstructorValues() {
        assertEquals("EstateCorp", company.getName());
        assertEquals(10, company.getPlot().getWidth());
        assertEquals(10, company.getPlot().getDepth());
    }

    @Test
    public void testAddPropertySuccessfully() {
        int result = company.addProperty(new Property("Green Villa", "Greenville", 1450.0, "Mason", 1, 1, 2, 2));
        assertEquals(0, result);
    }

    @Test
    public void testAddTooManyProperties() {
        for (int i = 0; i < ManagementCompany.MAX_PROPERTY; i++) {
            company.addProperty(new Property("P" + i, "Loc" + i, 1000 + i, "Owner" + i, i, i, 1, 1));
        }
        int result = company.addProperty(new Property("ExtraProp", "Overflow", 2500.0, "OverflowOwner", 5, 5, 1, 1));
        assertEquals(-1, result);
    }

    @Test
    public void testAddNullProperty() {
        int result = company.addProperty(null);
        assertEquals(-2, result);
    }

    @Test
    public void testAddPropertyOutOfBounds() {
        Property oversized = new Property("Huge Lot", "Edgeville", 3000.0, "Tim", 8, 8, 5, 5);
        int result = company.addProperty(oversized);
        assertEquals(-3, result);
    }

    @Test
    public void testAddOverlappingProperty() {
        company.addProperty(new Property("Block A", "Metro", 1100.0, "Alice", 1, 1, 3, 3));
        Property conflict = new Property("Block B", "Metro", 1200.0, "Bob", 2, 2, 2, 2);
        int result = company.addProperty(conflict);
        assertEquals(-4, result);
    }

    @Test
    public void testCalculateTotalRent() {
        company.addProperty(new Property("Cottage 1", "Woodland", 1100.0, "Ella", 1, 1, 2, 2));
        company.addProperty(new Property("Cottage 2", "Woodland", 1150.0, "Noah", 4, 4, 2, 2));
        assertEquals(2250.0, company.getTotalRent(), 0.01);
    }

    @Test
    public void testGetHighestRentPropertyName() {
        company.addProperty(new Property("Studio A", "Midtown", 1000.0, "Tom", 0, 0, 2, 2));
        company.addProperty(new Property("Penthouse B", "Midtown", 1999.0, "Jerry", 3, 3, 2, 2));
        assertEquals("Penthouse B", company.getHighestRentProperty().getPropertyName());
    }

    @Test
    public void testFormattedToStringOutput() {
        Property testProp = new Property("Beachfront", "Oceanview", 2613.0, "Sunny Sam", 2, 5, 2, 2);
        ManagementCompany demo = new ManagementCompany("CoastalMgmt", "222333444", 6.0, 0, 0, 10, 10);
        demo.addProperty(testProp);

        String expectedOutput = "List of the properties for CoastalMgmt, taxID: 222333444\n"
                + "______________________________________________________\n"
                + "Beachfront,Oceanview,Sunny Sam,2613.0\n"
                + "______________________________________________________\n"
                + "\n"
                + " total management Fee: 156.78";

        assertEquals(expectedOutput.trim(), demo.toString().trim());
    }
}

