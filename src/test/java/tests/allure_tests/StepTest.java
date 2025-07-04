package tests.allure_tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";

    @Test
    void lamdaStepTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.holdBrowserOpen = true;

        step("Открываем главную страницу гитхаба", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $("data-target='qbsearch-input.inputButtonText'").click();
            $("#query-builder-test").sendKeys(REPOSITORY);
            $("#header-search-input").submit();
        });
        step("Кликаем по ссылке репозитория", () -> {
            $(linkText(REPOSITORY)).click();
        });

        $("issues-tab").click();
        $(withText("#80")).should(Condition.exist);
    }

    @Test
    void StepsTest() {
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
    }
}
