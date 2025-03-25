package pageObjects.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public interface RegistrationResultsModal {

    default void verifyModalAppears(String text) {
        $(".modal-content").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text(text));
    }

    default void verifyModalResult(String key, String value){
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));
    }
}
