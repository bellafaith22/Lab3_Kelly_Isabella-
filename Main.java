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



import java.util.Scanner;
import java.util.Random;

public class WordGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] wordList = {"python", "java", "javascript", "ruby", "swift", "kotlin"};

        while (true) {
            // Step 1: Choose a random word from the list
            Random random = new Random();
            String wordToGuess = wordList[random.nextInt(wordList.length)];
            char[] guessedWord = new char[wordToGuess.length()];
            for (int i = 0; i < wordToGuess.length(); i++) {
                guessedWord[i] = '_'; // Initial state of the word (all letters are hidden)
            }

            int tries = 6; // Number of tries allowed
            boolean wordGuessed = false;
            String guessedLetters = ""; // To track guessed letters

            System.out.println("Welcome to the Word Guessing Game!");
            System.out.println("I'm thinking of a word. It has " + wordToGuess.length() + " letters.");
            System.out.println("You have " + tries + " tries to guess the word.");
            System.out.println("Try to guess one letter at a time.");
            System.out.println("Word: " + String.valueOf(guessedWord));

            // Step 2: Start the game loop
            while (tries > 0 && !wordGuessed) {
                System.out.print("Enter a letter: ");
                String input = scanner.nextLine().toLowerCase();

                // Input validation
                if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                    System.out.println("Please enter a single letter.");
                    continue;
                }

                char guess = input.charAt(0);

                // Check if the letter has already been guessed
                if (guessedLetters.indexOf(guess) != -1) {
                    System.out.println("You already guessed the letter '" + guess + "'. Try another one.");
                    continue;
                }

                guessedLetters += guess; // Add the guessed letter to the list of guessed letters

                // Step 3: Check if the guessed letter is in the word
                boolean correctGuess = false;
                for (int i = 0; i < wordToGuess.length(); i++) {
                    if (wordToGuess.charAt(i) == guess) {
                        guessedWord[i] = guess; // Reveal the letter in the guessed word
                        correctGuess = true;
                    }
                }

                if (correctGuess) {
                    System.out.println("Good guess! The letter '" + guess + "' is in the word.");
                } else {
                    tries--; // Deduct a try if the guess is wrong
                    System.out.println("Nope! The letter '" + guess + "' is not in the word. You have " + tries + " tries left.");
                }

                // Show the current state of the word
                System.out.println("Word: " + String.valueOf(guessedWord));

                // Check if the word has been guessed
                wordGuessed = true;
                for (char c : guessedWord) {
                    if (c == '_') {
                        wordGuessed = false;
                        break;
                    }
                }
            }

            // Step 4: End of game (win or lose)
            if (wordGuessed) {
                System.out.println("Congratulations! You guessed the word: " + wordToGuess);
            } else {
                System.out.println("You lost! The word was: " + wordToGuess);
            }

            // Step 5: Ask the user if they want to play again
            System.out.print("Do you want to play again? (Y/N): ");
            String playAgain = scanner.nextLine().toUpperCase();
            if (!playAgain.equals("Y")) {
                System.out.println("Thanks for playing!");
                break;
            }
        }

        scanner.close();
    }
}


import java.util.Scanner;
import java.util.Random;

public class WordGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] wordList = {"python", "java", "javascript", "ruby", "swift", "kotlin"};

        while (true) {
            // Step 1: Choose a random word from the list
            Random random = new Random();
            String wordToGuess = wordList[random.nextInt(wordList.length)];
            char[] guessedWord = new char[wordToGuess.length()];
            for (int i = 0; i < wordToGuess.length(); i++) {
                guessedWord[i] = '_'; // Initial state of the word (all letters are hidden)
            }

            int tries = 6; // Number of tries allowed
            boolean wordGuessed = false;
            String guessedLetters = ""; // To track guessed letters

            System.out.println("Welcome to the Word Guessing Game!");
            System.out.println("I'm thinking of a word. It has " + wordToGuess.length() + " letters.");
            System.out.println("You have " + tries + " tries to guess the word.");
            System.out.println("Try to guess one letter at a time.");
            System.out.println("Word: " + String.valueOf(guessedWord));

            // Step 2: Start the game loop
            while (tries > 0 && !wordGuessed) {
                System.out.print("Enter a letter: ");
                String input = scanner.nextLine().toLowerCase();

                // Input validation
                if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                    System.out.println("Please enter a single letter.");
                    continue;
                }

                char guess = input.charAt(0);

                // Check if the letter has already been guessed
                if (guessedLetters.indexOf(guess) != -1) {
                    System.out.println("You already guessed the letter '" + guess + "'. Try another one.");
                    continue;
                }

                guessedLetters += guess; // Add the guessed letter to the list of guessed letters

                // Step 3: Check if the guessed letter is in the word
                boolean correctGuess = false;
                for (int i = 0; i < wordToGuess.length(); i++) {
                    if (wordToGuess.charAt(i) == guess) {
                        guessedWord[i] = guess; // Reveal the letter in the guessed word
                        correctGuess = true;
                    }
                }

                if (correctGuess) {
                    System.out.println("Good guess! The letter '" + guess + "' is in the word.");
                } else {
                    tries--; // Deduct a try if the guess is wrong
                    System.out.println("Nope! The letter '" + guess + "' is not in the word. You have " + tries + " tries left.");
                }

                // Show the current state of the word
                System.out.println("Word: " + String.valueOf(guessedWord));

                // Check if the word has been guessed
                wordGuessed = true;
                for (char c : guessedWord) {
                    if (c == '_') {
                        wordGuessed = false;
                        break;
                    }
                }
            }

            // Step 4: End of game (win or lose)
            if (wordGuessed) {
                System.out.println("Congratulations! You guessed the word: " + wordToGuess);
            } else {
                System.out.println("You lost! The word was: " + wordToGuess);
            }

            // Step 5: Ask the user if they want to play again
            System.out.print("Do you want to play again? (Y/N): ");
            String playAgain = scanner.nextLine().toUpperCase();
            if (!playAgain.equals("Y")) {
                System.out.println("Thanks for playing!");
                break;
            }
        }

        scanner.close();
    }
}
