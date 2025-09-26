package tests.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class SystemPropertiesTests {

    @Test
    void simplePropertyTest() {
        String browserName = System.getProperty("browserName");
        System.out.println(browserName); //null
    }

    @Test
    void simplePropertyTest1() {
        System.setProperty("browserName", "opera");
        String browserName = System.getProperty("browserName");
        System.out.println(browserName); //opera
    }

    @Test
    void simplePropertyTest2() {
        String browserName = System.getProperty("browserName", "firefox");
        System.out.println(browserName); //opera
    }

    @Test
    @Tag("oneProperty")
    void simplePropertyTest3() {
        System.out.println(System.getProperty("browserName"));
        String browserName = System.getProperty("browserName", "firefox");
        System.out.println(browserName);
        // gradle clean one_property_test
        // gradle clean one_property_test -DbrowserName=firefox
        // gradle clean one_property_test -DbrowserName="opera_headless" если два слова, берем в кавычках
    }

    @Test
    @Tag("hello")
    void simplePropertyTest4() {
        System.out.println("Hello, " + System.getProperty("user_name", "unknown"));
    }

    @Test
    @Tag("Homework")
    void simplePropertyTest5() {
        System.setProperty("browserSize", "1920x1080");
        open("https://github.com/");
        System.out.println(System.getProperty("browserSize"));
    }
}
