package com.katalon.kata.sample.custombrowser;

import com.katalon.kata.webdriver.AbstractWebDriverFactory;
import com.katalon.kata.webdriver.WebDriverPool;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.IExecutionListener;

public class SauceLabsConfigurer implements IExecutionListener {

    private static final String BROWSER_NAME = "saucelabs";

    @Override
    public void onExecutionStart() {
        WebDriverPool webDriverPool = WebDriverPool.get();
        webDriverPool.setFactory(BROWSER_NAME, new SampleSauceLabsWebDriverFactory());
    }

    @Override
    public void onExecutionFinish() {

    }
}
