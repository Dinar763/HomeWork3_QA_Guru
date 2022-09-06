package com.homeWork7.pages;

import com.codeborne.selenide.SelenideElement;
import com.homeWork7.pages.components.CalendarComponent;
import com.homeWork7.pages.components.ResultsModalComponent;
import com.homeWork7.pages.components.UploadFileComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationFormPage {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultsModalComponent resultsModalComponent = new ResultsModalComponent();
    private UploadFileComponent uploadFileComponent = new UploadFileComponent();

    //Elements
    private SelenideElement
        inputFirstName = $("#firstName"),
        inputLastName = $("#lastName"),
        inputUserEmail = $("#userEmail"),
        genderButton = $("#genterWrapper"),
        inputUserPhoneNumber = $("#userNumber"),
        dateOfBirthInput = $("#dateOfBirthInput"),
        subjectsInput = $("#subjectsInput"),
        addressInput = $("#currentAddress"),
        checkboxSports = $("[for='hobbies-checkbox-1']"),
        checkboxReading = $("[for='hobbies-checkbox-2']"),
        checkboxMusic = $("[for='hobbies-checkbox-3']"),
        stateAccordeon = $("#state"),
        cityAccordeon = $("#city"),
        submitButton = $("#submit");

    //Actions
    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').hide()");

        return this;
    }

    public RegistrationFormPage setFirstName(String firstName) {
        inputFirstName.setValue(firstName);

        return this;
    }

    public RegistrationFormPage setLastName(String lastName) {
        inputLastName.setValue(lastName);

        return this;
    }

    public RegistrationFormPage setUserEmail(String emailName) {
        inputUserEmail.setValue(emailName);

        return this;
    }

    public RegistrationFormPage setUserGender(String gender) {
        genderButton.$(byText(gender)).click();

        return this;
    }

    public RegistrationFormPage setUserPhoneNumber(String phoneNumber) {
        inputUserPhoneNumber.setValue(phoneNumber);

        return this;
    }

    public RegistrationFormPage setBirthDate(String day, String month, String year){
        $(dateOfBirthInput).click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationFormPage checkResultsTableVisible(){
        resultsModalComponent.checkIsVisible();

        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        resultsModalComponent.checkResult(key, value);

        return this;
    }

    public RegistrationFormPage setSubject(String subject) {
        subjectsInput.setValue(subject).pressEnter();

        return this;
    }

    public RegistrationFormPage clickCheckboxSports() {
        checkboxSports.click();

        return this;
    }

    public RegistrationFormPage clickCheckboxReading() {
        checkboxReading.click();

        return this;
    }

    public RegistrationFormPage clickCheckboxMusic() {
        checkboxMusic.click();

        return this;
    }

    public RegistrationFormPage uploadImage(String pathToFile) {
        uploadFileComponent.uploadImage(pathToFile);

        return this;
    }

    public RegistrationFormPage setCurrentAddress(String address) {
        addressInput.setValue(address);

        return this;
    }

    public RegistrationFormPage setState(String stateName) {
        stateAccordeon.scrollTo().click();
        $(byText(stateName)).click();

        return this;
    }

    public RegistrationFormPage setCity(String cityName) {
        cityAccordeon.click();
        $(byText(cityName)).click();

        return this;
    }

    public RegistrationFormPage clickSubmitButton() {
        submitButton.pressEnter();

        return this;
    }
}
