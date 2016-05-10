import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

  @Test
  public void word_instantiatesCorrectly_true() {
    Word testWord = new Word("That");
    assertEquals(true, testWord instanceof Word);
  }

  @Test
  public void getName_wordInstantiatesWithName_That() {
    Word testWord = new Word("That");
    assertEquals("That", testWord.getWord());
  }

  @Test
  public void all_returnsAllInstancesOfWord_true() {
    Word firstWord = new Word("That");
    Word secondWord = new Word("This");
    assertTrue(Word.all().contains(firstWord));
    assertTrue(Word.all().contains(secondWord));
  }

  @Test
  public void clear_emptiesAllWordsFromList_0() {
    Word testWord = new Word("This");
    Word.clear();
    assertEquals(Word.all().size(), 0);
  }

  @Test
  public void getId_wordsInstantiateWithAnId_1() {
    Word.clear();
    Word myWord = new Word("This");
    assertEquals(1, myWord.getId());
  }

  @Test
  public void find_returnsWordWithSameId_secondWord() {
    Word firstWord = new Word("This");
    Word secondWord = new Word("That");
    assertEquals(Word.find(secondWord.getId()), secondWord);
  }

  @Test
  public void find_returnsNullWhenNoWordFound_null() {
    assertTrue(Word.find(999) == null);
  }

}
