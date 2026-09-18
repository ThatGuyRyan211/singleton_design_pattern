import java.util.Scanner;
/**
 * Runs the console user interface for the flash-card study application.
 */
public class UI {
    /** Reads answers entered by the user in the terminal. */
    private Scanner reader;
    /** Accepted response for continuing the study session. */
    private static final String YES = "y";
    /** Accepted response for ending the study session. */
    private static final String NO = "n";

    /** Creates a UI that reads input from the keyboard. */
    public UI() {
        reader = new Scanner(System.in);
    }

    /**
     * Starts a study session. Each loop displays a random card front, waits for
     * Enter, then displays that card's definition and example sentence.
     */
    public void run() {
        FlashCards flashCards = FlashCards.getInstance();
        clear();
        System.out.println("Welcome to our Flash Card Studying System!\n");

        while (true) {
            Word word = flashCards.getWord();
            System.out.println(word.getFlashCardFront());

            System.out.print("Press Enter to flip the card.");
            reader.nextLine();
            clear();

            System.out.println(word.getFlashCardBack());

            if (!playAgain())
                break;
            clear();
        }
        System.out.println("Have a nice day!");
    }

    /**
     * Asks whether the user wants another flash card.
     *
     * @return {@code true} when the user enters Y, or {@code false} when the
     *         user enters N
     */
    public boolean playAgain() {
        while (true) {
            System.out.println("Would you like to continue (Y)es or (N)o: ");

            String result = reader.nextLine().trim();

            if (result.equalsIgnoreCase(YES)) {
                return true;
            } else if (result.equalsIgnoreCase(NO)) {
                return false;
            } else {
                System.out.println("Invalid input");
            }
        }
    }

    /** Clears the console when the terminal supports ANSI escape sequences. */
    public void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Creates and starts the application.
     *
     * @param args command-line arguments; not used
     */
    public static void main(String[] args) {
        UI ui = new UI();
        ui.run();
    }
}
