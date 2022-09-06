package com.homeWork7.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;

import java.util.Locale;

public class TestData {
    static Faker faker = new Faker(new Locale("EN"));
    static String
        firstName = faker.name().firstName(),
        lastName = faker.name().lastName(),
        userEmail = faker.internet().emailAddress(),
        gender = "Male",
        userPhoneNumber = faker.phoneNumber().subscriberNumber(10),
        day = faker.number().numberBetween(1, 30) + "",
        month = "October",
        year = faker.number().numberBetween(1900, 2010) + "",
        subjects = "Maths",
        hobbies = "Sports",
        uploadPicture = "src/test/resources/1234.jpg",
        currentAdress = faker.address().fullAddress(),
        state = "Uttar Pradesh",
        city = "Lucknow";

}
