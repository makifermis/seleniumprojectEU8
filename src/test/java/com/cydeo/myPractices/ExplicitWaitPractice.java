package com.cydeo.myPractices;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class ExplicitWaitPractice {

    @Test
    public void test_WaitForExpectedTitle(){
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading");
        Driver.getDriver().findElement(By.partialLinkText("Example 7")).click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(titleIs("Dynamic title"));

        Assert.assertTrue(Driver.getDriver().getTitle().equals("Dynamic title"));


    }

}
