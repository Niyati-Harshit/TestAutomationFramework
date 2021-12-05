package com.automationbyniyati.properties;

import com.automationbyniyati.ConfigurationException;

import static com.automationbyniyati.properties.PropertiesLoader.*;

public class PropertiesValidators
{
    public static void ValidateConfigurations() throws Exception
    {
        if(runOnBrowser.equalsIgnoreCase("Chrome"))
        {
            if (chromeDriverPath.isEmpty())
            {
                throw new ConfigurationException("ChromeDriverPath is empty");
            }

            if (runOnBrowser.equalsIgnoreCase("Firefox"))
            {
                if (fireFoxDriverPath.isEmpty())
                {
                    throw new ConfigurationException("FireFoxDriverPath is empty");
                }
            }

            if (runOnBrowser.equalsIgnoreCase("Edge"))
            {
                if (edgeDriverPath.isEmpty())
                {
                    throw new ConfigurationException("EdgeDriverPath is empty");
                }

                else if (runOnBrowser.equalsIgnoreCase("IE"))
                {
                    if (ieDriverPath.isEmpty())
                    {
                        throw new ConfigurationException("IEDriverPath is empty");
                    }
                }
            }

       }
    }

}
