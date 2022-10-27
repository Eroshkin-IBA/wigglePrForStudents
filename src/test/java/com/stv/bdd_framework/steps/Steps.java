package com.stv.bdd_framework.steps;

import com.stv.factory.factorypages.LoginPage;
import com.stv.factory.factorypages.MainFactoryPage;
import com.stv.factory.factorypages.RoadBikesPage;
import com.stv.factory.factorytests.BasicFactoryTest;
import com.stv.framework.core.drivers.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static com.stv.framework.core.lib.WigglePageURLs.LOGIN_URL;
import static com.stv.framework.core.lib.WigglePageURLs.START_URL;

public class Steps  {
    public static WebDriver getDriver() {
        return Driver.getDriver();
    }
    public void waitPage(){
        getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
    MainFactoryPage mainFactoryPage = new MainFactoryPage();
    RoadBikesPage roadBikesPage = new RoadBikesPage();
    LoginPage loginPage = new LoginPage();

    @Given("^opened mainPage$")
    public void setUp() {
        WebDriver driver = getDriver();
        driver.get(START_URL);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);



        mainFactoryPage.clickOnTrustButton();

    }

    @And("^go to road bikes page$")
    public void bikesPage() {

        mainFactoryPage.goToRoadBikesPage();

    }

    @Then("^road bikes page is opened$")
    public void roadBikesPageIsOpened() {

        Assert.assertEquals(roadBikesPage.isTitleDisplayed(), true);

    }

    @And("^choose any bike$")
    public void chooseAnyBike(){
        roadBikesPage.clickAnyBike();
    }

    @Then("^chosen bike is opened$")
    public void chosenBikesIsOpened() {

        Assert.assertEquals(roadBikesPage.isBikeTitleDisplayed(), true);

    }

    @And("^increase quantity$")
    public void increase(){
        roadBikesPage.increaseQuantity();
    }

    @And("^add to basket$")
    public void addToBasket(){
        roadBikesPage.clickOnQuickBuyButton();

    }

    @Then("^error is displayed$")
    public void errorIsDisplayed(){
        Assert.assertEquals(roadBikesPage.errorIsDisplayed(), true);
    }

    @And("^return to main page$")
    public void goHome(){
        waitPage();
        roadBikesPage.clickHomeLink();
    }


}
