package com.stv.factory.factorytests;

import com.stv.factory.factorypages.MainFactoryPage;
import com.stv.framework.core.drivers.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static com.stv.framework.core.lib.WigglePageURLs.LOGIN_URL;
import static com.stv.framework.core.lib.WigglePageURLs.START_URL;

public class BasicFactoryTest {
    public static WebDriver getDriver() {
        return Driver.getDriver();
    }
    MainFactoryPage mainFactoryPage = new MainFactoryPage();
    public void waitPage(){
        getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @BeforeClass(description = "Start browser")
    public void setUp() {
        WebDriver driver = getDriver();
        driver.get(START_URL);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        mainFactoryPage.clickOnTrustButton();
        mainFactoryPage.clickOnAccountLink();
    }



    @AfterClass
    public void afterClass() throws Exception {
     getDriver().quit();
    }



}
