package tests.demoqa;

import org.junit.jupiter.api.Test;
import tests.TestBase;

import java.io.File;

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
                .setBirthDate("10", "March", "2001")
                .setSubject("English")
                .selectHobbies("Sports")
                .uploadFile(new File("src/test/resources/kitty.png"))
                .setCurrentAddress("Russia")
                .selectState("NCR")
                .selectCity()
                .clickSubmitButton()
                .verifyResultsModalAppears("Thanks for submitting the form")
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
