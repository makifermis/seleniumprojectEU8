package com.cydeo.myPractices;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.ReviewUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmartBear {

    @Test
    public void smartbear_software_order_placing(){
        // 1. Open browser
        //    2. Go to website:
        //    http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        //    3. Enter username: “Tester”
        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        //    4. Enter password: “test”
        Driver.getDriver().findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        //    5. Click on Login button
        Driver.getDriver().findElement(By.id("ctl00_MainContent_login_button")).click();
        //    6. Click on Order
        Driver.getDriver().findElement(By.xpath("//a[text()='Order']")).click();

        //    7. Select familyAlbum from product, set quantity to 2
        Select select = new Select(Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
        select.selectByValue("FamilyAlbum");

        WebElement quantity = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        quantity.clear();
        ReviewUtils.staticWait(2);
        quantity.sendKeys("2");

        //    8. Click to “Calculate” button
        Driver.getDriver().findElement(By.xpath("//input[@value = 'Calculate']")).click();

        //    9. Fill address Info with JavaFaker
        Faker faker = new Faker();
        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys(faker.name().fullName());
        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys(faker.address().streetName());
        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys(faker.address().city());
        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys(faker.address().state());
        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(faker.numerify("#####"));

        //    • Generate: name, street, city, state, zip code
        //    10. Click on “visa” radio button
        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
        //    11. Generate card number using JavaFaker
        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(faker.numerify("################"));
        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys(faker.numerify("12/30"));
        //    12. Click on “Process”
        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
        //    13. Verify success message “New order has been successfully added.”
        String expectedText = "New order has been successfully added.";
        String actualText = Driver.getDriver().findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']/../strong")).getText();

        Assert.assertEquals(actualText,expectedText);
    }

}
/*
 Task 2: Homework
    Smartbear software order placing
    1. Open browser
    2. Go to website:
    http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    3. Enter username: “Tester”
    4. Enter password: “test”
    5. Click on Login button
    6. Click on Order
    7. Select familyAlbum from product, set quantity to 2
    8. Click to “Calculate” button
    9. Fill address Info with JavaFaker
    • Generate: name, street, city, state, zip code
    10. Click on “visa” radio button
    11. Generate card number using JavaFaker
    12. Click on “Process”
    13. Verify success message “New order has been successfully added.”
 */