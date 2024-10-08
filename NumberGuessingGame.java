import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain; // Variable to track if the user wants to play again
        int totalRounds = 0; // Variable to track total rounds played
        int totalWins = 0; // Variable to track total wins

        do {
            totalRounds++;
            int min = 1;
            int max = 100;
            int attemptsAllowed = 7; // Limit on the number of attempts
            int randomNumber = random.nextInt((max - min) + 1) + min;

            System.out.println("\nWelcome to the Number Guessing Game!");
            System.out.println("I have generated a random number between " + min + " and " + max + ".");
            System.out.println("You have " + attemptsAllowed + " attempts to guess the number.");

            int userGuess;
            boolean guessedCorrectly = false; // Flag to check if guessed correctly

            // Loop until the user guesses correctly or runs out of attempts
            for (int attempts = 0; attempts < attemptsAllowed; attempts++) {
                System.out.print("Enter your guess (" + (attempts + 1) + "/" + attemptsAllowed + "): ");
                userGuess = scanner.nextInt();

                // Compare the user's guess with the generated number
                if (userGuess < randomNumber) {
                    System.out.println("Your guess is too low.");
                } else if (userGuess > randomNumber) {
                    System.out.println("Your guess is too high.");
                } else {
                    guessedCorrectly = true; // User guessed correctly
                    System.out.println("Congratulations! You've guessed the correct number: " + randomNumber);
                    break; // Exit the loop when the guess is correct
                }
            }

            // Check if the user did not guess correctly after all attempts
            if (!guessedCorrectly) {
                System.out.println("Sorry! You've used all your attempts. The correct number was: " + randomNumber);
            } else {
                totalWins++; // Increment wins if guessed correctly
            }

            // Ask if the user wants to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes");

        } while (playAgain);

        // Display the user's score
        System.out.println("\nThanks for playing!");
        System.out.println("Total rounds played: " + totalRounds);
        System.out.println("Total rounds won: " + totalWins);
        System.out.println("Your score: " + totalWins + "/" + totalRounds);

        // Close the scanner
        scanner.close();
    }
}
