package tests.demoqa;

import org.junit.jupiter.api.Test;
import tests.TestBase;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class HomeworkDemoQATests extends TestBase {
    @Test
    public void testBoxTest() {
        demoqaPage
                .openPage("/automation-practice-form", "Student Registration Form")
                .setFirstName("Ivan")
                .setLastName("Ivankov")
                .setUserEmail("ivankov@mail.ru")
                .setUserNumber("1234567890")
                .selectGender("Female")
                .setBirthDate("10", "March", "2001");

        $("#subjectsInput").shouldBe(visible).setValue("English").pressEnter();
        $x("//div[@id='hobbiesWrapper']//label[text()='Sports']").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/kitty.png"));
        $("#currentAddress").setValue("Russia");
        $("#state").click();
        $$(".css-11unzgr div").findBy(text("NCR")).click();
        $("#city").click();
        $$(".css-11unzgr div").findBy(text("Delhi")).click();

        $("#submit").click();

        demoqaPage.verifyResultsModalAppears("Thanks for submitting the form")
                        .verifyResult("Student Name", "Ivan")
                        .verifyResult("Student Email", "ivankov@mail.ru")
                        .verifyResult("Gender", "Female")
                        .verifyResult("Mobile", "1234567890")
                        .verifyResult("Date of Birth", "10 March,2001")
                        .verifyResult("Subjects", "English")
                        .verifyResult("Hobbies", "Sports")
                        .verifyResult("Picture", "kitty.png")
                        .verifyResult("Address", "Russia")
                        .verifyResult("State and City", "NCR Delhi");
    }
}
