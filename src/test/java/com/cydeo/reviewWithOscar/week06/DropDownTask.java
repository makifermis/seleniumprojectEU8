package com.cydeo.reviewWithOscar.week06;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.ReviewUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDownTask {

    //Task3:
    //    1. Go to:  http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    //    2. Login with username: Tester, password: test
    //    3. Click  Order button
    //    4. Verify under Product Information, selected option is “MyMoney”
    //    5. Then select FamilyAlbum, make quantity 2, and click Calculate,
    //    6. Then verify Total is equal to Quantity*PricePerUnit

    @Test
    public void Task03(){
        // Go to page
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        // Login
        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        Driver.getDriver().findElement(By.id("ctl00_MainContent_password")).sendKeys("test", Keys.ENTER);

        // click on Order
        Driver.getDriver().findElement(By.xpath("//a[text()='Order']")).click();

        Select select = new Select(Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
        String expectedSelected = "MyMoney";
        String actualSelected = select.getFirstSelectedOption().getText();

        //4. Verify under Product Information, selected option is “MyMoney”
        Assert.assertEquals(actualSelected,expectedSelected, "Default Option Test Failed");
        //5. Then select FamilyAlbum, make quantity 2, and click Calculate,
        select.selectByValue("FamilyAlbum");
        ReviewUtils.staticWait(2);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"FamilyAlbum");

        WebElement quantity = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        Actions actions = new Actions(Driver.getDriver());
        actions.doubleClick(quantity).sendKeys("2").perform();
        Driver.getDriver().findElement(By.xpath("//input[@value = 'Calculate']")).click();
        ReviewUtils.staticWait(2);

        Assert.assertEquals(Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_txtTotal")).getAttribute("value"), "160");


    }

}
