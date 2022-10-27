package com.stv.factory.factorypages;

import com.stv.framework.core.drivers.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class MainFactoryPage extends FactoryPage {

    @FindBy(id = "accountLink")
    private WebElement accountLink;

    @FindBy(xpath = "//button[contains(text(),'Accept All Cookies')]")
    private WebElement trustButton;

    @FindBy(xpath = "/html/body/div[7]/div/div/ul/li[2]/a")
    private WebElement cycle;

    @FindBy(xpath = "/html/body/div[7]/div/div/ul/li[2]/div/div[1]/div/div/div[1]/ul/div/div[1]/li[1]/a/span")
    private WebElement bikes;

    @FindBy(xpath = "/html/body/div[7]/div/div/ul/li[2]/div/div[1]/div/div/div[2]/ul/div/div[1]/li[1]/a/span")
    private WebElement roadBikes;

    public WebElement getRoadBikes() {
        return roadBikes;
    }

    public WebElement getCycle() {
        return cycle;
    }

    public WebElement getBikes() {
        return bikes;
    }

    public void goToRoadBikesPage(){
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(cycle);
        action.perform();

        action.moveToElement(bikes);

        action.perform();
        action.moveToElement(roadBikes).click();
        action.perform();
    }

    public boolean isAccountLinkDisplayed() {
        return accountLink.isDisplayed();
    }

    public void clickOnAccountLink() {
        accountLink.click();
    }

    public void clickOnTrustButton() {
        trustButton.click();
    }


}
