//Author: Ryan Callahan

public class Word {
    /** Width inside each flash-card border. */
    private static final int CARD_WIDTH = 138;

    /** ANSI color for the word and part of speech. */
    private static final String CYAN = "\u001B[36m";

    /** ANSI color for the definition and example. */
    private static final String PURPLE = "\u001B[35m";

    /** ANSI code that returns text to the normal terminal color. */
    private static final String RESET = "\u001B[0m";

    /** The vocabulary word. */
    private String word;

    /** The word's part of speech. */
    private String type;

    /** The definition of the word. */
    private String definition;

    /** An example sentence using the word. */
    private String sentence;

    /**
     * Creates a vocabulary word for a flash card.
     *
     * @param word the vocabulary word
     * @param type the part of speech
     * @param definition the word's definition
     * @param sentence an example sentence
     */
    public Word(String word, String type, String definition, String sentence) {
        this.word = word;
        this.type = type;
        this.definition = definition;
        this.sentence = sentence;
    }

    /**
     * Creates the front of the flash card.
     *
     * @return a formatted card with the vocabulary word
     */
    public String getFlashCardFront() {
        StringBuilder card = new StringBuilder();
        card.append(getBorder());
        card.append(getLine("Word: " + CYAN + word.toUpperCase() + RESET));
        card.append(getLine(""));
        card.append(getLine(""));
        card.append(getLine(""));
        card.append(getBorder());

        return card.toString();
    }

    /**
     * Creates the back of the flash card.
     *
     * @return a formatted card with the word details
     */
    public String getFlashCardBack() {
        StringBuilder card = new StringBuilder();
        card.append(getBorder());
        card.append(getLine("Word: " + CYAN + word.toUpperCase() + RESET));
        card.append(getLine("Part of Speech: " + CYAN + type + RESET));
        card.append(getLine("Definition: " + PURPLE + definition + RESET));
        card.append(getLine("Example: " + PURPLE + sentence + RESET));
        card.append(getBorder());

        return card.toString();
    }

    /**
     * Creates the top or bottom border of a flash card.
     *
     * @return a dashed card border
     */
    private String getBorder() {
        return "+" + "-".repeat(CARD_WIDTH) + "+\n";
    }

    /**
     * Creates one padded row inside the flash card.
     *
     * @param text the text to place on the row
     * @return one formatted card row
     */
    private String getLine(String text) {
        int visibleLength = getVisibleLength(text);
        int spacesNeeded = CARD_WIDTH - visibleLength - 2;

        return "| " + text + " ".repeat(Math.max(0, spacesNeeded)) + " |\n";
    }

    /**
     * Finds a string's length without counting ANSI color codes.
     *
     * @param text text that may contain color codes
     * @return the visible number of characters
     */
    private int getVisibleLength(String text) {
        return text.replaceAll("\\u001B\\[[;\\d]*m", "").length();
    }
}