import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MainReader {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner inFile;
        try{
            inFile = new Scanner(new FileReader("data.txt"));
        } catch (FileNotFoundException E) {
            PrintWriter outFile = new PrintWriter("data.txt");
            outFile.println("In the cool, cool breeze of the evening, the nightingale sang 27 SWeeT songs.");
            outFile.close();
            inFile = new Scanner(new FileReader("data.txt"));
        }
        ArrayList<String> wordList = new ArrayList<>();
        while(inFile.hasNext()) {
            String[] words = inFile.nextLine().replaceAll("[:.!,?0123456789]", "").toLowerCase().split(" ");
            for (String s : words) {
                if (!s.equals("")) {
                    wordList.add(s);
                }
            }
        }
        Collections.sort(wordList);
        ArrayList<Words> wordsArrayList = new ArrayList<>();
        PrintWriter resultFile = new PrintWriter("result.txt");
        for (String word: wordList) {
            ArrayList<String> onlyWordList = new Words().getWordList(wordsArrayList);
            if(onlyWordList.contains(word)){
                continue;
            } else {
                Words words = new Words(word, Collections.frequency(wordList, word));
                wordsArrayList.add(words);
                resultFile.println(word);
                String align = word;
                for(int i=0; i<(30-word.length()); i++)
                    align += " ";
                System.out.println(align + Collections.frequency(wordList, word));
            }
        }
        resultFile.close();
    }

}
