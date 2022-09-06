package com.homeWork7.pages.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultsModalComponent {
    private final static String TITLE_TEXT = "Thanks for submitting the form";

    public ResultsModalComponent checkIsVisible() {
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text(TITLE_TEXT));

        return this;
    }

    public ResultsModalComponent checkResult(String key, String value) {
        $(".table-responsive").$(byText(key)).sibling(0).shouldHave(text(value));

        return this;
    }
}

