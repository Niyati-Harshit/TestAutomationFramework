package com.automationbyniyati.components;

import com.automationbyniyati.properties.PropertiesLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

public class ElementFindBy
{
    WebDriver driver;
    WebDriverWait wait;

    public ElementFindBy(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(this.driver,PropertiesLoader.explicitWaitTime);
    }

    public By findBy(String element) throws IOException,Exception
    {
        By by;
        RepositoryLoader loader = new RepositoryLoader();
        loader.loadProperties();
        String elementValue = loader.getProperty(element);
        String findBy = elementValue.split(":")[0];
        String findByValue = elementValue.split(":")[1];

        if(findBy.equalsIgnoreCase("xpath"))
        {
            by =By.xpath(findByValue);
        }
        else if(findBy.equalsIgnoreCase("id"))
        {
            by =By.id(findByValue);
        }
        else if(findBy.equalsIgnoreCase("name"))
        {
            by =By.name(findByValue);
        }
        else if(findBy.equalsIgnoreCase("class"))
        {
            by =By.className(findByValue);
        }
        else if(findBy.equalsIgnoreCase("css"))
        {
            by =By.cssSelector(findByValue);
        }
        else if(findBy.equalsIgnoreCase("linkText"))
        {
            by =By.linkText(findByValue);
        }
        else if(findBy.equalsIgnoreCase("partialLinkText"))
        {
            by =By.partialLinkText(findByValue);
        }
        else
        {
            throw new Exception("Invalid locator Type/Value in [" + element +"]. Please check value is OR file");
        }

        return by;
    }

    public WebElement findElementBy(String element) throws Exception
    {
        By by = findBy(element);
        return waitUntilElementVisible(by);
//        Wait wait = new WebDriverWait(driver, PropertiesLoader.explicitWaitTime);
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
//        return driver.findElement(by);
    }

    public List<WebElement> findElementsBy(String element) throws Exception
    {
        By by =findBy(element);
        return waitUntilAllElementVisible(by);
    }

    public List<WebElement> waitUntilAllElementVisible(By by) throws Exception
    {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public WebElement waitUntilElementVisible(By by) throws Exception
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public boolean waitUntilElementDisappears(By by) throws Exception
    {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

     public WebElement waitUntilElementFound(By by) throws Exception
     {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
     }

     public WebElement waitUntilClickable(By by) throws Exception
     {
         return wait.until(ExpectedConditions.elementToBeClickable(by));
     }
}
