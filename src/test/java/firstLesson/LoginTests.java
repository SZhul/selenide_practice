package firstLesson;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTests {

    @Test
    void successfulLoginTest() {

        open("https://qa.guru/cms/system/login");
        $(".login-form").shouldHave(text("Войти"));
        $("[name=email]").setValue("houseoftales@mail.ru");
        $("[name=password]").setValue("Borod@@tor93").pressEnter();
        $("h1").shouldHave(text("Список тренингов"));
        $(".logo-link").click();
        $(".logined-form").shouldHave(text("Здравствуйте, Sergey"));
    }
}
