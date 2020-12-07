import java.util.ArrayList;
import java.util.Collections;

public class Dict {
    private ArrayList<String> dictionary;

    public Dict() {
        this.dictionary = new ArrayList<>();
    }

    public void add(String word) {
        this.dictionary.add(word);
    }

    public void show() {
        Collections.sort(this.dictionary);
        //sort into alphabetical order then check if it exists in the dictionary already
        ArrayList<String> sorted = new ArrayList<>();
        for (String word : this.dictionary) {
            if (!sorted.contains(word)) {
                sorted.add(word);
            }
        }
        for (String i : sorted) {
            //log the frequency of the word's appearance
            int occurrences = Collections.frequency(this.dictionary, i);
            //space out the word so it looks nice when it's displayed
            int spaceLength = 30 - i.length();
            System.out.format(i + "%1$"+spaceLength+"s", " " + occurrences + "\n");
        }

    }
}
