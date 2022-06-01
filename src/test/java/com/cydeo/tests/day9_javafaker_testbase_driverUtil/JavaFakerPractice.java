package com.cydeo.tests.day9_javafaker_testbase_driverUtil;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerPractice {

    @Test
    public void test1(){

        //Creating Faker object to reach methods.
        Faker faker = new Faker();
        //Faker faker = new Faker(new Locale("fr"));
        System.out.println("faker.name().firstName() = " + faker.name().firstName());
        System.out.println("faker.name().lastName() = " + faker.name().lastName());

        System.out.println("faker.name().fullName() = " + faker.name().fullName());

        System.out.println("faker.numerify(\"06##-##-##-##\") = " + faker.numerify("06##-##-##-##"));

        // letterify()  method will return random letters where we pass "?"
        faker.letterify("???-????");

        System.out.println("faker.bothify(\"##?#-##??-??##-#?#?\") = " + faker.bothify("##?#-##??-??##-#?#?").toUpperCase());

        System.out.println("faker.finance().creditCard() = " + faker.finance().creditCard());

        System.out.println("faker.chuckNorris().fact() = " + faker.chuckNorris().fact().replaceAll("Chuck Norris","Muhtar"));
    }

}
