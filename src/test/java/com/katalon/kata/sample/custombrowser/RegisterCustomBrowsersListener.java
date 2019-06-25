package com.katalon.kata.sample.custombrowser;

import com.katalon.kata.webdriver.WebDriverPool;
import org.testng.IExecutionListener;

public class RegisterCustomBrowsersListener implements IExecutionListener {

    private static final String SAUCE_LABS_BROWSER = "saucelabs";

    @Override
    public void onExecutionStart() {
        WebDriverPool webDriverPool = WebDriverPool.get();
        webDriverPool.setFactory(SAUCE_LABS_BROWSER, new SampleSauceLabsWebDriverFactory());
    }

    @Override
    public void onExecutionFinish() {

    }
}
