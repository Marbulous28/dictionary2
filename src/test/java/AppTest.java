import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Dictionary!");
    assertThat(pageSource()).contains("View Word List");
    assertThat(pageSource()).contains("Add a New Word");
  }

  @Test
  public void wordIsCreatedTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a New Word"));
    fill("#word").with("Banana");
    submit(".btn");
    assertThat(pageSource()).contains("Your word has been saved.");
  }

  @Test
  public void wordIsDisplayedTest() {
    goTo("http://localhost:4567/words/new");
    fill("#word").with("Banana");
    submit(".btn");
    click("a", withText("View words"));
    assertThat(pageSource()).contains("Banana");
  }

  @Test
  public void wordShowPageDisplaysName() {
    goTo("http://localhost:4567/words/new");
    fill("#word").with("Yes");
    submit(".btn");
    click("a", withText("View words"));
    click("a", withText("Yes"));
    assertThat(pageSource()).contains("Yes");
  }

  @Test
  public void wordDefinitionsFormIsDisplayed() {
    goTo("http://localhost:4567/words/new");
    fill("#word").with("Hello");
    submit(".btn");
    click("a", withText("View words"));
    click("a", withText("Hello"));
    click("a", withText("Add a new definition"));
    assertThat(pageSource()).contains("Add a definition to Hello");
  }

  @Test
  public void definitionNotFoundMessageShown() {
    goTo("http://localhost:4567/definitions/999");
    assertThat(pageSource()).contains("Definition not found");
  }

}
