package tests.demoqa;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class TestBoxWithRemoteDriverTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.pageLoadTimeout = 100000;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "128.0");
        capabilities.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("enableVNC", true);
            put("enableVideo", true);
        }});
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

    }

    @Test
    @Tag("remote")
    public void testBoxTest() {
        String username = "Ivan";
        String email = "ivankov@mail.ru";
        String currentAddress = "Egypt";
        String permanentAddress = "Russia";

        step("Открыть страницу", () -> open("/text-box"));
        $(".text-center").shouldHave(text("Text Box"));
        $("#userName").setValue(username);
        $("#userEmail").setValue(email);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);
        $("#submit").click();
        $("#output").shouldBe(visible);

        $$(".border.col-md-12.col-sm-12 p").shouldHave(size(4));
        $("#output #name").shouldHave(text(username));
        $("#output #email").shouldHave(text(email));
        $("#output #currentAddress").shouldHave(text(currentAddress));
        step("Проверить адрес", () -> $("#output #permanentAddress").shouldHave(text(permanentAddress)));
//        $("#output #permanentAddress").shouldHave(text(permanentAddress));
    }
}
