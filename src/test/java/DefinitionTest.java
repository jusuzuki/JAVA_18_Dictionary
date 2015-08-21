import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @Test
  public void definition_initializesCorrectly_true() {
    Definition testDef = new Definition("(of a person or their tendencies) not able to be corrected, improved, or reformed.");
    assertEquals(true, testDef instanceof Definition);
  }


}
