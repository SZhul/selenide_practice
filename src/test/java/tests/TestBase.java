package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pageObjects.DemoqaPage;

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
}
