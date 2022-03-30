package com.appium.tests.cloud;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DragAndDropOnCloud {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserstack.user", "xxxx");
        caps.setCapability("browserstack.key", "xxxx");
        caps.setCapability("app", "bs://xxx");
        caps.setCapability("device", "Google Pixel 3");
        caps.setCapability("os_version", "9.0");
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
                new URL("http://hub.browserstack.com/wd/hub"), caps);

        driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Views\"));").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();
        AndroidElement src = driver.findElementsByClassName("android.view.View").get(0);
        AndroidElement dest1 = driver.findElementsByClassName("android.view.View").get(1);

        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(new LongPressOptions().withElement(new ElementOption().withElement(src))).
                moveTo(new ElementOption().withElement(dest1)).release().perform();

        driver.quit();
    }
}
