package com.cydeo.reviewWithOscar.week02;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task02 {

    public static void main(String[] args) {

        //@student Basic login authentication
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //- Go to:  http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        //- Verify title equals: String expectedTitle = "Web Orders Login"
        String expectedTitleBeforeLogin = "Web Orders Login";
        if (expectedTitleBeforeLogin.equals(driver.getTitle())){
            System.out.println("Before login title test Passed!");
        }else{
            System.out.println("Before login title test Failed!");
        }
        //- Enter username: Tester
        WebElement usernameBox = driver.findElement(By.id("ctl00_MainContent_username"));
        usernameBox.sendKeys("Tester");
        //- Enter password: test
        WebElement passwordBox = driver.findElement(By.id("ctl00_MainContent_password"));
        passwordBox.sendKeys("test");
        //- Click “Sign In” button
        WebElement signInButton = driver.findElement(By.id("ctl00_MainContent_login_button"));
        signInButton.click();
        //- Verify title equals: String expectedHomePageTitle = "Web Orders"
        WebElement HomePageTitle = driver.findElement(By.tagName("h1"));
        String actualHomePageTitle = HomePageTitle.getText();
        String expectedHomePageTitle = "Web Orders";
        if (actualHomePageTitle.equals(expectedHomePageTitle)){
            System.out.println("Home page title verification Passed!");
        }else{
            System.out.println("Home page title verification");
        }

        driver.close();

    }

}
