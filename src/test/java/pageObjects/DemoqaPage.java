package pageObjects;

import com.codeborne.selenide.SelenideElement;
import pageObjects.components.CalendarComponent;
import pageObjects.components.ListboxComponent;
import pageObjects.components.RegistrationResultsModal;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaPage implements RegistrationResultsModal {

    CalendarComponent calendarComponent = new CalendarComponent();
    ListboxComponent listboxComponent = new ListboxComponent();

    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            genterWrapper = $("#genterWrapper"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            openCalendar = $("#dateOfBirthInput"),
            currentAddressInput = $("#currentAddress"),
            subjectInput = $("#subjectsInput"),
            submitButton = $("#submit");


    public DemoqaPage openPage(String endpoint, String h1) {
        open(endpoint);
        $(".practice-form-wrapper").shouldHave(text(h1));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
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

    public DemoqaPage selectHobbies(String hobbies) {
        hobbiesWrapper.$(byText(hobbies)).click();
        return this;
    }

    public DemoqaPage setBirthDate(String day, String month, String year) {
        openCalendar.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public DemoqaPage verifyResultsModalAppears(String text) {
        verifyModalAppears(text);
        return this;
    }

    public DemoqaPage verifyResult(String key, String value) {
        verifyModalResult(key, value);
        return this;
    }

    public DemoqaPage setSubject(String value) {
        subjectInput.shouldBe(visible).setValue(value).pressEnter();
        return this;
    }

    public DemoqaPage uploadFile(File file) {
        $("#uploadPicture").uploadFile(file);
        return this;
    }

    public DemoqaPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public DemoqaPage selectState(String value) {
        $("#state").click();
        listboxComponent.selectElementByText(value);
        return this;
    }

    public DemoqaPage selectCity() {
        $("#city").click();
        listboxComponent.SelectFirstElementOnList();
        return this;
    }

    public DemoqaPage clickSubmitButton() {
        submitButton.click();
        return this;
    }
}
