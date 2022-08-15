package demoqa.tests;

import com.github.javafaker.Faker;

public class TestData {
    public static Faker faker = new Faker();
    static String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            userGender = "Male",
            userNumber = faker.phoneNumber().subscriberNumber(10),
            day = faker.number().numberBetween(1, 30) + "",
            month = "August",
            year = faker.number().numberBetween(1980,2022) +"",
            subjects = "Economics",
            hobby = "Sports",
            picture = "img/1.png",
            userAddress = faker.address().fullAddress(),
            userState = "Uttar Pradesh",
            userCity = "Agra";

}
