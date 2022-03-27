package com.tests.appium.devices.day5;

import com.tests.appium.devices.day1.MyBase;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

import java.net.MalformedURLException;
import java.time.Duration;

public class Swipe extends MyBase {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> androidDriver = capabilities("emulator");

        /**
         * Click on Views --> Date Widgets --> Inline --> adjust the time to 9.45pm
         *
         * Note: I manually scrolled down to Views (As of now I am not aware of scrolling feature)
         */

        androidDriver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        androidDriver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();
        androidDriver.findElementByXPath("//android.widget.TextView[@text='2. Inline']").click();
        androidDriver.findElementByXPath("//*[@content-desc='9']").click();
        AndroidElement src = androidDriver.findElementByXPath("//*[@content-desc='15']");
        AndroidElement dest = androidDriver.findElementByXPath("//*[@content-desc='45']");
        TouchAction touchAction = new TouchAction(androidDriver);
        touchAction.longPress(
                new LongPressOptions().withElement(new ElementOption().withElement(src)).withDuration(Duration.ofSeconds(2))).
                moveTo(new ElementOption().withElement(dest)).release().perform();
    }
}
