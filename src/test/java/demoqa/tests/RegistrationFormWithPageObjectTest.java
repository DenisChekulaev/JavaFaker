package demoqa.tests;

import com.github.javafaker.Faker;
import demoqa.Page.RegistrationFormPage;
import org.junit.jupiter.api.Test;

public class RegistrationFormWithPageObjectTest extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    @Test
    void fillFormTest() {

        registrationFormPage.openPage()
                .setFirstName("Denis")
                .setLastName("Chekulaev")
                .setEmail("Chekulaev@mail.ru")
                .setGender("Male")
                .setNumber("1234567890")
                .setBirthDate("05", "August", "1986")
                .setSubjects("Economics")
                .setHobby("Sports")
                .uploadPicture("img/1.png")
                .setAddress("Rostov-on-Don")
                .setState("Uttar Pradesh")
                .setCity("Agra")
                .pressSubmit();

        registrationFormPage.checkResultsTableVisible()
                .checkResults("Student Name", "Denis Chekulaev")
                .checkResults("Student Email", "Chekulaev@mail.ru")
                .checkResults("Gender","Male")
                .checkResults("Mobile", "1234567890")
                .checkResults("Date of Birth", "05 August,1986")
                .checkResults("Subjects", "Economics")
                .checkResults("Hobbies", "Sports")
                .checkResults("Picture", "1.png")
                .checkResults("Address", "Rostov-on-Don")
                .checkResults("State and City", "Uttar Pradesh Agra");
    }

}
