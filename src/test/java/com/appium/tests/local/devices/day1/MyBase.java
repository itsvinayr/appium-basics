package com.appium.tests.local.devices.day1;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MyBase {
    public static AndroidDriver<AndroidElement> capabilities(String device) throws MalformedURLException {

        File appDir = new File("src");
        File app = new File(appDir, "ApiDemos-debug.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        if(device.equalsIgnoreCase("emulator")) {
            // configuration to run tests in emulator
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "VinayEmulator");
            capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        }else if(device.equalsIgnoreCase("real")){
            // configuration to run tests on physical device
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
            capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        }else if(device.equalsIgnoreCase("browser")){
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "VinayEmulator");
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        }
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;

    }
}
