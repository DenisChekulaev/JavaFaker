package demoqa.tests;

import demoqa.Page.RegistrationFormPage;
import org.junit.jupiter.api.Test;

import static demoqa.tests.TestData.*;
import static java.lang.String.format;

public class RegistrationFormWithFakerTest extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();


    @Test
    void fillFormTest() {

        registrationFormPage.openPage()
                .setFirstName(TestData.firstName)
                .setLastName(TestData.lastName)
                .setEmail(TestData.email)
                .setGender(TestData.userGender)
                .setNumber(TestData.userNumber)
                .setBirthDate(day, month, year)
                .setSubjects(TestData.subjects)
                .setHobby(TestData.hobby)
                .uploadPicture(TestData.picture)
                .setAddress(TestData.userAddress)
                .setState(TestData.userState)
                .setCity(TestData.userCity)
                .pressSubmit();
        String expectedFullName = format("%s %s", firstName, lastName);
        String expectedDateOfBirth = format("%s %s,%s", day, month, year);
        String expectedStateAndCity = format("%s %s", userState, userCity);

        registrationFormPage.checkResultsTableVisible()
                .checkResults("Student Name", expectedFullName)
                .checkResults("Student Email", TestData.email)
                .checkResults("Gender",TestData.userGender)
                .checkResults("Mobile", TestData.userNumber)
                .checkResults("Date of Birth",expectedDateOfBirth)
                .checkResults("Subjects", TestData.subjects)
                .checkResults("Hobbies", TestData.hobby)
                .checkResults("Picture", "1.png")
                .checkResults("Address", userAddress)
                .checkResults("State and City", expectedStateAndCity);
    }

}
