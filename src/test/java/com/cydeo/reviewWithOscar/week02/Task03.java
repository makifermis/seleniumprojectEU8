package com.cydeo.reviewWithOscar.week02;

import com.cydeo.utilities.ReviewUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task03 {

    public static void main(String[] args) {

        //Task 3:
        //You have to implement the following Web automated checks over our DEMO ONLINE SHOP: https://www.demoblaze.com/index.html
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/index.html");

        //    • Customer navigation through product categories: Phones, Laptops and Monitors
        ReviewUtils.staticWait(3);
        WebElement laptopsButton = driver.findElement(By.id("itemc"));
        laptopsButton.click();

        //    Navigate to "Laptop" → "Sony vaio i5" and verify the price is 790 dollars
        driver.findElement(By.partialLinkText("Sony vaio i5")).click();

        ReviewUtils.staticWait(3);

        int expectedPrice = 790;
        String priceText = driver.findElement(By.tagName("h3")).getText();

       int actualPrice = Integer.parseInt(priceText.split(" ")[0].substring(1));

       if (expectedPrice==actualPrice){
           System.out.println("Passed");
       }else{
           System.out.println("Failed");
       }

       driver.close();


    }

}
