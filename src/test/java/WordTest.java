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
}
