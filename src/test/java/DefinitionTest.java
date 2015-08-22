import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @Test
  public void definition_initializesCorrectly_true() {
    Definition testDef = new Definition("a hot drink made by infusing the dried, crushed leaves of the tea plant in boiling water");
    assertEquals(true, testDef instanceof Definition);
  }

  @Test
  public void definition_instantiatesWithDescription_true() {
    Definition myDef = new Definition("a type of Indian tea, made especially by boiling the tea leaves with milk, sugar, and cardamom");
    assertEquals("a type of Indian tea, made especially by boiling the tea leaves with milk, sugar, and cardamom", myDef.getDefinition());
  }

}
