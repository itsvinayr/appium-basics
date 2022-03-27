package com.tests.appium.devices.day4;

import com.tests.appium.devices.day1.MyBase;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.time.Duration;

public class Gestures extends MyBase {
    public static void main(String[] args) throws MalformedURLException {

        /**
         * Click on Views --> Expandable Lists --> Custom Adapter --> Click and Hold People Names
         * --> Popup should display
         *
         * Note: I manually scrolled down to Views (As of now I am not aware of scrolling feature)
         */

        AndroidDriver<AndroidElement> androidDriver = capabilities("emulator");
        TouchAction touchAction = new TouchAction(androidDriver);
        AndroidElement viewsElement = androidDriver.findElementByXPath("//android.widget.TextView[@content-desc='Views']");
        touchAction.tap(new TapOptions().withElement(new ElementOption().withElement(viewsElement))).perform();
        AndroidElement expandableListElement = androidDriver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
        touchAction.tap(new TapOptions().withElement(new ElementOption().withElement(expandableListElement))).perform();
        AndroidElement customAdapterElement = androidDriver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']");
        touchAction.tap(new TapOptions().withElement(new ElementOption().withElement(customAdapterElement))).perform();
        AndroidElement peopleNamesElement = androidDriver.findElementByXPath("//android.widget.TextView[@text='People Names']");
        touchAction.longPress(new LongPressOptions().withElement(new ElementOption().withElement(peopleNamesElement)).
                withDuration(Duration.ofSeconds(2))).
                release().perform();
        AndroidElement titleElement = androidDriver.findElementByXPath("//android.widget.TextView[@text='Sample menu']");
        Assert.assertTrue(titleElement.isDisplayed(), "pop up didn't display");

    }
}
