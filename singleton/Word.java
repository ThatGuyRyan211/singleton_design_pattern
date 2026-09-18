
/**
 * Represents one vocabulary word and the information shown on its flash card.
 */
public class Word {
    /** Vocabulary word displayed on the front of the card. */
    private String word;
    /** Part of speech for the vocabulary word. */
    private String type;
    /** Meaning of the vocabulary word. */
    private String definition;
    /** Sentence that demonstrates how the word is used. */
    private String sentence;

    /**
     * Creates a fully populated vocabulary word.
     *
     * @param word the vocabulary word
     * @param type the word's part of speech
     * @param definition the word's definition
     * @param sentence an example sentence containing the word
     */
    public Word(String word, String type, String definition, String sentence) {
        this.word = word;
        this.type = type;
        this.definition = definition;
        this.sentence = sentence;
    }

    /**
     * Formats the front side of this flash card.
     *
     * @return a boxed card containing only the vocabulary word
     */
    public String getFlashCardFront() {
        return makeCard("Word: " + word);
    }

    /**
     * Formats the back side of this flash card.
     *
     * @return a boxed card containing the word's details
     */
    public String getFlashCardBack() {
        return makeCard("Word: " + word + "\nPart of Speech: " + type
                + "\nDefinition: " + definition + "\nExample: " + sentence);
    }

    /**
     * Places text inside a fixed-width ASCII card.
     *
     * @param content one or more lines of card text
     * @return a formatted card
     */
    private String makeCard(String content) {
        final int width = 118;
        String border = "+" + "-".repeat(width) + "+\n";
        StringBuilder card = new StringBuilder(border);

        for (String line : content.split("\\n")) {
            String remaining = line;
            while (remaining.length() > width - 2) {
                card.append(String.format("| %-" + (width - 2) + "s |%n",
                        remaining.substring(0, width - 2)));
                remaining = remaining.substring(width - 2);
            }
            card.append(String.format("| %-" + (width - 2) + "s |%n", remaining));
        }
        return card.append(border).toString();
    }
}
