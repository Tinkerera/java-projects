// Purpose: A simple number guessing game. The computer picks a random number between 1 and 100, and the user tries to guess it.
// The computer tells the user whether the guess is too high, too low, or correct.
import java.util.Scanner;
public class NumberGuesser {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = (int) (Math.random() * 100) + 1;
        System.out.println("I'm thinking of a number between 1 and 100");
        System.out.println("Can you guess what it is?");
        int guess = 0;
        while (guess != number) {
            guess = input.nextInt();
            if (guess == number) {
                System.out.println("You got it!");
            } else if (guess < number) {
                System.out.println("That's too low. Try again.");
            } else {
                System.out.println("That's too high. Try again.");
            }
        }
    }
}
