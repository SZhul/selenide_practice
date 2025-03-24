package tests.githubTests.firstLesson;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BestContributorToSelenide {

    @Test
    void solntsevShouldBeTheTopContributor() {
        Configuration.browserSize = "1920x1080";
        open("https://github.com/selenide/selenide");
        $("a.Link--inTextBlock.Link").ancestor(".BorderGrid-cell").$$("ul li").first().hover();
        $(".Popover a.f5.text-bold").shouldHave(text("asolntsev"));
    }
}
