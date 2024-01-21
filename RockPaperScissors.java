import java.util.Scanner;
import java.util.Random;;

public class RockPaperScissors {
    static final int ZERO = 0;
    static final int ONE = 1;
    static final int TWO = 2;
    static final String INPUT = "Input R for rock , P for paper or S for Scissors";
    static final String[] CHOISE = { "R", "P", "S" };
    static final String[] CHOICE_NAME = { "Rock", "Paper", "Scissors" };
    static final String WRONG_CHOICE = "Wrong choise please try again";
    static final String PLAY_AGAIN = "Do you want to play again? Choose Y for yes or any other key to exit.";
    static final String WIN = "You Win";
    static final String LOSE = "You Lose";
    static final String BREAK = "%s Breaks %s\n";
    static final String COVER = "%s Covers %s\n";
    static final String CUT = "%s Cuts %s\n";
    static final String YES = "Y";
    static final String YOUR_CHOISE = "You Choose: %s%n";
    static final String COMPUTER_CHOISE = "Computer Choose: %s%n";

    public static void main(String[] args) {
        int computer;
        int human = ZERO;

        Scanner in = new Scanner(System.in);
        Random random = new Random();

        // y for yes always play any other option will terminate game
        String playAgain = YES;
        while (playAgain.equalsIgnoreCase(YES)) {

            // run a while loop incase the choise is the same
            do {
                computer = random.nextInt(CHOISE.length);
                System.out.println(INPUT);
                String input = in.nextLine().toUpperCase();

                // making sure chooices are the correct ones
                while (!input.equals(CHOISE[ZERO])
                        && !input.equals(CHOISE[ONE])
                        && !input.equals(CHOISE[TWO])) {
                    System.out.println(WRONG_CHOICE);
                    input = in.nextLine().toUpperCase();
                }

                // geting the index of the human choise
                for (int i = ZERO; i < CHOISE.length; i++) {
                    if (input.equals(CHOISE[i])) {
                        human = i;
                        System.out.printf(YOUR_CHOISE, CHOICE_NAME[i]);
                        System.out.printf(COMPUTER_CHOISE, CHOICE_NAME[computer]);
                    }
                }
            } while (human == computer);

            // stating why you won or lost
            if ((computer == ONE && human == ZERO) || (computer == ZERO && human == ONE)) {
                System.out.printf(COVER, CHOICE_NAME[ONE], CHOICE_NAME[ZERO]);

            } else if ((computer == TWO && human == ONE) || (computer == ONE && human == TWO)) {
                System.out.printf(CUT, CHOICE_NAME[TWO], CHOICE_NAME[ONE]);

            } else {
                System.out.printf(BREAK, CHOICE_NAME[ZERO], CHOICE_NAME[TWO]);

            }

            if ((computer == ONE && human == ZERO) || (computer == TWO && human == ONE)
                    || (computer == ZERO && human == TWO)) {
                System.out.println(LOSE);
            } else {
                System.out.println(WIN);
            }

            System.out.println(PLAY_AGAIN);
            playAgain = in.nextLine();

        }
        in.close();
    }
}
