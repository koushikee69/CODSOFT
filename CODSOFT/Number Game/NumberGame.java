import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int lowerLimit = 1;
        int upperLimit = 100;
        int maxAttempts = 4;
        int roundsPlayed = 0;
        int totalAttempts = 0;

        boolean playAgain = true;

        while (playAgain) {
            // Step 1: Generating a random number within the given range
            int secretNumber = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;

            System.out.println("WARNING!!!! You have only 5 attempts to guess the number");

            System.out.println("\nRound " + (roundsPlayed + 1));
            System.out.println("Guess the number between " + lowerLimit + " and " + upperLimit + ".");

            // Step 2
            System.out.print("Enter your guess: ");
            int userGuess = sc.nextInt();

            // Step 3:- Let's compare the user's guess and provide feedback
            if (userGuess == secretNumber) {
                System.out.println(
                        "Congratulations! You guessed the correct number in " + totalAttempts + " attempts.");
                totalAttempts = totalAttempts++;
                break;
            } else if (userGuess < secretNumber) {
                System.out.println("Too low!");
            } else {
                System.out.println("Too high!");
            }

            // Step 4: Now Repeat steps 2 and 3 until the user guesses the correct no.
            for (int attempt = 0; attempt < maxAttempts; attempt++) {
                System.out.print("Enter your guess: ");
                userGuess = sc.nextInt();
                if (userGuess == secretNumber) {
                    System.out.println(
                            "Congratulations! You guessed the correct number in " + (totalAttempts + 1) + " attempts.");
                    totalAttempts += (totalAttempts + 1);
                    break;
                } else if (userGuess < secretNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
                // If the maximum attempts are reached, provide the correct no.
                if (attempt == maxAttempts - 1) {
                    System.out.println("Sorry, you've reached the maximum number of attempts. i.e:- " + maxAttempts
                            + " The correct number was: "
                            + secretNumber);
                }
            }

            // Additionally if the user wants to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = sc.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");

            roundsPlayed++;
        }

        // Step 7: Display the user's score
        System.out.println("\nGame Over!");
        System.out.println("Rounds played: " + roundsPlayed);
        System.out.println("Total attempts: " + totalAttempts);

        sc.close();
    }
}