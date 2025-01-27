import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int targetNumber = random.nextInt(100) + 1;
            int maxAttempts = 10;
            int attempts = 0;
            boolean hasWon = false;

            System.out.println("I have generated a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == targetNumber) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    totalScore += maxAttempts - attempts + 1;  // Score based on remaining attempts
                    hasWon = true;
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            if (!hasWon) {
                System.out.println("Sorry, you've used all your attempts. The number was " + targetNumber + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");

            if (!playAgain) {
                System.out.println("Thank you for playing! Your total score is " + totalScore + ".");
            }
        }

        scanner.close();
    }
}
