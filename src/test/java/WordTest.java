import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

  @Test
  public void word_initializesCorrectly_true() {
    Word testWord = new Word("tea");
    assertEquals(true, testWord instanceof Word);
  }

}
