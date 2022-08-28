package com.homeWork6_pom.tests;

import com.codeborne.selenide.Configuration;
import com.homeWork6_pom.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RegistrationFormTest {
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
            .setFirstName("Dinar")
            .setLastName("Gizzyatov")
            .setUserEmail("dinar@yahoo.com")
            .setUserGender("Male")
            .setUserPhoneNumber("1234567890")
            .setBirthDate("29", "October", "1990")
            .setSubject("Maths")
            .clickCheckboxSports()
            .uploadImage("src/test/resources/1234.jpg")
            .setCurrentAddress("Samara, Lenina 3")
            .setState("Uttar Pradesh")
            .setCity("Lucknow")
            .clickSubmitButton();

        registrationFormPage.checkResultsTableVisible();
        registrationFormPage.checkResult("Date of Birth", "29 October,1990")
            .checkResult("Student Name", "Dinar Gizzyatov")
            .checkResult("Student Email", "dinar@yahoo.com")
            .checkResult("Gender", "Male")
            .checkResult("Mobile", "1234567890")
            .checkResult("Subjects", "Maths")
            .checkResult("Hobbies", "Sports")
            .checkResult("Address", "Samara, Lenina 3")
            .checkResult("State and City", "Uttar Pradesh Lucknow");
    }
}
