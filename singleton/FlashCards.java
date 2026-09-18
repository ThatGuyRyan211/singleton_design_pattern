import java.util.ArrayList;
import java.util.Random;

/**
 * Provides one shared collection of vocabulary flash cards.
 * This class follows the Singleton pattern: the application creates only one
 * FlashCards object, accessed through {@link #getInstance()}.
 */
public class FlashCards {
    /** The one shared FlashCards object. */
    private static FlashCards instance;
    /** Random-number generator used to choose a card. */
    private Random rand;
    /** The vocabulary cards loaded from the data file. */
    private ArrayList<Word> words;

    /**
     * Creates the shared collection and loads its cards. This constructor is
     * private so other classes must use {@link #getInstance()}.
     */
    private FlashCards() {
        rand = new Random();
        words = FileReader.getWords();
    }

    /**
     * Returns the application's one FlashCards object.
     *
     * @return the shared flash-card collection
     */
    public static FlashCards getInstance() {
        if (instance == null) {
            instance = new FlashCards();
        }
        return instance;
    }

    /**
     * Selects a random word from the loaded collection.
     *
     * @return a randomly selected word
     * @throws IllegalStateException if no words were loaded from the file
     */
    public Word getWord() {
        if (words.isEmpty()) {
            throw new IllegalStateException("No flash cards were loaded.");
        }
        return words.get(rand.nextInt(words.size()));
    }
}
