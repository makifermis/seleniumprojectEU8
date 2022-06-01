package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T8_HW_BackAndForthNavigation {

    public static void main(String[] args) {

        //TC #3: Back and forth navigation
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //2- Go to: https://google.com
        driver.get("https://google.com");
        WebElement acceptButton = driver.findElement(By.id("L2AGLb"));
        acceptButton.click();
        //3- Click to Gmail from top right.
        WebElement gmailButton = driver.findElement(By.linkText("Gmail"));
        gmailButton.click();
        //4- Verify title contains:
        String actualGmailTitle = driver.getTitle();
        String expectedGmailTitle = "Gmail";
        if (actualGmailTitle.contains(expectedGmailTitle)){
            System.out.println("Gmail title verification Passed!");
        }else{
            System.out.println("Gmail title verification Failed!");
        }
        //Expected: Gmail
        //5- Go back to Google by using the .back();
        driver.navigate().back();
        //6- Verify title equals:
        String actualGoogleTitle = driver.getTitle();
        String expectedGoogleTitle = "Google";


        if (actualGoogleTitle.equals(expectedGoogleTitle)){
            System.out.println("Google title test Passed!");
        }else{
            System.out.println("Google title test Failed!");
        }

        //Expected: Google

        driver.close();


    }

}
