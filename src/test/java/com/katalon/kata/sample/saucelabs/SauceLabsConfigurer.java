package com.katalon.kata.sample.saucelabs;

import com.katalon.kata.webdriver.AbstractWebDriverFactory;
import com.katalon.kata.webdriver.WebDriverPool;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.IExecutionListener;

public class SauceLabsConfigurer implements IExecutionListener {
    private static final String BROWSER_NAME = "saucelabs";
    private static final String BROWSER_KEY = "sauceBrowser";
    private static final String VERSION_KEY = "sauceBrowserVersion";
    private static final String PLATFORM_KEY = "saucePlatform";

    @Override
    public void onExecutionStart() {
        WebDriverPool webDriverPool = WebDriverPool.get();
        webDriverPool.setFactory(BROWSER_NAME, new AbstractWebDriverFactory() {
            @Override
            protected DesiredCapabilities createDesiredCapabilities() {
                DesiredCapabilities capabilities = new DesiredCapabilities();

                String browser = System.getenv(BROWSER_KEY);
                String version = System.getenv(VERSION_KEY);
                String os = System.getenv(PLATFORM_KEY);

                if (StringUtils.isBlank(browser)) {
                    browser = "chrome";
                }

                if (StringUtils.isBlank(version)) {
                    version = "latest";
                }

                if (StringUtils.isBlank(os)) {
                    os = "Windows 10";
                }

                capabilities.setCapability(CapabilityType.BROWSER_NAME, browser);
                capabilities.setCapability(CapabilityType.VERSION, version);
                capabilities.setCapability(CapabilityType.PLATFORM, os);
                return capabilities;
            }
        });
    }

    @Override
    public void onExecutionFinish() {

    }
}
