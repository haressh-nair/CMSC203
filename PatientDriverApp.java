
/*
 * Class: CMSC203
 * Instructor:Professor Monshi
 * Description: Main function which takes patient information and displays information.
 * Due: 02/24/2025
 * Platform/compiler:Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Haressh Nair
*/

import java.util.Scanner;

public class PatientDriverApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Collecting patient information
        System.out.println("Please enter the patients first name: ");
        String firstName = scanner.nextLine();

        System.out.println("Please enter the patients middle name: ");
        String middleName = scanner.nextLine();

        System.out.println("Please enter the patients last name: ");
        String lastName = scanner.nextLine();

        System.out.println("Enter Street Address: ");
        String streetAddress = scanner.nextLine();

        System.out.println("Enter City: ");
        String city = scanner.nextLine();

        System.out.println("Enter State: ");
        String state = scanner.nextLine();

        System.out.println("Enter ZIP Code: ");
        String zip = scanner.nextLine();

        System.out.println("Enter Phone Number in the format(012-345-6789): ");
        String phone = scanner.nextLine();

        System.out.println("Enter Emergency Contact Name: ");
        String emergencyName = scanner.nextLine();

        System.out.println("Enter Emergency Contact Phone: ");
        String emergencyPhone = scanner.nextLine();

        // Creating a Patient object
        Patient patient = new Patient(firstName, middleName, lastName, streetAddress, city, state, zip, phone, emergencyName, emergencyPhone);

      //Getting information for procedure 1
        System.out.println("\nEnter information for Procedure 1:");
        System.out.println("Enter Procedure Name: ");
        String proc1Name = scanner.nextLine();
        System.out.println("Enter Procedure Date (MM/DD/YYYY): ");
        String proc1Date = scanner.nextLine();
        System.out.println("Enter Practitioner Name: ");
        String proc1Practitioner = scanner.nextLine();
        System.out.println("Enter Procedure Charges: ");
        double proc1Charges = scanner.nextDouble();
        scanner.nextLine(); 
        Procedure procedure1 = new Procedure(proc1Name, proc1Date, proc1Practitioner, proc1Charges);

      //Getting information for procedure 2
        System.out.println("\nEnter information for Procedure 2:");
        System.out.println("Enter Procedure Name: ");
        String proc2Name = scanner.nextLine();
        System.out.println("Enter Procedure Date (MM/DD/YYYY): ");
        String proc2Date = scanner.nextLine();
        System.out.println("Enter Practitioner Name: ");
        String proc2Practitioner = scanner.nextLine();
        System.out.println("Enter Procedure Charges: ");
        double proc2Charges = scanner.nextDouble();
        scanner.nextLine(); 
        Procedure procedure2 = new Procedure(proc2Name, proc2Date, proc2Practitioner, proc2Charges);
        
        //Getting information for procedure 3
        System.out.println("\nEnter information for Procedure 3:");
        System.out.println("Enter Procedure Name: ");
        String proc3Name = scanner.nextLine();
        System.out.println("Enter Procedure Date (MM/DD/YYYY): ");
        String proc3Date = scanner.nextLine();
        System.out.println("Enter Practitioner Name: ");
        String proc3Practitioner = scanner.nextLine();
        System.out.println("Enter Procedure Charges: ");
        double proc3Charges = scanner.nextDouble();
        scanner.nextLine(); 
        Procedure procedure3 = new Procedure(proc3Name, proc3Date, proc3Practitioner, proc3Charges);

        // Display patient information
        displayPatient(patient);

        //Display the patients procedures
        displayProcedure(procedure1);
        displayProcedure(procedure2);
        displayProcedure(procedure3);

        // Calculate the total charge for all 3 procedures
        double totalCharges = calculateTotalCharges(procedure1, procedure2, procedure3);
        System.out.println("Total Charges: $" + String.format("%,.2f", totalCharges));

        scanner.close();
        
        //Output with name, mc# and due date.
        System.out.println("This program was developed by a Student: Haressh Nair");
        System.out.println("MC# 21195062");
        System.out.println("Due Date: 02/26/2025");
    }
    
    

    // Method that displays patient information
    public static void displayPatient(Patient patient) {
        System.out.println(patient);
    }

    // Method that display procedure information
    public static void displayProcedure(Procedure procedure) {
        System.out.println(procedure);
    }

    // Method that calculates total charges
    public static double calculateTotalCharges(Procedure p1, Procedure p2, Procedure p3) {
        return p1.getProcedureCharges() + p2.getProcedureCharges() + p3.getProcedureCharges();
    }
}
