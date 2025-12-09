package NumberSequence;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int totalScore = 0; // Score based on correct guesses
        boolean playAgain = true;

        System.out.println("🎮 Welcome to the Number Guessing Game!");

        while (playAgain) {

            int randomNumber = rand.nextInt(100) + 1; // Random 1–100
            int attempts = 0;
            int maxAttempts = 7;
            boolean guessedCorrectly = false;

            System.out.println("\nI have generated a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts. Good luck!");

            while (attempts < maxAttempts) {
                System.out.print("\nEnter your guess: ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == randomNumber) {
                    System.out.println("🎉 Correct! You guessed the number in " + attempts + " attempts.");
                    totalScore += (maxAttempts - attempts + 1); // Higher score for fewer attempts
                    guessedCorrectly = true;
                    break;
                } else if (guess > randomNumber) {
                    System.out.println("📉 Too High! Try Again.");
                } else {
                    System.out.println("📈 Too Low! Try Again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("\n❌ You ran out of attempts!");
                System.out.println("The correct number was: " + randomNumber);
            }

            System.out.println("\nYour current score: " + totalScore);

            // Ask for another round
            System.out.print("\nDo you want to play again? (yes/no): ");
            String choice = sc.next().toLowerCase();

            playAgain = choice.equals("yes");
        }

        System.out.println("\n🏆 Final Score: " + totalScore);
        System.out.println("Thanks for playing! 😊");

        sc.close();
    }
}
