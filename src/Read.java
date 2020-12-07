import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Read {
    private Scanner scanner;
    private Dict dict;

    public Read() {
        this.scanner = new Scanner(System.in);
        this.dict = new Dict();
    }

    public void read() throws FileNotFoundException {
        //sample file for reading and sorting words in a sentence
        String inputFile = "breeze.txt";

        try {
            Scanner inFile = new Scanner(new FileReader(inputFile));
            while (inFile.hasNextLine()) {
                //for each line in the file, split by word
                String[] parts = inFile.nextLine().toLowerCase().split(" ");
                for (String part: parts) {
                    //check if the word contains letters only
                    String editedWord = letterCheck(part);
                    if (editedWord.equals("")) {
                        //if it's empty, continue and ignore
                        continue;
                    } else {
                        //if valid, add to the dictionary
                        dict.add(editedWord);
                    }
                }
            }
            dict.show();
            //display dictionary at the end and close file
            inFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public String letterCheck(String word) {
        String newWord = "";
        //check each letter of the word to see if it's a valid letter
        //all letters were made lowercase earlier on
        for (int i = 0; i < word.length(); i++) {
            if ((word.charAt(i) >= 'a' && word.charAt(i) <= 'z')) {
                newWord += word.charAt(i);
            }
        }
        //return new word when it is only valid characters
        return newWord;
    }
}
