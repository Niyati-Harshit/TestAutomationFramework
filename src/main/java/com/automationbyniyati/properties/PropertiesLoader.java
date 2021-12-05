package com.automationbyniyati.properties;

import com.automationbyniyati.ConfigurationException;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

    public class PropertiesLoader
    {

        //  public static Object configProperties;
        private static Properties configProperties;
        //   Properties configProperties;

        public static String runOnBrowser;
        public static Boolean takeScreenshot;
        public static String chromeDriverPath;
        public static String ieDriverPath;
        public static String edgeDriverPath;
        public static String fireFoxDriverPath;
        public static Boolean maximizeMode;
        public static Integer implicitWaitTime;
        public static Integer explicitWaitTime;
        public static Integer pageLoadWaitTime;
        public static boolean headless;
        public static boolean deleteCookies;
        public static boolean remoteRun;

        public static void initializeProperties() throws Exception
        {
            if (configProperties == null)
            {
                configProperties = new Properties();
                FileInputStream fileInputStream = new FileInputStream(new File(System.getProperty("user.dir") + "//src//test//resources//Config.properties"));
                configProperties.load(fileInputStream);
            }
            runOnBrowser = configProperties.getProperty("RunOnBrowser");
            takeScreenshot = Boolean.valueOf(configProperties.getProperty("TakeScreenshot"));
            chromeDriverPath = configProperties.getProperty("ChromeDriverPath");
            ieDriverPath = configProperties.getProperty("IEDriverPath");
            edgeDriverPath = configProperties.getProperty("EdgeDriverPath");
            fireFoxDriverPath = configProperties.getProperty("FireFoxDriverPath");
            maximizeMode = Boolean.valueOf(configProperties.getProperty("MaximizeMode"));
            implicitWaitTime = Integer.valueOf(configProperties.getProperty("ImplicitWaitTime"));
            explicitWaitTime = Integer.valueOf(configProperties.getProperty("ExplicitWaitTime"));
            pageLoadWaitTime = Integer.valueOf(configProperties.getProperty("PageLoadWaitTime"));
            headless = Boolean.valueOf(configProperties.getProperty("headless"));
            deleteCookies = Boolean.valueOf(configProperties.getProperty("deleteCookies"));
            remoteRun = Boolean.valueOf(configProperties.getProperty("remoteRun"));

        }

        public static void main(String[] args) throws Exception
        {
            PropertiesLoader.initializeProperties();
            PropertiesValidators.ValidateConfigurations();
        }

//        static void validateConfigurations()
//        {
//
//        }

    }


