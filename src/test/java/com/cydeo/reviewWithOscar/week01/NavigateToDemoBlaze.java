package com.cydeo.reviewWithOscar.week01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateToDemoBlaze {

    public static void main(String[] args) {

        // https://www.demoblaze.com/index.html
        // Verify the Title "STORE"

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();// this line opens an empty Chrome webPage

       driver.get("https://www.demoblaze.com/index.html");

        //driver.navigate().to("https://www.demoblaze.com/index.html");
        String expectedTitle = "STORE";// comes from documentation, SRS: system requirements

        String actualTitle = driver.getTitle();

        //As a tester, without validation what is your VALUE to the Company
        if (actualTitle.equalsIgnoreCase(expectedTitle)){
            System.out.println("Title = "+ driver.getTitle()+"--> Test passed!");
        }else{
            System.out.println("Title = "+ driver.getTitle()+"--> Test failed!");
        }
    }
}
