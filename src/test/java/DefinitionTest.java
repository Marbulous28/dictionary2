import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @Test
  public void Definition_instantiatesCorrectly_true() {
    Definition myDefinition = new Definition("A Thing");
    assertEquals(true, myDefinition instanceof Definition);
  }

  @Test
  public void Definition_instantiatesWithDescription_String() {
    Definition myDefinition = new Definition("A Thing");
    assertEquals("A Thing", myDefinition.getDefinition());
  }

}
