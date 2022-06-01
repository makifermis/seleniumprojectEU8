package com.cydeo.reviewWithOscar.week04;

import com.cydeo.utilities.ReviewUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertTaskTry {
    WebDriver driver;

    @BeforeMethod
    public void setupBrowser(){
        // /*
        //    You have to implement the following Web automated checks over our DEMO ONLINE SHOP: https://www.demoblaze.com/index.html
        //• Customer navigation through product categories: Phones, Laptops and Monitors
        //• Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.
        //     */
        //1. Open Browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }
    @Test
    public void alertPractice(){
        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.get("https://www.demoblaze.com/index.html");
        //• Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.
        WebElement laptops = driver.findElement(By.xpath("//a[.='Laptops']"));
        laptops.click();

        ReviewUtils.staticWait(1);
        WebElement sonyClick = driver.findElement(By.xpath("//a[.='Sony vaio i5']"));
        sonyClick.click();

        WebElement addToCart = driver.findElement(By.xpath("//a[.='Add to cart']"));
        addToCart.click();

        ReviewUtils.staticWait(1);

        //Accept pop up confirmation
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    //• Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.

    @Test
    public void iframeTask(){
        // //1. Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        //Accept privacy policy
        driver.findElement(By.xpath("//div[@id='accept-choices']")).click();

        ////2. Switch to iframe.
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='iframeResult']")));
        WebElement textResult = driver.findElement(By.xpath("//p[.='Double-click me to change my text color.']"));

        ////3. Get the text “Double-click me to change my text color.” and verify the text
        String expectedTextResult = "Double-click me to change my text color.";
        String actualTextResult = textResult.getText();

        Assert.assertEquals(actualTextResult,expectedTextResult,"Actual text is not as expected!! Fail!");
        //}
    }


    @AfterMethod
    public void closeBrowser(){
        ReviewUtils.staticWait(2);
        //driver.close();
    }
}
