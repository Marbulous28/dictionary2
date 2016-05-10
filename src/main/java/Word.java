import java.util.ArrayList;

public class Word {
  private String mWord;
  private static ArrayList<Word> instances = new ArrayList<Word>();
  private int mId;

  public Word(String word) {
    mWord = word;
    instances.add(this);
    mId = instances.size();
  }

  public String getWord() {
    return mWord;
  }
}
