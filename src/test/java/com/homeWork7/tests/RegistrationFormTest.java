package com.homeWork7.tests;

import com.codeborne.selenide.Configuration;
import com.homeWork7.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.homeWork7.tests.TestData.*;

public class RegistrationFormTest{
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1366x768";
        Configuration.browserPosition="0x0";
    }

    @Test
    void fillPracticeForm() {
        registrationFormPage
            .openPage()
            .setFirstName(firstName)
            .setLastName(lastName)
            .setUserEmail(userEmail)
            .setUserGender(gender)
            .setUserPhoneNumber(userPhoneNumber)
            .setBirthDate(day, month, year)
            .setSubject(subjects)
            .clickCheckboxSports()
            .uploadImage(uploadPicture)
            .setCurrentAddress(currentAdress)
            .setState(state)
            .setCity(city)
            .clickSubmitButton();

        registrationFormPage.checkResultsTableVisible();
        registrationFormPage.checkResult("Date of Birth", String.format("%s %s,%s",day,month,year))
            .checkResult("Student Name", String.format("%s %s",firstName, lastName))
            .checkResult("Student Email", userEmail)
            .checkResult("Gender", gender)
            .checkResult("Mobile", userPhoneNumber)
            .checkResult("Subjects", subjects)
            .checkResult("Hobbies", "Sports")
            .checkResult("Address", currentAdress)
            .checkResult("State and City", String.format("%s %s", state, city));
    }
}
