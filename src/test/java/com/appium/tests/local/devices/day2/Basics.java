package com.appium.tests.local.devices.day2;

import com.appium.tests.local.devices.day1.MyBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;

public class Basics extends MyBase {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> androidDriver = capabilities("emulator");

        /**
         * Test Case:
         * Preferences --> Default values --> Edit Text preferences --> Edit Text Preference --> Pop up
         * --> Enter animal name --> Click on OK
         */
        androidDriver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        androidDriver.findElementByXPath("//android.widget.TextView[@text='4. Default values']").click();
        androidDriver.findElementByXPath("//android.widget.TextView[@text='Edit text preference']").click();
        androidDriver.findElementByXPath("//android.widget.EditText[@text='Default value']").clear();
        androidDriver.findElementByXPath("//android.widget.EditText[@text='']").sendKeys("Dogs");
        androidDriver.findElementByXPath("//android.widget.Button[@text='OK']").click();
    }
}
