package com.tests.appium.browser.day8;

import com.tests.appium.devices.day1.MyBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;

public class Browse extends MyBase {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> androidDriver = capabilities("browser");
        androidDriver.get("https://facebook.com");
        // you can write any selenium code by finding out the xpath

    }
}
