import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReplaceBannedWords {

    @Test
    public void readFile() throws FileNotFoundException {
        File bannedWords = new File("/Users/bothi/Desktop/banned_words.txt");

        File prose = new File("/Users/bothi/Desktop/prose.txt");

        Scanner sc = new Scanner(bannedWords);
        sc.skip("(\n" + "|[\n" + "\n" + "\u2028\u2029\u0085])?");

        while (sc.hasNext()) {
            Trie.insert(sc.next());
        }

        sc.close();

        Scanner scanner = new Scanner(prose);
        scanner.skip("(\n" + "|[\n" + "\n" + "\u2028\u2029\u0085])?");

        int wordLength=0;

        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(" ");
            StringBuilder stringBuilder = new StringBuilder(line.length);
            int maxWidth=0;

            for (String word : line) {
                if (word.matches("[A-Za-z]+")) {
                    if (Trie.search(word)) {
                        word= new String(new char[word.length()]).replace('\0', '*');
                    }
                }
                maxWidth = maxWidth + word.length()+1;
                if(maxWidth <= 30) {
                    System.out.print(word + " ");
                } else {
                    System.out.println();
                    System.out.print(word + " ");
                    maxWidth=word.length()+1;
                }
            }
        }
    }

}
