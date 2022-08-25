package com.selenidePageHW4;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestPageSelenideGit {

//    @BeforeAll
//    static void configure() {
//        Configuration.baseUrl = "https://github.com/";
//        Configuration.browser = "chrome";
//        Configuration.browserSize = "1366x768";
//        Configuration.browserPosition="0x0";
//    }

    @Test
    public void checkExampleCodeJunit() {
        open("https://github.com/");
        $("[data-test-selector=nav-search-input]").setValue("Selenide").pressEnter();
        $$("ul.repo-list li").first().$(".v-align-middle").click();
        $("#wiki-tab").click();
        $x("//li/button").click();
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        $(byText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("JUnit5"));
    }
}
