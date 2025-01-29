import java.util.Scanner;
import java.util.Random;
public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lowerBound = 1;
        int upperBound = 100;
        String feedback;
        System.out.println("Think of a number between 1 and 100 and I will try to guess it.");
        while (true) {
            int guess = generateGuess(lowerBound, upperBound);
            System.out.println("Is your number " + guess + "?");
            System.out.print("Enter 'high' if my guess is too high, 'low' if it's too low, or 'correct' if I guessed it right: ");
            feedback = scanner.nextLine().toLowerCase();
            if (feedback.equals("correct")) {
                System.out.println("Hooray! I guessed your number.");
                break;
            } else if (feedback.equals("high")) {
                upperBound = guess - 1;
            } else if (feedback.equals("low")) {
                lowerBound = guess + 1;
            } else {
                System.out.println("Invalid input. Please enter 'high', 'low', or 'correct'.");
            }
        }
        scanner.close();
    }
    public static int generateGuess(int lowerBound, int upperBound) {
        Random random = new Random();
        return random.nextInt(upperBound - lowerBound + 1) + lowerBound;
    }
}
