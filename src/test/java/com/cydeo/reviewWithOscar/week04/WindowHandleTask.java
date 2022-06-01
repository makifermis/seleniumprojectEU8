package com.cydeo.reviewWithOscar.week04;

import com.cydeo.utilities.ReviewUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandleTask {

     /*
    automate the following scenarios for this website https://shino.de/parkcalc/
Scenario 1)
-  Using the Valet parking lot, set today as the entry date & time and tomorrow as the exit giving a full 24 hour window (you can attempt to use the DatePicker).
     */

    @Test
    public void windowHandleTask(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://shino.de/parkcalc/");

        ReviewUtils.staticWait(1);

        //click on first calendar
        driver.findElement(By.xpath("(//img[@alt='Pick a date'])[1]")).click();

        //get all the opened windows handles
        Set<String> windowHandles = driver.getWindowHandles();
        //System.out.println("windowHandles = " + windowHandles);

        // get your current windowHandle
        String mainWindowHandle =    driver.getWindowHandle();

        //to switch to window which we are NOT at
        for (String eachWindowHandle : windowHandles) {
            if (!eachWindowHandle.equals(mainWindowHandle)){
                driver.switchTo().window(eachWindowHandle);
            }
        }

        //click on the element at the second window
        driver.findElement(By.linkText("24")).click();// the window closes itself, however I am still inside that closed window programatically

        ReviewUtils.staticWait(3);

        driver.switchTo().window(mainWindowHandle);

        //click on second calendar
        driver.findElement(By.xpath("(//img[@alt='Pick a date'])[2]")).click();

         windowHandles = driver.getWindowHandles();
        //System.out.println("windowHandles = " + windowHandles);


        ReviewUtils.staticWait(1);

        //to switch to window which we are NOT at
        for (String eachWindowHandle : windowHandles) {
            if (!eachWindowHandle.equals(mainWindowHandle)){
                driver.switchTo().window(eachWindowHandle);
            }
        }

        //click on the element at the second window
        driver.findElement(By.linkText("25")).click();// the window closes itself, however I am still inside that closed window programatically

        ReviewUtils.staticWait(3);

        driver.switchTo().window(mainWindowHandle);

        driver.findElement(By.xpath("//input[@value='Calculate']")).click();

        ReviewUtils.staticWait(3);

        driver.quit();
    }
}
