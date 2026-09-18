import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Loads vocabulary words from the application's text data file.
 */
public class FileReader {
    /** Relative path to the vocabulary data file. */
    public static final String FILE_NAME = "singleton/txt/words.txt";

    /**
     * Reads each valid line in the data file and converts it into a Word.
     * Each line must contain a word, its part of speech, a definition, and an
     * example sentence separated by {@code #} characters.
     *
     * @return all valid words that were read, or an empty list if the file
     *         cannot be opened
     */
    public static ArrayList<Word> getWords() {
        ArrayList<Word> words = new ArrayList<Word>();

        try {
            File file = new File(FILE_NAME);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] data = line.split("#", 4);
                if (data.length < 4) {
                    continue;
                }
                words.add(new Word(data[0].trim(), data[1].trim(), data[2].trim(), data[3].trim()));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading " + FILE_NAME + ".");
        }

        return words;
    }
}
