package com.tests.appium.devices.day3;

import com.tests.appium.devices.day1.MyBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;

public class AndroidUIAutomator extends MyBase {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> androidDriver = capabilities("emulator");
        // Based on attribute
        androidDriver.findElementByAndroidUIAutomator("text(\"Preference\")").click();
        // Based on property
        System.out.println(androidDriver.findElementsByAndroidUIAutomator("new UiSelector().checkable(true)").size());
    }
}
