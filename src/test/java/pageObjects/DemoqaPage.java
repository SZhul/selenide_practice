package pageObjects;

import com.codeborne.selenide.SelenideElement;
import pageObjects.components.CalendarComponent;
import pageObjects.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaPage implements RegistrationResultsModal {

    CalendarComponent calendarComponent = new CalendarComponent();

    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            genterWrapper = $("#genterWrapper"),
            openCalendar = $("#dateOfBirthInput");

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

    public DemoqaPage setBirthDate(String day, String month, String year) {
        openCalendar.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public DemoqaPage verifyResultsModalAppears(String text){
        verifyModalAppears(text);
        return this;
    }

    public DemoqaPage verifyResult(String key, String value){
        verifyModalResult(key, value);
        return this;
    }
}
