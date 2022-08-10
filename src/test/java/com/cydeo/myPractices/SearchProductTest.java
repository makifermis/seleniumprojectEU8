package com.cydeo.myPractices;

import com.cydeo.pages.SearchProductPage;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchProductTest {

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get("https://automationexercise.com/");
    }

    @Test
    public void searchProduct(){
        SearchProductPage searchProductPage = new SearchProductPage();
        //Verify that home page is visible successfully
        Assert.assertTrue(searchProductPage.homeLink.isDisplayed());

        //Click on 'Products' button
        searchProductPage.productLink.click();

        // Verify user is navigated to ALL PRODUCTS page successfully
        String expectedText = "ALL PRODUCTS";
        String actualText = searchProductPage.allProductText.getText();

        Assert.assertEquals(actualText,expectedText);


        //Enter product name in search input and click search button

        //Faker faker = new Faker();

        searchProductPage.searchBox.sendKeys("tshirt");

        searchProductPage.searchButton.click();

        //Verify all the products related to search are visible
        for (WebElement eachProduct : searchProductPage.allProducts) {
            Assert.assertTrue(eachProduct.isDisplayed());
        }

    }

}
/*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Products' button
5. Verify user is navigated to ALL PRODUCTS page successfully
6. Enter product name in search input and click search button
7. Verify 'SEARCHED PRODUCTS' is visible
8. Verify all the products related to search are visible
 */