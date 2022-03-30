package com.appium.tests.local.devices.day7;

import com.appium.tests.local.devices.day1.MyBase;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

import java.net.MalformedURLException;

public class DragAndDrop extends MyBase {
    public static void main(String[] args) throws MalformedURLException {

        /**
         * Click on Views --> Drag and Drop --> Select the Dot, drag and drop
         */

        AndroidDriver<AndroidElement> androidDriver = capabilities("emulator");
        androidDriver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Views\"));").click();
        androidDriver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();
        AndroidElement src = androidDriver.findElementsByClassName("android.view.View").get(0);
        AndroidElement dest1 = androidDriver.findElementsByClassName("android.view.View").get(1);

        TouchAction touchAction = new TouchAction(androidDriver);
        touchAction.longPress(new LongPressOptions().withElement(new ElementOption().withElement(src))).
                moveTo(new ElementOption().withElement(dest1)).release().perform();
    }
}
