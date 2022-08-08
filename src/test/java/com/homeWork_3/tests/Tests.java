package com.homeWork_3.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Tests {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1366x768";
        Configuration.browserPosition="0x0";
    }

    @Test
    void fillPracticeForm() {
        open("/automation-practice-form");
        $("#firstName").sendKeys("Dinar");
        $("#lastName").sendKeys("Gizzyatov");
        $("#userEmail").sendKeys("dinar@yahoo.com");
        $("[for='gender-radio-1']").click();
        $("#userNumber").sendKeys("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $("[value='1990']").click();
        $(".react-datepicker__month-select").click();
        $("[value='10']").click();
        $(".react-datepicker__day--029").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/1234.jpg"));
        $("#currentAddress").setValue("Samara, Lenina 3");

        $("#state").shouldBe(visible).scrollTo().click();
        $(byText("Uttar Pradesh")).click();
        $("#city").click();
        $(byText("Lucknow")).click();
        $("#submit").pressEnter();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("Dinar Gizzyatov"));
        $(".modal-body").shouldHave(text("dinar@yahoo.com"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("1234567890"));
        $(".modal-body").shouldHave(text("29 October,1990"));
        $(".modal-body").shouldHave(text("Maths"));
        $(".modal-body").shouldHave(text("Sports"));
        $(".modal-body").shouldHave(text("1234.jpg"));
        $(".modal-body").shouldHave(text("Samara, Lenina 3"));
        $(".modal-body").shouldHave(text("Uttar Pradesh Lucknow"));
    }


}
