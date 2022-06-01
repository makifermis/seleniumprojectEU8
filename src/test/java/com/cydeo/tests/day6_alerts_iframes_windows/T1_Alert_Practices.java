package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.ReviewUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_Alert_Practices {

    //TC #1: Information alert practice
    //1. Open browser
    //2. Go to website: http://practice.cydeo.com/javascript_alerts
    //3. Click to “Click for JS Alert” button
    //4. Click to OK button from the alert
    //5. Verify “You successfully clicked an alert” text is displayed.
    //TC #
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.get("http://practice.cydeo.com/javascript_alerts");
    }

    @Test
    public void alert_test1(){
        //3. Click to “Click for JS Alert” button
        WebElement informationAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        informationAlertButton.click();
        ReviewUtils.staticWait(2);
        //4. Click to OK button from the alert
        //To be able to click to Alert OK button we need to switch driver's focus to Alert itself
        Alert alert = driver.switchTo().alert();
        alert.accept();
        //5. Verify “You successfully clicked an alert” text is displayed.
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));

        //Failure message will only be displayed if assertion fails: "Result test is NOT displayed"
        Assert.assertTrue(resultText.isDisplayed(),"Result text is NOT displayed");
        String expectedText = "You successfully clicked an alert";
        String actualText = resultText.getText();
        Assert.assertEquals(actualText,expectedText,"Actual result test is not as expected!!!");
    }
    @Test
    public void alert_test2(){
        //1. Open browser
        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        //3. Click to “Click for JS Confirm” button
        WebElement confirmButton = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        //4. Click to OK button from the alert
        confirmButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        //5. Verify “You clicked: Ok” text is displayed.
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));
        String expectedText = "You clicked: Ok";
        String actualText = resultText.getText();

        Assert.assertEquals(actualText,expectedText,"Actual text is not correct!");
    }

    @Test
    public void alert_test3(){
        //1. Open browser
        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        //3. Click to “Click for JS Prompt” button
        WebElement JSPromtButton = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        JSPromtButton.click();
        //4. Send “hello” text to alert
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");

        //5. Click to OK button from the alert
        alert.accept();
        //6. Verify “You entered: hello” text is displayed.
        WebElement resultText = driver.findElement(By.xpath("//p[@id = 'result']"));
        String expectedResult = "You entered: hello";
        String actualResult = resultText.getText();

        Assert.assertEquals(actualResult,expectedResult,"Actual result is not the same with the expected one!!");
    }

}
