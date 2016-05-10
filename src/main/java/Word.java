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

  public static ArrayList<Word> all() {
    return instances;
  }

 public static void clear() {
    instances.clear();
  }

  public int getId() {
    return mId;
  }

  public static Word find(int id) {
    try {
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }
}
