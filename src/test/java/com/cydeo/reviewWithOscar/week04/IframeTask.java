package com.cydeo.reviewWithOscar.week04;

import com.cydeo.utilities.ReviewUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframeTask {

    //   //1. Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
    ////2. Switch to iframe.
    ////3. Get the text “Double-click me to change my text color.” and verify the text

    @Test
    public void iframeTest(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        driver.findElement(By.xpath("//div[@id='accept-choices']")).click();

        // we need to change frame

        driver.switchTo().frame("iframeResult");

        ReviewUtils.staticWait(2);
        WebElement demoElement = driver.findElement(By.id("demo"));
        String demoText = demoElement.getText();
        System.out.println("demoText = " + demoText);
        Assert.assertEquals(demoText, "Double-click me to change my text color.");
        driver.close();
    }

}
