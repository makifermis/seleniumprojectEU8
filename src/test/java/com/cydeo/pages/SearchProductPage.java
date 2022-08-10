package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchProductPage {

    public SearchProductPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[.=' Home']")
    public WebElement homeLink;

    @FindBy(xpath = "//a[text()=' Products']")
    public WebElement productLink;

    @FindBy(xpath = "//h2[@class='title text-center']")
    public WebElement allProductText;

    @FindBy(id = "search_product")
    public WebElement searchBox;

    @FindBy(id = "submit_search")
    public WebElement searchButton;

    @FindBy(xpath = "//div[@class='col-sm-4']")
    public List<WebElement> allProducts;

}
