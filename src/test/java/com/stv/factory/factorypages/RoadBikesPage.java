package com.stv.factory.factorypages;

import com.stv.framework.core.drivers.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RoadBikesPage extends FactoryPage{
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    @FindBy(xpath = "//*[@id=\"listing-page-header-title-row\"]/div/h1")
    private WebElement title;

    @FindBy(xpath = "//*[@id=\"search-results\"]/div[1]/div/a[2]")
    private WebElement anyBike;

    @FindBy(xpath = "//*[@id=\"quickBuyBox\"]/form/div[3]/div[1]/div[3]/div/text/input")
    private WebElement quantity;

    @FindBy(id = "productTitle")
    private WebElement bikeTitle;

    @FindBy(id = "quickBuyButton")
    private WebElement quickBuyButton;

    @FindBy(xpath = "//*[@id=\"quickBuyBox\"]/form/div[3]/div[5]/span")
    private WebElement error;

    @FindBy(xpath = "//*[@id=\"breadcrumbs\"]/ol/li[1]/a")
    private WebElement homeLink;

    public void clickOnQuickBuyButton(){
        quickBuyButton.click();
    }

    public void clickHomeLink(){
        js.executeScript("window.scrollTo(0,0)");
        homeLink.click();
    }

    public boolean errorIsDisplayed(){
        return error.isDisplayed();
    }

    public void increaseQuantity(){
        js.executeScript("window.scrollTo(0,1000)");
        quantity.sendKeys("3");
    }

    public void clickAnyBike(){
        anyBike.click();
    }

    public boolean isTitleDisplayed(){
        return title.isDisplayed();
    }

    public boolean isBikeTitleDisplayed(){
        return bikeTitle.isDisplayed();
    }

}
