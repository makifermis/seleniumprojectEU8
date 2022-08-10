package com.cydeo.reviewWithOscar.week06.webstaurantTask;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.ReviewUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTes {
    @Test
    public void Test(){
        Driver.getDriver().get("https://www.webstaurantstore.com/");

        SearchResultPage page = new SearchResultPage();
        ReviewUtils.staticWait(2);
        page.firstAlert.click();
        page.searchBox.sendKeys("Stainless Work Table"+ Keys.ENTER);

        List<WebElement> resultList = page.resultList;

        for (WebElement eachElement : resultList) {
            Assert.assertTrue(eachElement.getText().toLowerCase().contains("table"));
        }

        List<WebElement> inStockItems = page.inStockItems;

        inStockItems.get(inStockItems.size()-1).click();

// .ElementClickInterceptedException: element click intercepted:  WE need to handle the HTML Alert

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(page.cart).perform();
        page.closeAlert.click();

        ReviewUtils.staticWait(1);

        page.cart.click();

        page.emptyCart.click();

        page.emptyCartVerification.click();

        Assert.assertTrue(page.cartEmptyMessage.isDisplayed());

    }
}
/*
Go to https://www.webstaurantstore.com/
Search for 'stainless work table'
Check the search result ensuring every product has the word 'Table' in its title
Add the last of found items to Cart.
Empty Cart.
 */