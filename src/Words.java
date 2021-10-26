import java.util.ArrayList;

public class Words {

    private String word;
    private int count;

    public Words() {
        this.word="";
        this.count=0;
    }

    public Words(String word, int count) {
        this.word=word;
        this.count=count;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<String> getWordList(ArrayList<Words> wordsArrayList) {
        ArrayList<String> wordList = new ArrayList<>();
        for (Words word: wordsArrayList){
            wordList.add(word.getWord());
        }
        return wordList;
    }
}
