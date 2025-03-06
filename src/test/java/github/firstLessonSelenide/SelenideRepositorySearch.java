package github.firstLessonSelenide;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {

    @Test
    void shouldFindSelenideRepositoryAtTheTop() {
        open("https://github.com/");
        $(".header-search-button").click();
        $("[name=query-builder-test]").setValue("selenide").shouldBe(visible).pressEnter();
        $("[data-testid='results-list']").shouldBe(visible);
        $$("[data-testid='results-list'] h3").get(0).$("a").click();
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
    }
}
