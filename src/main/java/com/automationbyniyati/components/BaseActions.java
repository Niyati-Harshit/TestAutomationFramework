package com.automationbyniyati.components;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BaseActions
{
    WebDriver driver;

    public BaseActions(WebDriver driver)
    {
        this.driver = driver;
    }

    public void clickIt(String elementRef)
    {
        try
        {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement elementBy = findObj.findElementBy(elementRef);
            elementBy.click();
        }

        catch(Exception e)
        {

        }
    }

    public void typeInTo(String elementRef, String text)
    {
        try {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement elementBy = findObj.findElementBy(elementRef);
            elementBy.click();
            elementBy.clear();
            elementBy.sendKeys(text);
        } catch (Exception e) {

        }
    }

    public String getTextFromElement(String elementRef)
    {
        try
        {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement elementBy = findObj.findElementBy(elementRef);
            return elementBy.getText();
        }

        catch(Exception e)
        {
            return null;
        }
    }

    public String getAttributeForElement(String elementRef, String attributeType)
    {
        try
        {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement elementBy = findObj.findElementBy(elementRef);
            return elementBy.getAttribute(attributeType);
        }

        catch (Exception e)
        {
            return null;
        }
    }

    public void selectValueFromDropDown(String elementRef, String selectBy, String valueToSelect)
    {
        try
        {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement elementBy = findObj.findElementBy(elementRef);
            Select dropDown = new Select(elementBy);

            if(selectBy.equalsIgnoreCase("visibleText"))
            {
                dropDown.selectByVisibleText(valueToSelect);
            }

            else if(selectBy.equalsIgnoreCase("value"))
            {
                dropDown.selectByValue(valueToSelect);
            }

            else if(selectBy.equalsIgnoreCase("index"))
            {
                int index = Integer.parseInt(valueToSelect);
                dropDown.selectByIndex(index);
            }
        }

        catch (Exception e)
        {

        }
    }

    public void SwitchToSecondWindow()
    {
        try
        {
            driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(1));
        }

        catch (Exception e)
        {

        }
    }

    public void SwitchToLastWindow()
    {
        try
        {
            List<String> window = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(window.get(window.size() -1));
        }

        catch (Exception e)
        {

        }
    }

    public void hitEnter(String elementRef)
    {
        try
        {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement elementBy = findObj.findElementBy(elementRef);
            elementBy.sendKeys(Keys.ENTER);
        }

        catch (Exception e)
        {

        }

    }

    public void hitTab(String elementRef)
    {
        try
        {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement elementBy = findObj.findElementBy(elementRef);
            elementBy.sendKeys(Keys.TAB);
        }

        catch (Exception e)
        {

        }

    }

    public void GetURL(String URL)
    {
        try
        {
            driver.get(URL);
        }

        catch (Exception e)
        {

        }
    }

    public void RefreshAPage(String refresh)
    {
        try
        {
            driver.navigate().refresh();
        }

        catch (Exception e)
        {
            new Actions(driver).sendKeys(Keys.F5);
        }
    }

    public void SwitchToAlertAndAccept()
    {
        try
        {
            driver.switchTo().alert().accept();
        }

        catch (Exception e)
        {

        }
    }

    public void SwitchToAlertAndDismiss()
    {
        try
        {
            driver.switchTo().alert().dismiss();
        }

        catch (Exception e)
        {

        }
    }

    public void SwitchToFrame(String elementRef)
    {
        try
        {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement elementBy = findObj.findElementBy(elementRef);
            driver.switchTo().frame(elementBy);
        }

        catch (Exception e)
        {

        }
    }

    public void SwitchToOriginalFromIFrame(String elementRef)
    {
        try
        {
            driver.switchTo().defaultContent();
        }

        catch (Exception e)
        {

        }
    }

    public void ScrollToElement()
    {
        try
        {
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("argument[0].scrollIntoView(true)");
        }

        catch (Exception e)
        {

        }
    }

    public void ScrollToTop()
    {
        try
        {
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
        }

        catch (Exception e)
        {

        }
    }

    public void ScrollToBottom()
    {
        try
        {
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        }

        catch (Exception e)
        {

        }
    }

    public void HoverOnToElement(String elementRef)
    {
        try
        {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement elementBy = findObj.findElementBy(elementRef);
            new Actions(driver).moveToElement(elementBy).build().perform();
        }

        catch (Exception e)
        {

        }
    }

    public void DragAndDrop(String elementRef1, String elementRef2)
    {
        try
        {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement elementBy1 = findObj.findElementBy(elementRef1);
            WebElement elementBy2 = findObj.findElementBy(elementRef2);
            new Actions(driver).dragAndDrop(elementBy1,elementBy2).build().perform();
        }

        catch (Exception e)
        {

        }
    }

    public void RightClickOnElement(String elementRef)
    {
        try
        {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement elementBy = findObj.findElementBy(elementRef);
            new Actions(driver).contextClick(elementBy).build().perform();
        }

        catch (Exception e)
        {

        }
    }

    public void DoubleClickOnElement(String elementRef)
    {
        try
        {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement elementBy = findObj.findElementBy(elementRef);
            new Actions(driver).doubleClick(elementBy).build().perform();
        }

        catch (Exception e)
        {

        }
    }

    public boolean isEnabled(String elementRef)
    {
        try
        {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement elementBy = findObj.findElementBy(elementRef);
            return elementBy.isEnabled();
        }

        catch (Exception e)
        {
            return false;
        }
    }

    public boolean isDisplayed(String elementRef)
    {
        try
        {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement elementBy = findObj.findElementBy(elementRef);
            return elementBy.isDisplayed();
        }

        catch (Exception e)
        {
            return false;
        }
    }

    public void launchURL(String appURL)
    {
        driver.get(appURL);
    }
}
