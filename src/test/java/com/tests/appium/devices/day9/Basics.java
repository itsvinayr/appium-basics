package com.tests.appium.devices.day9;

import com.appium.pageObjects.HomePage;
import com.tests.appium.devices.day1.MyBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;

public class Basics extends MyBase {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> androidDriver = capabilities("emulator");
        HomePage homePage = new HomePage(androidDriver);
        homePage.preferenceLink.click();
    }
}
