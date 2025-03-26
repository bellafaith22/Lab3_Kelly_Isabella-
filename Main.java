/**
 * Partner Lab 3
 * This file contains methods to run two types of games. Rock, Paper and Scissors, along with a Guessing Game. 
 *
 * @author Isabella Faith Guzmnan (Guessing Game )
 * @author Kelly   (Rock,Paper Scissors)
 */

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) { // Correct method name for program entry

        System.out.println("Hello and welcome!"); // Use println for a new line

        Random rand = new Random();
        String[] choices = { "Rock", "Paper", "Scissors" };
        Scanner scanner = new Scanner(System.in); // Initialize Scanner once
        String playAgain = "";

        do {
            System.out.println("\nEnter your choice: 1. Rock, 2. Paper, 3. Scissors");
            int userChoice = scanner.nextInt();

            if (userChoice < 1 || userChoice > 3) {
                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                continue;
            }

            int computerChoice = rand.nextInt(3) + 1;
            System.out.println("Computer chose: " + choices[computerChoice - 1]);

            if (userChoice == computerChoice) {
                System.out.println("It's a tie!");
            } else {
                boolean userWins = (userChoice == 1 && computerChoice == 3) ||
                        (userChoice == 3 && computerChoice == 2) ||
                        (userChoice == 2 && computerChoice == 1);
                if (userWins) {
                    System.out.println("You win!");
                } else {
                    System.out.println("Computer wins!");
                }
            }

            System.out.print("Do you want to play again? (Y/N): ");
            playAgain = scanner.next().toUpperCase();
        } while (playAgain.equals("Y"));

        scanner.close(); // Close the scanner
    }
}
