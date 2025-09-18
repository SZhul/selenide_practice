package tests.allure_tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class AllureTest {


    @Test
    void AllureTests() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.holdBrowserOpen = true;
        open("https://github.com");
        $("data-target='qbsearch-input.inputButtonText'").click();
        $("#query-builder-test").sendKeys("eroshenkoam/allure-example");
        $("#header-search-input").submit();

        $(linkText("eroshenkoam/allure-example")).click();
        $("issues-tab").click();
        $(withText("#80")).should(Condition.exist);
    }
}
