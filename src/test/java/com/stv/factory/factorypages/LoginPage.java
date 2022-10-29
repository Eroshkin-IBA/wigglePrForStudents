package com.stv.factory.factorypages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends FactoryPage {
    @FindBy(className = "bem-checkout__login-container")
    private WebElement loginContainer;

    @FindBy(id = "LogOnModel_UserName")
    private WebElement emailInput;

    @FindBy(id = "LogOnModel_Password")
    private WebElement passwordInput;

    @FindBy(id = "qa-login")
    private WebElement signInButton;

    @FindBy(className = "bem-alert--danger")
    private WebElement loginErrorMessage;

    @FindBy(id = "btnSignOut")
    private WebElement signOutButton;

    @FindBy(id = "DualRegisterEmailModel_Email")
    private WebElement registerEmail;

    @FindBy(id = "qa-dual-register")
    private WebElement continueButton;



    public void clickSignOutButton() {
        signOutButton.click();
    }



    public void registerEmail(String email) {
        registerEmail.sendKeys(email);
        continueButton.click();
    }

    public void enterEmail(String e){
        emailInput.sendKeys(e);
    }

    public void enterPassword(String p){
        passwordInput.sendKeys(p);
    }


    public void signIn(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        signInButton.click();
    }

    public void clickSignIn(){
        signInButton.click();
    }

    public boolean isErrorMessageDisplayed() {
        return loginErrorMessage.isDisplayed();
    }


    public boolean isLoginContainerDisplayed() {
        return loginContainer.isDisplayed();
    }
}
