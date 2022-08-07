package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.timeout = 10000;
//        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").sendKeys("Dinar");
        $("#userEmail").sendKeys("Dinar@dinar.com");
        $("#currentAddress").sendKeys("Some address 1");
        $("#permanentAddress").sendKeys("Some address 2");
        $("#submit").click();

        $("#output #name").shouldHave(text("Dinar"));
        $("#output #email").shouldHave(text("Dinar@dinar.com"));
        $("#output #currentAddress").shouldHave(text("Some address 1"));
        $("#output #permanentAddress").shouldHave(text("Some address 2"));
    }
}
