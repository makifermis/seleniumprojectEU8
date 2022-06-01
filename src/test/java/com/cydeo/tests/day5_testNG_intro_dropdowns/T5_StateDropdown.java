package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.ReviewUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T5_StateDropdown {



    //Use all Select options. (visible text, value, index)

    WebDriver driver;
    @BeforeMethod
    public void setupBrowser(){
        //5: Selecting state from State dropdown and verifying result
        //1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/dropdown
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }

    @Test (priority = 1)
    public void selectStateVerify(){
        //3. Select Illinois
        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        stateDropdown.selectByValue("IL");
        ReviewUtils.staticWait(2);

        //4. Select Virginia
        stateDropdown.selectByVisibleText("Virginia");
        ReviewUtils.staticWait(2);
        //5. Select California
        stateDropdown.selectByIndex(5);
        ReviewUtils.staticWait(2);
        //6. Verify final selected option is California.
        String actualSelectedValue = stateDropdown.getFirstSelectedOption().getText();
        String expectedSelectedValue = "California";
        Assert.assertEquals(actualSelectedValue,expectedSelectedValue,"Selected value verification failed");
    }

    @Test(priority = 2)
    public void selectDateVerify(){
        //TC #6: Selecting date on dropdown and verifying
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/dropdown
        //3. Select “December 1st, 1923” and verify it is selected.
        //Select Year
        Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        yearDropdown.selectByVisibleText("1923");
        ReviewUtils.staticWait(1);
        //Verify selected year
        String actualYearValue = yearDropdown.getFirstSelectedOption().getText();
        String expectedYearValue = "1923";
        Assert.assertEquals(actualYearValue,expectedYearValue,"Year value verification failed!");
        //Select Month
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        monthDropdown.selectByValue("11");
        ReviewUtils.staticWait(1);
        //Verify selected month
        String actualMonthValue = monthDropdown.getFirstSelectedOption().getText();
        String expectedMonthValue = "December";
        Assert.assertEquals(actualMonthValue,expectedMonthValue,"Month value verification failed!");
        //Select Day
        Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        dayDropdown.selectByIndex(0);
        ReviewUtils.staticWait(1);
        //Verify selected day
        String actualDayValue = dayDropdown.getFirstSelectedOption().getText();
        String expectedDayValue = "1";
        Assert.assertEquals(actualDayValue,expectedDayValue,"Day value verification failed!");

        //Select year using : visible text
        //Select month using : value attribute
        //Select day using : index number
    }
    @Test
    //TC #7: Selecting value from non-select dropdown
    //1. Open Chrome browser
    //2. Go to https://practice.cydeo.com/dropdown
    //3. Click to non-select dropdown
    //4. Select Facebook from dropdown
    //5. Verify title is “Facebook - Log In or Sign Up”
    public void nonSelectDropdown(){
        //3. Click to non-select dropdown
        WebElement nonSelectDropDown = driver.findElement(By.xpath("//a[@role='button']"));
        nonSelectDropDown.click();
        ReviewUtils.staticWait(2);
        //4. Select Facebook from dropdown
        WebElement facebook = driver.findElement(By.xpath("//a[@href = 'https://www.facebook.com/']"));
        facebook.click();
        ReviewUtils.staticWait(2);
        //5. Verify title is “Facebook - Log In or Sign Up”
        String actualTitle = driver.getTitle();
        String expectedTitle = "Facebook - Log In or Sign Up";
        Assert.assertEquals(actualTitle,expectedTitle,"Title verification failed");

    }
    @Test
    public void multipleSelectDropdown(){
        //TC #8: Selecting value from multiple select dropdown
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/dropdown
        //3. Select all the options from multiple select dropdown.
        Select languages = new Select(driver.findElement(By.xpath("//select[@name]")));
        languages.selectByIndex(0);
        languages.selectByIndex(1);
        languages.selectByIndex(2);
        languages.selectByIndex(3);
        languages.selectByIndex(4);
        languages.selectByIndex(5);
        ReviewUtils.staticWait(3);
        //4. Print out all selected values.
        List<WebElement> languagesOptions = languages.getAllSelectedOptions();
        for (WebElement language : languagesOptions) {
            System.out.println(language.getText());
        }
        //5. Deselect all values.
        languages.deselectAll();
    }

}
