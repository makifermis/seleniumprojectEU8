package com.cydeo.tests.day12_pom_desing_explicit_wait;

import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class POMPractices {
    LibraryLoginPage libraryLoginPage;

    @BeforeMethod
    public void setupMethod(){
        Driver.getDriver().get("https://library1.cydeo.com");
        libraryLoginPage = new LibraryLoginPage();
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

    @Test
    public void required_field_error_message_test(){
        //TC #1: Required field error message test
        //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com
        //3- Do not enter any information
        //4- Click to “Sign in” button

        libraryLoginPage.signInButton.click();
        //5- Verify expected error is displayed:
        //Expected: This field is required.
        Assert.assertTrue(libraryLoginPage.fieldRequiredErrorMessage.isDisplayed());
        //NOTE: FOLLOW POM DESIGN PATTERN
    }

    @Test
    public void invalid_mail_format_error_message_test(){
        //TC #2: Invalid email format error message test
        //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com
        //3- Enter invalid email format

        libraryLoginPage.inputUsername.sendKeys("somethingwrong");

        libraryLoginPage.signInButton.click();

        //4- Verify expected error is displayed:
        //Expected: Please enter a valid email address.
        Assert.assertTrue(libraryLoginPage.enterValidEmailErrorMessage.isDisplayed());

        //NOTE: FOLLOW POM DESIGN PATTERN
    }

    @Test
    public void library_negative_login(){
        //TC #3: Library negative login
        //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com
        //3- Enter incorrect username or incorrect password
        libraryLoginPage.inputUsername.sendKeys("wrong@username.com");
        libraryLoginPage.inputPassword.sendKeys("wrongpassword");

        libraryLoginPage.signInButton.click();
        //4- Verify title expected error is displayed:
        //Expected: Sorry, Wrong Email or Password
        Assert.assertTrue(libraryLoginPage.wrongEmailOrPasswordErrorMessage.isDisplayed());



        //NOTE: FOLLOW POM DESIGN PATTERN
    }


}
