package com.cydeo.myPractices;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CSSPractice {

    @Test
    public void CSSLocator(){
        Driver.getDriver().get("https://www.google.com");
        Driver.getDriver().findElement(By.cssSelector("#W0wltc")).click();
        Driver.getDriver().findElement(By.cssSelector("input[class='gLFyf gsfi']")).sendKeys("cydeo"+ Keys.ENTER);

        WebElement cydeoText = Driver.getDriver().findElement(By.cssSelector("a[href='https://cydeo.com/']>h3"));

        Assert.assertTrue(cydeoText.getText().equals("Cydeo"));
    }

}
