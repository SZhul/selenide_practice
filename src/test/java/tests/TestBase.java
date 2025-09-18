package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pageObjects.DemoqaPage;
import tests.demoqa.helpers.Attach;

public class TestBase {

    public DemoqaPage demoqaPage = new DemoqaPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
//        Configuration.pageLoadStrategy = "eager";
        Configuration.pageLoadTimeout = 100000;
        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.holdBrowserOpen = true;
        Configuration.browser = "firefox";
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
//        Attach.addVideo();
    }
}
