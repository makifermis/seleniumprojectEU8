package com.cydeo.reviewWithOscar.week06.pomForReview;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.ReviewUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task06 {

    @Test
    public void Test(){
        Driver.getDriver().get("https://www.automationexercise.com/");

        // create object so that you can use elements and methods
        ContactUsPage page = new ContactUsPage();

        // click contact us
        // page.contactUs.click();
        page.getElement("Contact us").click();

        //for scrolling test cases
        // create actions object
        //first way
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
        ReviewUtils.staticWait(2);
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP).perform();
        ReviewUtils.staticWait(2);
        // second way
        actions.moveToElement(page.submit).perform();

        //third way
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,750)");
        ReviewUtils.staticWait(1);
        js.executeScript("window.scrollBy(0,-750)");

        ReviewUtils.staticWait(1);

        // last way
        js.executeScript("arguments[0].scrollIntoView(true)", page.submit);
        ReviewUtils.staticWait(2);

        Faker faker = new Faker();

        page.name.sendKeys(faker.name().fullName());
        page.email.sendKeys(faker.internet().emailAddress());
        page.subject.sendKeys(faker.howIMetYourMother().catchPhrase());
        page.message.sendKeys(faker.chuckNorris().fact());

        ReviewUtils.staticWait(3);

        String path = "C:\\Users\\HP\\Desktop\\testFile.txt";

        // to upload file use sendKeys method and provide path of the file as parameter

        page.uploadFile.sendKeys(path);

        page.submit.click();

        // We get JS alert -- to click OK button
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();

        Assert.assertTrue(page.success.isDisplayed());


    }

}
