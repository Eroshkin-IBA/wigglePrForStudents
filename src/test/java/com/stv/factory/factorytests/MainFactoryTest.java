package com.stv.factory.factorytests;

import com.stv.factory.factorypages.AccountPage;
import com.stv.factory.factorypages.LoginPage;
import com.stv.factory.factorypages.MainFactoryPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.stv.framework.core.lib.WigglePageURLs.LOGIN_URL;
import static com.stv.framework.core.lib.WigglePageURLs.START_URL;

public class MainFactoryTest extends BasicFactoryTest {
    @DataProvider(name = "forSignIn")
    public static Object[][] forSignIn() {
        return new Object[][]{{"freerun4ik1998@gmail.com", "@freerun4ik", true }};
    }

    @DataProvider(name = "forExistedEmail")
    public static Object[][] forExistedEmail() {
        return new Object[][]{{"freerun4ik1998@gmail.com", true }};
    }

    @DataProvider(name = "forIncorrectUserData")
    public static Object[][] forIncorrectUserData() {
        return new Object[][]{{"freerun4ik1998@gmail.com", "@freerun", true }};
    }

    AccountPage accountPage = new AccountPage();
    LoginPage loginPage = new LoginPage();


//    @Test (description = "Assert the main page is loaded and account icon is visible")
//    public void assertAccountIconIsDisplayed() {
//        boolean actualResult = mainFactoryPage .isAccountLinkDisplayed();
//        Assert.assertEquals(actualResult, true, "Account link isn't visible");
//    }
//
//    @Test (description = "Assert the login page is loaded", dependsOnMethods = "assertAccountIconIsDisplayed")
//    public void assertLoginPageOpened() {
//        mainFactoryPage.clickOnTrustButton();
//        mainFactoryPage.clickOnAccountLink();
//        Assert.assertEquals(new LoginPage().isLoginContainerDisplayed(), true, "Login page isn't loaded properly");
//    }

    @Test(dataProvider = "forSignIn")
    public void isSignedIn(String email, String password, boolean expected) {

        getDriver().get(LOGIN_URL);
        loginPage.signIn(email, password);
        waitPage();
        boolean actualResult = accountPage.isWelcomeDisplayed();
        Assert.assertEquals(actualResult, expected);
        accountPage.clickSignOutButton();
    }

    @Test(dataProvider = "forIncorrectUserData")
    public void isCorrectUserData(String email, String password, boolean expected) {

        getDriver().get(LOGIN_URL);
        loginPage.signIn(email, password);
        waitPage();
        boolean actualResult = loginPage.isErrorMessageDisplayed();
        Assert.assertEquals(actualResult, expected);

    }
    @Test(dataProvider = "forExistedEmail")
    public void registerExistedEmail(String email,boolean expected){
        getDriver().get(LOGIN_URL);
        loginPage.registerEmail(email);
        boolean actualResult = loginPage.isErrorMessageDisplayed();
        Assert.assertEquals(actualResult, expected);
    }

}
