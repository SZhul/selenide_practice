package github.firstLessonSelenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class FirstHomework {

    @Test
    void firstHomework() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $$(".markdown-body ul li a.internal.present").findBy(text("Soft assertions")).shouldBe(visible).click();
        $$("h4.heading-element").findBy(text("3. Using JUnit5 extend test class:")).shouldBe(visible);
    }
}
