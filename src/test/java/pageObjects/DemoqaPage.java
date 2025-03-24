package pageObjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaPage {

    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            genterWrapper = $("#genterWrapper"),
            yearOfBirth = $(".react-datepicker__year-select"),
            monthOfBirth = $(".react-datepicker__month-select"),
            dayOfBirth = $(".react-datepicker__day--");

    public DemoqaPage openPage(String endpoint, String h1) {
        open(endpoint);
        $(".practice-form-wrapper").shouldHave(text(h1));
        return this;
    }

    public DemoqaPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public DemoqaPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public DemoqaPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public DemoqaPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public DemoqaPage selectGender(String gender) {
        genterWrapper.$(byText(gender)).click();
        return this;
    }

}
