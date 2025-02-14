package Assignments;
import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ESPGame {
    public static void main(String[] args) {
        boolean end = false;
        int option;
        int numColors = 0;
        int correctGuesses=0;
        Scanner input = new Scanner(System.in);
        final String OPTION_INPUT = "Enter the option: ";
        final String MENU_ONE = "  1- read and display on the screen first 16 names of colors from a file colors.txt, so the player can select one of them names of colors.";
        final String MENU_TWO = "  2- read and display on the screen first 10 names of colors from a file colors.txt, so the player can select one of them names of colors.";
        final String MENU_THREE = "  3- read and display on the screen first 5 names of colors from a file colors.txt, so the player can select one of them names of colors.";
        final String MENU_FOUR = "  4- Exit from a program";

        do {
            System.out.println("CMSC203 Assignment1: Test your ESP skills!");
            System.out.println("Welcome to ESP - extrasensory perception!");
            System.out.println("Would you please choose one of the 4 options from the menu:\n");
            System.out.println(MENU_ONE);
            System.out.println(MENU_TWO);
            System.out.println(MENU_THREE);
            System.out.println(MENU_FOUR);
            System.out.print(OPTION_INPUT);

            while (true) {
                option = input.nextInt();
                if (option == 1) {
                    numColors = 16;
                    break;
                } else if (option == 2) {
                    numColors = 10;
                    break;
                } else if (option == 3) {
                    numColors = 5;
                    break;
                } else if (option == 4) {
                    end = true; // Exit the program
                    break;
                } else {
                    System.out.println("Incorrect option, please try again.");
                    System.out.print(OPTION_INPUT);
                }
            }

            if (end) {
                break; 
            }

            // ask the user for the file name
            System.out.print("Enter the filename: ");
            input.nextLine(); 
            String fileName = input.nextLine();

            // Check if it is the correct file, and then display number of colors and each color.
            try {
                File file = new File(fileName);
                Scanner fileScan = new Scanner(file);
                System.out.println("There are " + numColors + " colors from the file:");

                for (int i = 1; i <= numColors; i++) {
                    if (fileScan.hasNextLine()) {
                        String color = fileScan.nextLine();
                        System.out.println(i + ". " + color);
                    }
                }

                fileScan.close();

                // Randomly select color based on number of color chosen by user.
                Random random = new Random();

                for (int round = 1; round <= 3; round++) {
                    int randomNumber = random.nextInt(numColors) + 1; 
                    String selectedColor = "";

                    fileScan = new Scanner(file);
                    for (int i = 1; i <= randomNumber; i++) {
                        if (fileScan.hasNextLine()) {
                            selectedColor = fileScan.nextLine();
                        }
                    }
                    fileScan.close();

                    System.out.println("\nRound " + round);
                    System.out.println("I am thinking of a color.");
                    System.out.println("Is it one of the list of colors above?");
                    System.out.print("Enter your guess: ");
                    String userGuess = input.next();

                    
                    //Check if the user entered a correct guess or not, and adds it to the number of correct guesses.
                    if (userGuess.equalsIgnoreCase(selectedColor)) {
                        correctGuesses++;
                        System.out.println("Correct! I was thinking of " + selectedColor + ".");
                        correctGuesses++;
                    } else {
                        System.out.println("Incorrect. I was thinking of " + selectedColor + ".");
                    }
                }

                System.out.println("\nGame Over");
                System.out.println("You guessed " + correctGuesses + " out of 3 colors correctly.");

                // Ask if the user wants to continue
                System.out.print("Would you like to continue the game? Type Yes/No: ");
                String proceed = input.next();
                if (!proceed.equals("Yes") && !proceed.equals("yes")) {
                    end = true;
                }

            } catch (FileNotFoundException e) {
                System.out.println("Error: That file was not found. Please make sure try again.");
            }

        } while (end==false);

        // Get user's information and print it in the console.
        System.out.print("Enter your name: ");
        input.nextLine(); 
        String name = input.nextLine();
        System.out.print("Describe yourself: ");
        String description = input.nextLine();
        System.out.print("Due Date (MM/DD/YY): ");
        String dueDate = input.nextLine();
        System.out.print("Date (MM/DD/YY): ");
        String date = input.nextLine();

        // Print user information in the console
        System.out.println("\nUsername: " + name);
        System.out.println("User Description: " + description);
        System.out.println("Due Date: " + dueDate);
        System.out.println("Date: " + date);

        // Save the uses results and information to EspGameResults.txt.
        try (PrintWriter writer = new PrintWriter("EspGameResults.txt")) {
            writer.println("Game Over");
            writer.println("You guessed " + correctGuesses + " out of 3 colors correctly."); 
            writer.println("Due Date: " + dueDate);
            writer.println("Username: " + name);
            writer.println("User Description: " + description);
            writer.println("Date: " + date);
            System.out.println("Results saved to EspGameResults.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Error: Could not save results to the file.");
        }
        input.close();
    }
}