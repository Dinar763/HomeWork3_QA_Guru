package com.homeWork7.pages.components;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class UploadFileComponent {

    public UploadFileComponent uploadImage(String pathToFile) {
        $("#uploadPicture").uploadFile(new File(pathToFile));

        return this;
    }
}
