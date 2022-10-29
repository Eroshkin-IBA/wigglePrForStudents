package com.stv.bdd_framework.steps;

import com.stv.factory.factorypages.AccountPage;
import com.stv.factory.factorypages.LoginPage;
import com.stv.factory.factorypages.MainFactoryPage;
import com.stv.factory.factorypages.RoadBikesPage;
import com.stv.factory.factorytests.BasicFactoryTest;
import com.stv.framework.core.drivers.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static com.stv.framework.core.lib.WigglePageURLs.LOGIN_URL;
import static com.stv.framework.core.lib.WigglePageURLs.START_URL;

public class Steps {

    String email = "freerun4ik1998@gmail.com";
    String password = "@freerun4ik";

    //final task steps

    public static WebDriver getDriver() {
        return Driver.getDriver();
    }

    public void waitPage() {
        getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    MainFactoryPage mainFactoryPage = new MainFactoryPage();
    RoadBikesPage roadBikesPage = new RoadBikesPage();
    LoginPage loginPage = new LoginPage();
    AccountPage accountPage = new AccountPage();

    @Given("^opened mainPage$")
    public void setUp() {
        WebDriver driver = getDriver();
        driver.get(START_URL);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        mainFactoryPage.clickOnTrustButton();

    }

    @When("^go to road bikes page$")
    public void bikesPage() {

        mainFactoryPage.goToRoadBikesPage();

    }

    @Then("^road bikes page is opened$")
    public void roadBikesPageIsOpened() {

        Assert.assertEquals(roadBikesPage.isTitleDisplayed(), true);

    }

    @When("^choose any bike$")
    public void chooseAnyBike() {
        roadBikesPage.clickAnyBike();
    }

    @Then("^chosen bike is opened$")
    public void chosenBikesIsOpened() {

        Assert.assertEquals(roadBikesPage.isBikeTitleDisplayed(), true);

    }

    @And("^increase quantity$")
    public void increase() {
        roadBikesPage.increaseQuantity();
    }

    @When("^add to basket$")
    public void addToBasket() {
        roadBikesPage.clickOnQuickBuyButton();

    }

    @Then("^error is displayed$")
    public void errorIsDisplayed() {
        Assert.assertEquals(roadBikesPage.errorIsDisplayed(), true);
    }

    @And("^return to main page$")
    public void goHome() {
        waitPage();
        roadBikesPage.clickHomeLink();
    }

    // homework steps

    @Given("login page")
            public void loginPage()
    {
        getDriver().get(LOGIN_URL);
    }

    @And("^go to login page$")
    public void goToLoginPage() {
        mainFactoryPage.clickOnAccountLink();
    }

    @When("customer enters incorrect email {string}")
    public void enterEmail(String email) {
        loginPage.enterEmail(email);
    }

    @And("enters incorrect password {string}")
    public void enterPassword(String p) {
        loginPage.enterPassword(p);
    }

    @And("^clicks \"Sign in securely\"$")
    public void signIn() {
        loginPage.clickSignIn();
    }

    @Then("^error message appears$")
    public void isErrorMessageDisplayed() {
        Assert.assertEquals(loginPage.isErrorMessageDisplayed(), true);

    }


    @Then("account page is opened")
    public void accountPageIsOpened() {
        Assert.assertEquals(accountPage.isWelcomeDisplayed(), true);
    }

    @When("customer enters correct email and password")
    public void customerEntersCorrectEmailAndPassword() {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    @And("logout")
    public void logout() {
        accountPage.clickSignOutButton();
    }
}
