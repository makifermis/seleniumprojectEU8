package com.cydeo.reviewWithOscar.week02;

import com.cydeo.utilities.ReviewUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task01 {

    public static void main(String[] args) {

        //open chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //go to https://practice.cydeo.com/
        driver.get("https://practice.cydeo.com/");
        //then click on "forgot_password" link
        WebElement forgotPasswordButton = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[20]/a"));
        forgotPasswordButton.click();
        //enter any email
        WebElement emailBox = driver.findElement(By.name("email"));
        String expectedEmail = "abc@gmail.com";
        emailBox.sendKeys(expectedEmail);
        //verify that email is displayed in the input box
        String actualEmail = emailBox.getAttribute("value");
        //System.out.println("actualEmail = " + actualEmail);
        if (actualEmail.equalsIgnoreCase(expectedEmail)){
            System.out.println("Email verification PASSED!");
        } else {
            System.out.println("Email verification FAILED!");
        }

        //click on Retrieve password
        WebElement retrievePasswordButton = driver.findElement(By.className("radius"));
        retrievePasswordButton.click();
        //verify that confirmation message says 'Your e-mail's been sent!'
        WebElement confirmationMessage = driver.findElement(By.tagName("h4"));
        String actualConfirmationMessage = confirmationMessage.getText();
        String expectedConfirmationMessage = "Your e-mail's been sent!";

        if (actualConfirmationMessage.equals(expectedConfirmationMessage)){
            System.out.println("Confirmation message test PASSED!");
        }else{
            System.out.println("Confirmation message test FAILED!");
        }

        ReviewUtils.staticWait(2);
        driver.close();



    }

}
