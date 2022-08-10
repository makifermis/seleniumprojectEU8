package com.cydeo.reviewWithOscar.week06;

import com.cydeo.reviewWithOscar.week06.pomForReview.WaitTaskPage;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.ReviewUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WaitExamples {

    //  1. Go to https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver
    //    2. Click on "Click me, to Open an alert after 5 seconds"
    //    3. Explicitly wait until alert is present
    //    4. Then handle the Javascript alert
    WaitTaskPage page; // Declare
    WebDriverWait wait;
    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
        page = new WaitTaskPage(); // initialize
        wait = new WebDriverWait(Driver.getDriver(),11);
    }

    @AfterMethod
    // screenshot option - if your test case fails you will need screenshot
    public void tearDown(){
        ReviewUtils.staticWait(2);
        Driver.closeDriver();
    }

    @Test
    public void Task01(){
        page.alertActivate.click();

        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }

    @Test
    public void Task02(){
        page.enableButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(page.disableButton));
        Assert.assertTrue(page.disableButton.isEnabled(), "Button has NOT been enabled YET!");
    }


}
/*
Task1:
    1. Go to https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver
    2. Click on "Click me, to Open an alert after 5 seconds"
    3. Explicitly wait until alert is present
    4. Then handle the Javascript alert

Task2:
    1. Go to https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver
    2. Click on "Enable button after 10 seconds"
    3. Explicitly wait until the button is enabled
    4. Then verify the button is enabled

 */