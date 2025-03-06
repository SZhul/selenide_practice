package firstLesson;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AlphaBankTests {

    @Test
    void testAlfa(){
        Configuration.holdBrowserOpen = true;
        open("https://start.uat.ecp/");
        $(".is-mobile").click();
        $(".form-container__actions-col").shouldHave(text(" Эл. подпись "));
    }
}
