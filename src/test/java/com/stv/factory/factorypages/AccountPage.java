package com.stv.factory.factorypages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends FactoryPage {
    @FindBy(id = "btnSignOut")
    private WebElement signOutButton;

    @FindBy(className = "bem-myaccount__title")
    private WebElement welcomeTitle;

    public void clickSignOutButton() {
        signOutButton.click();
    }

    public boolean isWelcomeDisplayed() {
        return welcomeTitle.isDisplayed();
    }
}
