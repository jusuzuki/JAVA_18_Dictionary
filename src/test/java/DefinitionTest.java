import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @Test
  public void definition_initializesCorrectly_true() {
    Definition testDef = new Definition("a hot drink made by infusing the dried, crushed leaves of the tea plant in boiling water.");
    assertEquals(true, testDef instanceof Definition);
  }


}
