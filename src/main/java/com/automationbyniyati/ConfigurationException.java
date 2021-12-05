package com.automationbyniyati;

public class ConfigurationException extends RuntimeException
{
        String exceptionMessage;
        String cause;

        public ConfigurationException(String message)
        {
            this.cause = message;
        }
        public String toString(String message)
        {
            exceptionMessage = "Error in configuration file. Pls check the file for any error/invalid Input";
            exceptionMessage += "Exception occured due to: " + this.cause;
            return exceptionMessage;
        }
    }

