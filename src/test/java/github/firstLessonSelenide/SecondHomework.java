package github.firstLessonSelenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SecondHomework {

    @Test
    public void githubSolutionsHoverTest() {
        open("https://github.com/");
        $$("nav.HeaderMenu-nav ul.d-lg-flex li.HeaderMenu-item").findBy(text("Solutions")).hover();
        $$x("//div[@class='HeaderMenu-column px-lg-4 border-lg-right mb-4 mb-lg-0 pr-lg-7']//ul//li//a").findBy(text("Enterprise")).click();
        $("[data-testid='SubNav-root-heading']").shouldHave(exactText("Enterprise"));
    }

    @Test
    public void dragAndDropDeprecatedTest(){
        Configuration.holdBrowserOpen = true;
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo($("#column-b"));
    }

    @Test
    public void dragAndDropTest(){
        Configuration.holdBrowserOpen = true;
        SelenideElement columnA = $("#column-a");
        SelenideElement columnB = $("#column-b");
        open("https://the-internet.herokuapp.com/drag_and_drop");
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.dragAndDrop(columnA, columnB).build().perform();
    }
}
