/*
 * Class: CMSC203 CRN33083
 * Instructor:Professor Monshi
 * Description: JUnit test cases for each method in TwoDimRaggedArrayUtility class.
 * Due: 04/02/2025
 * Platform/compiler: ECLIPSE IDE
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: HARESSH NAIR
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class TwoDimRaggedArrayUtilityStudentTest {

    double[][] testData = {
        {2.5, 4.0, 1.0},      
        {8.8, 3.3},           
        {9.9},                
        {6.7, 0.5, 7.7, 2.2}  
    };

    @Test
    public void testGetTotal() {
        double expected = 2.5 + 4.0 + 1.0 + 8.8 + 3.3 + 9.9 + 6.7 + 0.5 + 7.7 + 2.2;
        assertEquals(expected, TwoDimRaggedArrayUtility.getTotal(testData), 0.001);
    }

    @Test
    public void testGetAverage() {
        int count = 0;
        for (double[] row : testData) count += row.length;
        double avg = TwoDimRaggedArrayUtility.getTotal(testData) / count;
        assertEquals(avg, TwoDimRaggedArrayUtility.getAverage(testData), 0.001);
    }

    @Test
    public void testGetRowTotal() {
        assertEquals(2.5 + 4.0 + 1.0, TwoDimRaggedArrayUtility.getRowTotal(testData, 0), 0.001);
        assertEquals(8.8 + 3.3, TwoDimRaggedArrayUtility.getRowTotal(testData, 1), 0.001);
        assertEquals(9.9, TwoDimRaggedArrayUtility.getRowTotal(testData, 2), 0.001);
        assertEquals(6.7 + 0.5 + 7.7 + 2.2, TwoDimRaggedArrayUtility.getRowTotal(testData, 3), 0.001);
    }

    @Test
    public void testGetColumnTotal() {
        assertEquals(2.5 + 8.8 + 9.9 + 6.7, TwoDimRaggedArrayUtility.getColumnTotal(testData, 0), 0.001);
        assertEquals(4.0 + 3.3 + 0.5, TwoDimRaggedArrayUtility.getColumnTotal(testData, 1), 0.001);
        assertEquals(1.0 + 7.7, TwoDimRaggedArrayUtility.getColumnTotal(testData, 2), 0.001);
        assertEquals(2.2, TwoDimRaggedArrayUtility.getColumnTotal(testData, 3), 0.001);
    }

    @Test
    public void testGetHighestInRow() {
        assertEquals(4.0, TwoDimRaggedArrayUtility.getHighestInRow(testData, 0), 0.001);
        assertEquals(8.8, TwoDimRaggedArrayUtility.getHighestInRow(testData, 1), 0.001);
        assertEquals(9.9, TwoDimRaggedArrayUtility.getHighestInRow(testData, 2), 0.001);
        assertEquals(7.7, TwoDimRaggedArrayUtility.getHighestInRow(testData, 3), 0.001);
    }

    @Test
    public void testGetHighestInRowIndex() {
        assertEquals(1, TwoDimRaggedArrayUtility.getHighestInRowIndex(testData, 0));
        assertEquals(0, TwoDimRaggedArrayUtility.getHighestInRowIndex(testData, 1));
        assertEquals(0, TwoDimRaggedArrayUtility.getHighestInRowIndex(testData, 2));
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInRowIndex(testData, 3));
    }

    @Test
    public void testGetLowestInRow() {
        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInRow(testData, 0), 0.001);
        assertEquals(3.3, TwoDimRaggedArrayUtility.getLowestInRow(testData, 1), 0.001);
        assertEquals(9.9, TwoDimRaggedArrayUtility.getLowestInRow(testData, 2), 0.001);
        assertEquals(0.5, TwoDimRaggedArrayUtility.getLowestInRow(testData, 3), 0.001);
    }

    @Test
    public void testGetLowestInRowIndex() {
        assertEquals(2, TwoDimRaggedArrayUtility.getLowestInRowIndex(testData, 0));
        assertEquals(1, TwoDimRaggedArrayUtility.getLowestInRowIndex(testData, 1));
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(testData, 2));
        assertEquals(1, TwoDimRaggedArrayUtility.getLowestInRowIndex(testData, 3));
    }

    @Test
    public void testGetHighestInColumn() {
        assertEquals(9.9, TwoDimRaggedArrayUtility.getHighestInColumn(testData, 0), 0.001);
        assertEquals(4.0, TwoDimRaggedArrayUtility.getHighestInColumn(testData, 1), 0.001);
        assertEquals(7.7, TwoDimRaggedArrayUtility.getHighestInColumn(testData, 2), 0.001);
        assertEquals(2.2, TwoDimRaggedArrayUtility.getHighestInColumn(testData, 3), 0.001);
    }

    @Test
    public void testGetHighestInColumnIndex() {
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(testData, 0));
        assertEquals(0, TwoDimRaggedArrayUtility.getHighestInColumnIndex(testData, 1));
        assertEquals(3, TwoDimRaggedArrayUtility.getHighestInColumnIndex(testData, 2));
        assertEquals(3, TwoDimRaggedArrayUtility.getHighestInColumnIndex(testData, 3));
    }

    @Test
    public void testGetLowestInColumn() {
        assertEquals(2.5, TwoDimRaggedArrayUtility.getLowestInColumn(testData, 0), 0.001);
        assertEquals(0.5, TwoDimRaggedArrayUtility.getLowestInColumn(testData, 1), 0.001);
        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInColumn(testData, 2), 0.001);
        assertEquals(2.2, TwoDimRaggedArrayUtility.getLowestInColumn(testData, 3), 0.001);
    }

    @Test
    public void testGetLowestInColumnIndex() {
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(testData, 0));
        assertEquals(3, TwoDimRaggedArrayUtility.getLowestInColumnIndex(testData, 1));
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(testData, 2));
        assertEquals(3, TwoDimRaggedArrayUtility.getLowestInColumnIndex(testData, 3));
    }

    @Test
    public void testGetHighestInArray() {
        assertEquals(9.9, TwoDimRaggedArrayUtility.getHighestInArray(testData), 0.001);
    }

    @Test
    public void testGetLowestInArray() {
        assertEquals(0.5, TwoDimRaggedArrayUtility.getLowestInArray(testData), 0.001);
    }

    @Test
    public void testWriteAndReadFile() throws IOException {
        File file = new File("test_output.txt");
        TwoDimRaggedArrayUtility.writeToFile(testData, file);
        double[][] loaded = TwoDimRaggedArrayUtility.readFile(file);
        assertEquals(TwoDimRaggedArrayUtility.getTotal(testData), TwoDimRaggedArrayUtility.getTotal(loaded), 0.001);
        file.delete();
    }
}
