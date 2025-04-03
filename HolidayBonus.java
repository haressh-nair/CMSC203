/*
 * Class: CMSC203 CRN33083
 * Instructor:Professor Monshi
 * Description: Holiday Bonuses for each company.
 * Due: 04/02/2025
 * Platform/compiler:ECLIPSE IDE
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: HARESSH NAIR
*/

import java.util.ArrayList;

public class HolidayBonus {

    // Constant bonus amounts.
    static final double HIGH_BONUS = 5000;
    static final double LOW_BONUS = 1000;
    static final double OTHER_BONUS = 2000;

    //Calculates the holiday bonus for each store in the district.
    public static double[] calculateHolidayBonus(double[][] data) {
        int numStores = data.length;
        double[] bonuses = new double[numStores];

        // Determine the maximum number of columns (categories) across all stores.
        int maxColumns = 0;
        for (double[] row : data) {
            if (row.length > maxColumns) {
                maxColumns = row.length;
            }
        }

        // Process each column (category) separately.
        for (int col = 0; col < maxColumns; col++) {
            ArrayList<Integer> eligibleStores = new ArrayList<>();
            // Identify eligible stores (sales > 0) for this category.
            for (int i = 0; i < numStores; i++) {
                if (col < data[i].length && data[i][col] > 0) {
                    eligibleStores.add(i);
                }
            }

            // If no store is eligible, move to the next column.
            if (eligibleStores.size() == 0) {
                continue;
            }
            // If only one store is eligible, award the high bonus.
            if (eligibleStores.size() == 1) {
                int storeIndex = eligibleStores.get(0);
                bonuses[storeIndex] += HIGH_BONUS;
            } else {
                // Multiple eligible stores: find the highest and lowest sales.
                double highest = Double.NEGATIVE_INFINITY;
                double lowest = Double.POSITIVE_INFINITY;
                for (int i : eligibleStores) {
                    double sale = data[i][col];
                    if (sale > highest) highest = sale;
                    if (sale < lowest) lowest = sale;
                }
                // If all eligible sales are equal, award the high bonus to each.
                if (highest == lowest) {
                    for (int i : eligibleStores) {
                        bonuses[i] += HIGH_BONUS;
                    }
                } else {
                    // Award bonuses based on performance.
                    for (int i : eligibleStores) {
                        double sale = data[i][col];
                        if (sale == highest) {
                            bonuses[i] += HIGH_BONUS;
                        } else if (sale == lowest) {
                            bonuses[i] += LOW_BONUS;
                        } else {
                            bonuses[i] += OTHER_BONUS;
                        }
                    }
                }
            }
        }
        return bonuses;
    }

    //Calculates the total of all holiday bonuses for the district.Returns the total bonus value.
    public static double calculateTotalHolidayBonus(double[][] data) {
        double[] bonuses = calculateHolidayBonus(data);
        double total = 0;
        for (double bonus : bonuses) {
            total += bonus;
        }
        return total;
    }
}
