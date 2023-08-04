import java.util.Random;
import java.util.Scanner;

public class NumbersGame {

    public static boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello, human. I am thinking of a number between 0 and 10.");
        System.out.println("*********************************************************");
        System.out.println("Can you guess the number?");
        System.out.println("If you are not up to the task, you can always type 'q' to quit.");

        boolean playAgain = true;
        while (playAgain) {
            int answer = new Random().nextInt(11);
            int guessNum = 1;

            while (guessNum <= 3) {
                Scanner scanner = new Scanner(System.in);
                String guess = scanner.nextLine();

                if (guess.equals("q")) {
                    System.out.println("I knew you didn't have it in you.");
                    System.out.println("Shutting down...");
                    break;
                }

                if (!isNumeric(guess)) {
                    System.out.println("You must enter a number.");
                    continue;
                }

                int userGuess = Integer.parseInt(guess);

                if (userGuess < 0 || userGuess > 10) {
                    System.out.println("You must enter a number between 0 and 10.");
                    continue;
                }

                if (userGuess == answer) {
                    System.out.println("Lucky guess! But can you do it again?");
                    break;
                } else {
                    System.out.println("Swing and a miss! Keep trying...");
                    guessNum++;
                }
            }

            if (guessNum > 3) {
                System.out.println("You have run out of guesses. Better luck next time!");
            }

            System.out.println("Do you want to play again? (yes/no)");
            Scanner scanner = new Scanner(System.in);
            String playAgainResponse = scanner.nextLine().toLowerCase();
            playAgain = playAgainResponse.equals("yes");
        }

        System.out.println("Game over. Shutting down...");
    }
}
