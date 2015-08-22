import org.fluentlenium.adapter.FluentTest;
import java.util.ArrayList;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.fluentlenium.core.filter.FilterConstructor.*;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegrationTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
  	goTo("http://localhost:4567/");
  	assertThat(pageSource()).contains("DICTIONARY");
  }

  @Test
  public void wordIsDisplayed() {
    goTo("http://localhost:4567/");
    fill("#inputword").with("coffee");
    submit(".btn");
    click("a", withText("Go Back"));
    assertThat(pageSource()).contains("coffee");
  }

  @Test
  public void addDefinition() {
    goTo("http://localhost:4567/");
    fill("#inputword").with("root beer");
    submit(".btn");
    click("a", withText("Go Back"));
    assertThat(pageSource()).contains("root beer");
    click("a", withText("root beer"));
    fill("#definition").with("an effervescent drink made from an extract of the roots and bark of certain plants.");
    assertThat(pageSource()).contains("an effervescent drink made from an extract of the roots and bark of certain plants.");
  }

  // Changed the project a little to display the words as well as their definitions on the homepage
  @Test
  public void homeDisplaysWordsAndDefinition() {
    goTo("http://localhost:4567/");
    fill("#inputword").with("chai");
    submit(".btn");
    click("a", withText("Go Back"));
    assertThat(pageSource()).contains("chai");
    click("a", withText("chai"));
    fill("#definition").with("a type of Indian tea, made especially by boiling the tea leaves with milk, sugar, and cardamom");
    submit(".btn");
    click("a", withText("Return to Main Page"));
    assertThat(pageSource()).contains("a type of Indian tea, made especially by boiling the tea leaves with milk, sugar, and cardamom");
  }

}
