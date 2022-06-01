package com.cydeo.reviewWeek;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterUser {

    static WebDriver driver;

    @Test
    public void registerUser(){
        driver = Driver.getDriver();
        driver.get("http://automationexercise.com/");

        String expectedTitle = "Automation Exercise";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);

        driver.findElement(By.xpath("//a[.=' Signup / Login']")).click();

        String expectedText = "New User Signup!";
        String actualText = driver.findElement(By.xpath("//h2[.='New User Signup!']")).getText();

        Assert.assertEquals(actualText,expectedText);
/*
        WebElement nameBox = driver.findElement(By.xpath("//input[@name='name']"));
        nameBox.sendKeys("ahmet");

 */

        WebElement emailBox = driver.findElement(By.xpath("//input[@data-qa='login-email']"));

        emailBox.sendKeys("ahmetkural@gmail.com");

        WebElement loginPassword = driver.findElement(By.xpath("//input[@data-qa='login-password']"));

        loginPassword.sendKeys("ahmetkural");

        driver.findElement(By.xpath("//button[.='Login']")).click();

        driver.findElement(By.xpath("//a[.=' Delete Account']")).click();

        driver.findElement(By.xpath("//button[@title='Make a DELETE request on the Delete Account resource']")).click();


/*Account creating section

        String expectedAccountInfo = "ENTER ACCOUNT INFORMATION";
        String actualAccountInfo = driver.findElement(By.xpath("//b[.='Enter Account Information']")).getText();

        Assert.assertEquals(actualAccountInfo,expectedAccountInfo);

        driver.findElement(By.xpath("//input[@value='Mr']")).click();

        WebElement passwordBox = driver.findElement(By.xpath("//input[@type='password']"));
        passwordBox.sendKeys("ahmetkural");

        Select selectDay = new Select(driver.findElement(By.xpath("//select[@name='days']")));

        selectDay.selectByValue("10");

        Select selectMonth = new Select(driver.findElement(By.xpath("//select[@name='months']")));

        selectMonth.selectByVisibleText("September");

        Select selectYear = new Select(driver.findElement(By.xpath("//select[@name='years']")));
        selectYear.selectByValue("1983");

        driver.findElement(By.xpath("//input[@name='newsletter']")).click();
        driver.findElement(By.xpath("//input[@name='optin']")).click();

        WebElement firstName = driver.findElement(By.xpath("//input[@id='first_name']"));
        firstName.sendKeys("ahmet");

        WebElement lastName = driver.findElement(By.xpath("//input[@id='last_name']"));
        lastName.sendKeys("kural");

        WebElement address = driver.findElement(By.xpath("//input[@id='address1']"));
        address.sendKeys("12 Chemin Bel Air");

        Select select = new Select(driver.findElement(By.xpath("//select[@id='country']")));
        select.selectByValue("United States");

        WebElement state = driver.findElement(By.xpath("//input[@id='state']"));
        state.sendKeys("Florida");

        WebElement city = driver.findElement(By.xpath("//input[@id='city']"));
        city.sendKeys("Toulouse");

        WebElement zip = driver.findElement(By.xpath("//input[@id='zipcode']"));
        zip.sendKeys("31770");

        WebElement mobile = driver.findElement(By.xpath("//input[@id='mobile_number']"));
        mobile.sendKeys("0613618478");

        driver.findElement(By.xpath("//button[.='Create Account']")).click();


        String expectedText2 = "ACCOUNT CREATED!";
        String actualText2 = driver.findElement(By.xpath("//b[.='Account Created!']")).getText();

        Assert.assertEquals(actualText2,expectedText2);

 */

    }

}
