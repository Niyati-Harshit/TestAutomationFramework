package com.automationbyniyati.browser;

import com.automationbyniyati.properties.PropertiesLoader;
import org.openqa.selenium.WebDriver;

public class DriverManager
{
    public static WebDriver driver;

    public WebDriver getDriver()
    {
        return driver;
    }

    public void setDriver(WebDriver driver)
    {
        this.driver = driver;
    }

    public void loadDriver()
    {
        Browser browser = null;
        String path = "";
        if(PropertiesLoader.runOnBrowser.equalsIgnoreCase("Chrome"))
        {
            browser = new Chrome(); // RunTime Polymorphism.
            path = PropertiesLoader.chromeDriverPath;
        }

        else if (PropertiesLoader.runOnBrowser.equalsIgnoreCase("Edge"))
        {
            browser = new Edge(); // RunTime Polymorphism.
            path = PropertiesLoader.edgeDriverPath;

        }

        browser.setHeadless(PropertiesLoader.headless);
        browser.setRemote(PropertiesLoader.remoteRun);
        browser.setMaximized(PropertiesLoader.maximizeMode);
        browser.setPageLoadTimeOut(PropertiesLoader.pageLoadWaitTime);
        browser.setPreferences();
        WebDriver driver = browser.loadBrowser(path);
        setDriver(driver);

    }
    public void closeBrowser()
    {
        driver.close();
    }

    public void closeAllBrowser()
    {
        driver.quit();
    }
}
