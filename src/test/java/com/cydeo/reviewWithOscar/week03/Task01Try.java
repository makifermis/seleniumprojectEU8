package com.cydeo.reviewWithOscar.week03;

import com.cydeo.utilities.ReviewUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task01Try {
    public static void main(String[] args) {
        WebDriver driver;

        /*
        1.    Go to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
2.    Login with-----Username: Tester, password: test
         */
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        //2.    Login with-----Username: Tester, password: test
        WebElement usernameSection = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        usernameSection.sendKeys("Tester");
        WebElement passwordSection = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        passwordSection.sendKeys("test"+ Keys.ENTER);

        WebElement checkAllButton = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_btnCheckAll']"));
        checkAllButton.click();

        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        int i = 1;
        for (WebElement checkBox : checkBoxes) {
            if (checkBox.isSelected()){
                System.out.println("Checkbox"+i+" is selected");
            }else{
                System.out.println("Checkbox"+i+" is not selected");
            }
            i++;
        }
        System.out.println("-------------------------------------------");


        //3.    Click on check all button verify all the checkboxes are checked
        WebElement uncheckAllButton = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_btnUncheckAll']"));
        uncheckAllButton.click();

        checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        int y = 1;
        for (WebElement checkBox : checkBoxes) {
            if (checkBox.isSelected()){
                System.out.println("Checkbox"+y+" is selected");
            }else{
                System.out.println("Checkbox"+y+" is not selected");
            }
            y++;
        }

        ReviewUtils.staticWait(1);

        driver.close();
    }

}
/*
1.    Go to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
2.    Login with-----Username: Tester, password: test

3.    Click on check all button verify all the checkboxes are checked
4.    Click on uncheck all button verify that all the checkboxes are unchecked
 */