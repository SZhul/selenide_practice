package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class HomeworkDemoQATests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.pageLoadTimeout = 50000;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.browser = "chrome";
    }

    @Test
    public void testBoxTest() {
        open("/automation-practice-form");

        String firstName = "Ivan";
        String lastName = "Ivanov";
        String userEmail = "ivankov@mail.ru";
        String number = "1234567890";

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $x("//div[@id='genterWrapper']//input[@value='Male']//following-sibling::label").click();
        $("#userNumber").setValue(number);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("2001");
        $(".react-datepicker__month-select").selectOptionByValue("10");
        $(".react-datepicker__day--010").click();
        $x("//div[@id='hobbiesWrapper']//label[text()='Sports']").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/kitty.png"));
        $("#currentAddress").setValue("Russia");
        $("#state").click();
        $$(".css-11unzgr div").findBy(text("NCR")).click();
        $("#city").click();
        $$(".css-11unzgr div").findBy(text("Delhi")).click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#submit").click();

        $(".table-responsive").shouldHave(text("Student Name"), text("Student Email"),
                text("Gender"), text("Mobile"), text("Date of Birth"), text("Subjects"), text("Hobbies"),
                text("Picture"), text("Address"), text("State and City"));
        $(".table-responsive").shouldHave(text("Ivan"), text("Ivanov"), text("Male"), text("1234567890"),
                text("10 November,2001"), text("English"), text("Sports"), text("kitty.png"), text("Russia"),
                text("NCR Delhi"));
    }
}
