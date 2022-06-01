package com.cydeo.reviewWithOscar.week03;

import com.cydeo.utilities.ReviewUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebOrdersTests {

    //1.    Go to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
    //2.    Login with-----Username: Tester, password: test
    //
    //3.    Click on check all button verify all the checkboxes are checked
    //4.    Click on uncheck all button verify that all the checkboxes are unchecked
    //Test Case 2
    //1.    Go to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
    //2.    Login with-----Username: Tester, password: test
    //3.    Select one of the checkbox and delete one person
    //4.    Then verify that deleted item is no longer exists
    WebDriver driver;
    @BeforeMethod
    public void loginToWebOrders(){ // the name is up to you
        System.out.println("login steps for application");
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        WebElement userNameField = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        userNameField.sendKeys("Tester");
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        passwordField.sendKeys("test"+ Keys.ENTER);

    }

    @AfterMethod
    public void closeBrowser(){
        System.out.println("closing the browser for following test cases");
        driver.quit();
    }

    @Test
    public void checkBox(){
        System.out.println("Implementation step 3 and 4 of Test Case 1");
        WebElement checkAllButton = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_btnCheckAll']"));
        checkAllButton.click();

        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement checkbox : checkboxes) {
            Assert.assertTrue(checkbox.isSelected(),"CheckBox is NOT checked");

            }

        driver.findElement(By.xpath("//a[@id='ctl00_MainContent_btnUncheckAll']")).click();
        checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));// we need to relocate the elements again, otherwise we get Stale Element Reference exception
        for (WebElement checkbox : checkboxes) {
            Assert.assertFalse(checkbox.isSelected(),"CheckBox is still selected");
        }

        }

    @Test
    public void deletePersonTest(){
        System.out.println("Implementation step 3 and 4 of Test Case 2");
        String name = "Mark Smith";

        //td[.='Bob Feather']/../td[1]/input
        String locatorOfCheckBoxWithName = "//td[.='"+name+"']/../td[1]/input";
        WebElement checkBox = driver.findElement(By.xpath(locatorOfCheckBoxWithName));

        checkBox.click();// select the checkbox with click()

        // locate delete button and click

        driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();
        ReviewUtils.staticWait(2);

        // After we delete we can get all the names of the customers as a list, then verify that deleted name is not in the list
        // need to get all the names from the table
        // common locator: //tr//td[2]
        List<WebElement> namesElements = driver.findElements(By.xpath("//tr//td[2]"));

        for (WebElement namesElement : namesElements) {
           Assert.assertFalse(namesElement.getText().contains(name));
        }

        // you can do the same verification by checking the size of the list



    }

}
