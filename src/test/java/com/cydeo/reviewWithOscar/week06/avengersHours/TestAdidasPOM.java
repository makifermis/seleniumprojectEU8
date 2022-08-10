package com.cydeo.reviewWithOscar.week06.avengersHours;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.ReviewUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestAdidasPOM {
    ProductPage page;
    @BeforeMethod
    public void testSetUp(){
        Driver.getDriver().get("https://www.demoblaze.com/index.html");
        page = new ProductPage();
    }

    @AfterMethod
    public void testTearDown(){
        Driver.closeDriver();
    }

    @Test
    public void Test(){

        /*
        Navigate to home page
        click Laptops, and  assert that the list of Laptops match expected
         */




        page.getLink("Laptops");

        List<String> expectedProducts = new ArrayList<>();
        expectedProducts.addAll(Arrays.asList("Sony vaio i5","Sony vaio i7","MacBook air","Dell i7 8gb","2017 Dell 15.6 Inch","MacBook Pro"));

        for (WebElement product : page.products) {
            System.out.println(product.getText());
        }

        List<String> actualProducts = ReviewUtils.getElementsTexts(page.products);
        Collections.sort(expectedProducts);
        Collections.sort(actualProducts);

        Assert.assertEquals(actualProducts,expectedProducts);



    }

    @Test
    public void Test2(){
        /*
        Go to home page
        click on Sony Vaio i7
        and verify the product price is 790
         */
        page.getLink("Laptops");
        page.getLink("Sony vaio i7");

        double expectedPrice = 790;

        double actualPrice = page.productPrice();

        Assert.assertEquals(actualPrice,expectedPrice);
    }

}
/*
You have to implement the following Web automated checks over our DEMO ONLINE
    SHOP: https://www.demoblaze.com/index.html
    • Customer navigation through product categories: Phones, Laptops and Monitors
    • Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.  --- Create a custom method for adding products
    • Navigate to "Laptop" → "Dell i7 8gb" and click on "Add to cart". Accept pop up confirmation.
    • Click on "Place order".
    • Fill in all web form fields. ----USE JavaFaker---create a fillForm() custom method
    • Click on "Purchase"
    • Capture and log purchase Id and Amount.
    • Assert purchase amount equals expected.
    • Click on "Ok"

Extra Practice : create a productRemover method to utility, and this method should return removed products price, so that we can deduct from the expected price
 */
