package tests.demoqa;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TestBoxTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.pageLoadTimeout = 100000;
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    public void testBoxTest() {
        String username = "Ivan";
        String email = "ivankov@mail.ru";
        String currentAddress = "Egypt";
        String permanentAddress = "Russia";

        open("/text-box");
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
        $("#output #permanentAddress").shouldHave(text(permanentAddress));
    }
}
