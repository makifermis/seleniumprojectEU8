package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T6_HW_EtsyTitleVerification {

    public static void main(String[] args) {

        //TC #1: Etsy Title Verification
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //2. Go to https://www.etsy.com
        driver.get("https://www.etsy.com");
        WebElement acceptButton = driver.findElement(By.cssSelector("button[class='wt-btn wt-btn--filled wt-mb-xs-0']"));
        acceptButton.click();
        //3. Search for “wooden spoon”
        WebElement searchButton = driver.findElement(By.id("global-enhancements-search-query"));
        searchButton.sendKeys("Wooden spoon" + Keys.ENTER);
        //4. Verify title:
        String expectedTitle = "Wooden spoon | Etsy";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)){
            System.out.println("After search title test Passed!");
        }else{
            System.out.println("After search title test Failed!");
        }
        //Expected: “Wooden spoon | Etsy”

        driver.close();
    }
}
