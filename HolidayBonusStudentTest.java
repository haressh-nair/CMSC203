/*
 * Class: CMSC203 CRN33083
 * Instructor:Professor Monshi
 * Description: JUnit test cases for each method in HolidayBonus class.
 * Due: 04/02/2025
 * Platform/compiler: ECLIPSE IDE
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: HARESSH NAIR
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class HolidayBonusStudentTest {

    @Test
    public void testCalculateHolidayBonus() {
        double[][] data = {
            {1000, 2000, 3000},
            {4000, 1000},
            {3000, 3000, 3000}
        };

        double[] expected = {
            HolidayBonus.OTHER_BONUS + HolidayBonus.LOW_BONUS + HolidayBonus.HIGH_BONUS, //Would equal 8000    
            HolidayBonus.LOW_BONUS + HolidayBonus.HIGH_BONUS,                            //Would equal 6000  
            HolidayBonus.HIGH_BONUS + HolidayBonus.OTHER_BONUS + HolidayBonus.HIGH_BONUS //Would equal 12000  
        };

        double[] result = HolidayBonus.calculateHolidayBonus(data);
        for (int i = 0; i < result.length; i++) {
            assertEquals(expected[i], result[i], 0.001, "Bonus mismatch at index " + i);
        }
    }

    @Test
    public void testCalculateTotalHolidayBonus() {
        double[][] data = {
            {1000, 2000, 3000},
            {4000, 1000},
            {3000, 3000, 3000}
        };

        double expected =
            (HolidayBonus.OTHER_BONUS + HolidayBonus.LOW_BONUS + HolidayBonus.HIGH_BONUS) + 
            (HolidayBonus.LOW_BONUS + HolidayBonus.HIGH_BONUS) +                          
            (HolidayBonus.HIGH_BONUS + HolidayBonus.OTHER_BONUS + HolidayBonus.HIGH_BONUS); 

        assertEquals(expected, HolidayBonus.calculateTotalHolidayBonus(data), 0.001, "Total holiday bonus incorrect");
    }
}
