package demoqa;


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
    }

    @Test
    public void testBoxTest() {
        open("https://demoqa.com/text-box");
        $(".text-center").shouldHave(text("Text Box"));
        $("#userName").setValue("Ivan");
        $("#userEmail").setValue("ivankov@mail.ru");
        $("#currentAddress").setValue("Egypt");
        $("#permanentAddress").setValue("Russia");
        $("#submit").click();
        $("#output").shouldBe(visible);

        $$(".border.col-md-12.col-sm-12 p").shouldHave(size(4));
    }
}
