/*
 * Class: CMSC203 CRN33083
 * Instructor:Professor Monshi
 * Description: Two Dimensional Ragged Array for multiple companies and their sales.
 * Due: 04/02/2025
 * Platform/compiler:ECLIPSE IDE
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: HARESSH NAIR
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {
	
    //Reads a file and creates a two-dimensional ragged array of doubles.
    public static double[][] readFile(File file) throws FileNotFoundException {
        ArrayList<double[]> list = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.length() == 0) continue;
            String[] tokens = line.split("\\s+");
            double[] row = new double[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                row[i] = Double.parseDouble(tokens[i]);
            }
            list.add(row);
        }
        scanner.close();
        double[][] array = new double[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    //Writes the two-dimensional ragged array to a file. Each row is written on a new line with numbers separated by spaces.
    public static void writeToFile(double[][] data, File outputFile) throws IOException {
        PrintWriter print = new PrintWriter(new FileWriter(outputFile));
        for (double[] row : data) {
            for (double d : row) {
                print.print(d + " ");
            }
            print.println();
        }
        print.close();
    }
    
	
    //Returns the total of all elements in the array.
    public static double getTotal(double[][] data) {
        double total = 0;
        for (double[] row : data) {
            for (double d : row) {
                total += d;
            }
        }
        return total;
    }
    
    //Returns the average of all elements in the array.
    public static double getAverage(double[][] data) {
        double total = 0;
        int count = 0;
        for (double[] row : data) {
            for (double d : row) {
                total += d;
                count++;
            }
        }
        return count == 0 ? 0 : total / count;
    }
    
    //Returns the total of the specified row.
    public static double getRowTotal(double[][] data, int row) {
        if (row < 0 || row >= data.length)
            return 0;
        double sum = 0;
        for (double d : data[row]) {
            sum += d;
        }
        return sum;
    }
    
    
    
    //Returns the total of the specified column.
    public static double getColumnTotal(double[][] data, int col) {
        double sum = 0;
        for (double[] row : data) {
            if (col < row.length) {
                sum += row[col];
            }
        }
        return sum;
    }
    
    //Returns the highest element in the row.
    public static double getHighestInRow(double[][] data, int row) {
        if (row < 0 || row >= data.length || data[row].length == 0)
            throw new IllegalArgumentException("Invalid row index");
        double max = data[row][0];
        for (int j = 1; j < data[row].length; j++) {
            if (data[row][j] > max)
                max = data[row][j];
        }
        return max;
    }
    
    //Returns the index of the highest element in the specified row.
    public static int getHighestInRowIndex(double[][] data, int row) {
        if (row < 0 || row >= data.length || data[row].length == 0)
            throw new IllegalArgumentException("Invalid row index");
        double max = data[row][0];
        int index = 0;
        for (int j = 1; j < data[row].length; j++) {
            if (data[row][j] > max) {
                max = data[row][j];
                index = j;
            }
        }
        return index;
    }
    
    //Returns the lowest element in the specified row.
    public static double getLowestInRow(double[][] data, int row) {
        if (row < 0 || row >= data.length || data[row].length == 0)
            throw new IllegalArgumentException("Invalid row index");
        double min = data[row][0];
        for (int j = 1; j < data[row].length; j++) {
            if (data[row][j] < min)
                min = data[row][j];
        }
        return min;
    }

    
    //Returns the index of the lowest element in the specified row.
    public static int getLowestInRowIndex(double[][] data, int row) {
        if (row < 0 || row >= data.length || data[row].length == 0)
            throw new IllegalArgumentException("Invalid row index");
        double min = data[row][0];
        int index = 0;
        for (int j = 1; j < data[row].length; j++) {
            if (data[row][j] < min) {
                min = data[row][j];
                index = j;
            }
        }
        return index;
    }
    
    //Returns the highest element in the specified column.
    public static double getHighestInColumn(double[][] data, int col) {
        boolean found = false;
        double max = 0;
        for (double[] row : data) {
            if (col < row.length) {
                if (!found) {
                    max = row[col];
                    found = true;
                } else if (row[col] > max) {
                    max = row[col];
                }
            }
        }
        return max;
    }
    
    //Returns the row index of the highest element in the specified column. 
    public static int getHighestInColumnIndex(double[][] data, int col) {
        boolean found = false;
        double max = 0;
        int index = -1;
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length) {
                if (!found) {
                    max = data[i][col];
                    index = i;
                    found = true;
                } else if (data[i][col] > max) {
                    max = data[i][col];
                    index = i;
                }
            }
        }
        return index;
    }
    
    //Returns the lowest element in the specified column.
    public static double getLowestInColumn(double[][] data, int col) {
        boolean found = false;
        double min = 0;
        for (double[] row : data) {
            if (col < row.length) {
                if (!found) {
                    min = row[col];
                    found = true;
                } else if (row[col] < min) {
                    min = row[col];
                }
            }
        }
        return min;
    }
    
    //Returns the row index of the lowest element in the specified column.
    public static int getLowestInColumnIndex(double[][] data, int col) {
        boolean found = false;
        double min = 0;
        int index = -1;
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length) {
                if (!found) {
                    min = data[i][col];
                    index = i;
                    found = true;
                } else if (data[i][col] < min) {
                    min = data[i][col];
                    index = i;
                }
            }
        }
        return index;
    }    
    
    //Returns the highest element in the whole two dim ragged array.
    public static double getHighestInArray(double[][] data) {
        boolean found = false;
        double max = 0;
        for (double[] row : data) {
            for (double x : row) {
                if (!found) {
                    max = x;
                    found = true;
                } else if (x > max) {
                    max = x;
                }
            }
        }
        return max;
    }
    
    
    
    //Returns the lowest element in the entire two-dimensional array.
    public static double getLowestInArray(double[][] data) {
        boolean found = false;
        double min = 0;
        for (double[] row : data) {
            for (double d : row) {
                if (!found) {
                    min = d;
                    found = true;
                } else if (d < min) {
                    min = d;
                }
            }
        }
        return min;
    }
    
    
    
    
    

    
    












}
