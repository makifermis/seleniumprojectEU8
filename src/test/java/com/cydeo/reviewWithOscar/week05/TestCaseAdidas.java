package com.cydeo.reviewWithOscar.week05;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.ReviewUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseAdidas extends TestBase {

    @Test
    public void Test(){
        double expectedPrice = 0;
        driver.get("https://www.demoblaze.com/index.html");
        // ConfigurationReader.getProperty("category1") ----> returns Laptops
        expectedPrice += ReviewUtils.addProduct(driver, ConfigurationReader.getProperty("category1"),"Sony vaio i5");
        // go back to home
        ReviewUtils.getLink(driver,"Home");
        ReviewUtils.staticWait(1);
        expectedPrice += ReviewUtils.addProduct(driver,ConfigurationReader.getProperty("category2"),"Samsung galaxy s6");
        // go to Cart
        ReviewUtils.getLink(driver,"Cart");
        ReviewUtils.staticWait(3); // PUT 3 second waiting time

        // Control the expected price
        System.out.println("expectedPrice = " + expectedPrice);
        ReviewUtils.staticWait(2);

        //remove one product and substract the amount of the removed product from the expected price
        double reducedPrice = ReviewUtils.productRemover(driver,"Sony vaio i5");
        expectedPrice -= reducedPrice;

        ReviewUtils.staticWait(3);
        // take the last cartPrice
        double cartPrice = Double.parseDouble(driver.findElement(By.id("totalp")).getText());

        ReviewUtils.staticWait(3);
        // click 'Place Order' button
        driver.findElement(By.xpath("//button[.='Place Order']")).click();

        ReviewUtils.staticWait(3);
        // fill in the form with fillForm method
        ReviewUtils.fillForm(driver);

        String confirmationText = driver.findElement(By.xpath("//p[@class='lead text-muted ']")).getText();

        String IDtext = driver.findElement(By.xpath("//p[@class='lead text-muted ']//br")).getText();
        System.out.println("IDtext = " + IDtext);
        System.out.println("confirmationText = " + confirmationText);
       /*
    Id: 8761753
    Amount: 1150 USD
    Card Number: 3436-094090-48661
    Name: Mrs. Tracey Kuhlman
    Date: 4/5/2022
        */

        String ID = confirmationText.split("\n")[0];
        double actualPrice = Double.parseDouble(confirmationText.split("\n")[1].split(" ")[1]);

        System.out.println(ID);
        System.out.println("actualPrice = " + actualPrice);
        System.out.println("expectedPrice = " + expectedPrice);
        System.out.println("cartPrice = " + cartPrice);

        Assert.assertEquals(actualPrice,expectedPrice);
        Assert.assertEquals(cartPrice,expectedPrice);
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