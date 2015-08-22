import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

  @Test
  public void word_initializesCorrectly_true() {
    Word testWord = new Word("tea");
    assertEquals(true, testWord instanceof Word);
  }

  @Test
  public void find_returnsWordById() {
    Word testWord = new Word("coffee");
    assertEquals(Word.find(testWord.getId()), testWord);
    }

  @Test
  public void addWordAndDefinition() {
    Word testWord = new Word("cider");
    Definition testDef = new Definition("an alcoholic drink made from fermented crushed fruit, typically apples.");
    testWord.addDefinition(testDef);
    assertTrue(testWord.getDefinitions().contains(testDef));
  }

}
