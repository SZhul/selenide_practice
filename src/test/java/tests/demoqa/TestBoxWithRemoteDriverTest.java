package tests.demoqa;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBaseExtended;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class TestBoxWithRemoteDriverTest extends TestBaseExtended {

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
    }
}
