import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

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
    assertThat(pageSource()).contains("Definitions!");
  }

  @Test
  public void definitionIsCreatedTest() {
    goTo("http://localhost:4567/");
    fill("#definition").with("A Thing");
    submit(".btn");
    assertThat(pageSource()).contains("Your definition has been saved.");
  }

  @Test
  public void definitionIsDisplayedTest() {
    goTo("http://localhost:4567/");
    fill("#definition").with("A Thing");
    submit(".btn");
    click("a", withText("Go Back"));
    assertThat(pageSource()).contains("A Thing");
  }

  @Test
 public void multipleDefinitionsAreDisplayedTest() {
   goTo("http://localhost:4567/");
   fill("#definition").with("A Thing");
   submit(".btn");
   click("a", withText("Go Back"));
   fill("#definition").with("Another Thing");
   submit(".btn");
   click("a", withText("Go Back"));
   assertThat(pageSource()).contains("A Thing");
   assertThat(pageSource()).contains("Another Thing");
 }

}
