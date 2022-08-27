package com.homeWork6_pom;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

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
        $("#firstName").setValue("Dinar");
        $("#lastName").setValue("Gizzyatov");
        $("#userEmail").setValue("dinar@yahoo.com");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("1234567890");
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

        $("#state").scrollTo().click();
        $(byText("Uttar Pradesh")).click();
        $("#city").click();
        $(byText("Lucknow")).click();
        $("#submit").pressEnter();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("Dinar Gizzyatov"), text("dinar@yahoo.com"),
            text("Male"),text("1234567890"), text("29 October,1990"), text("Maths"),
            text("Sports"), text("1234.jpg"), text("Samara, Lenina 3"), text("Uttar Pradesh Lucknow"));
    }
}
