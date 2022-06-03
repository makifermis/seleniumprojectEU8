package com.cydeo.reviewWeek;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginUserWithCorrectCredentials {
    WebDriver driver;
    @Test
    public void login_test(){
        driver =Driver.getDriver();
        driver.get("http://automationexercise.com");

        String expectedTitle ="Automation Exercise";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

        driver.findElement(By.xpath("//a[.=' Signup / Login']")).click();

        WebElement loginTag = driver.findElement(By.xpath("//h2[.='Login to your account']"));
        String expectedText = "Login to your account";
        String actualText = loginTag.getText();

        Assert.assertEquals(actualText,expectedText);

        WebElement emailBox = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        emailBox.sendKeys("ahmetkural@gmail.com");

        WebElement passwordBox = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        passwordBox.sendKeys("ahmetkural");

        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        WebElement loginName = driver.findElement(By.xpath("//i[@class='fa fa-user']/../.."));
        String expectedName = "Logged in as ahmet";
        String actualName = loginName.getText();

        Assert.assertEquals(actualName,expectedName);

        driver.findElement(By.xpath("//a[.=' Delete Account']")).click();

    }



}
