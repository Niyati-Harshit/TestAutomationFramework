package com.automationbyniyati.components;

import com.automationbyniyati.browser.DriverManager;
import com.automationbyniyati.properties.PropertiesLoader;
import com.automationbyniyati.properties.PropertiesValidators;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestActions
{
    public WebDriver driver;
    public DriverManager driverManager;
    public BaseActions pageActions;

    @BeforeSuite
    public void SetUpConfigurations() throws Exception
    {
        PropertiesLoader.initializeProperties();
        PropertiesValidators.ValidateConfigurations();
        driverManager = new DriverManager();
    }

    @BeforeMethod
    public void SetUpBrowser ()
    {
        driverManager.loadDriver();
        driver = driverManager.getDriver();
        pageActions = new BaseActions(driver);
        pageActions.launchURL(PropertiesLoader.appURL);
    }

    @AfterMethod
    public void TearDownBrowser()
    {
        driverManager.closeBrowser();
    }

    @AfterSuite
    public void TearDownObject()
    {
        PropertiesLoader.configProperties = null;
    }
}
