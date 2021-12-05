import com.automationbyniyati.browser.DriverManager;
import com.automationbyniyati.components.ElementFindBy;
import com.automationbyniyati.properties.PropertiesLoader;
import com.automationbyniyati.properties.PropertiesValidators;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SampleTest
{
    @Test
    public void loadBrowserTest() throws Exception
    {
        PropertiesLoader.initializeProperties();
        PropertiesValidators.ValidateConfigurations();
        DriverManager driverManager = new DriverManager();
        driverManager.loadDriver();
        DriverManager.driver.get("http://www.google.com");
        Thread.sleep(3000);
        ElementFindBy findBy = new ElementFindBy(DriverManager.driver);
        WebElement element = findBy.findElementBy("GooglePage.tbx_Search");
        element.sendKeys("Testing Framework");
        element.click();
        Thread.sleep(4000);
        driverManager.closeAllBrowser();
    }
}
