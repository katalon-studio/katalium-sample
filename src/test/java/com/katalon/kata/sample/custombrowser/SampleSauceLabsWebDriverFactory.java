package com.katalon.kata.sample.custombrowser;

import com.katalon.kata.helper.ExceptionHelper;
import com.katalon.kata.helper.ParameterHelper;
import com.katalon.kata.webdriver.AbstractWebDriverFactory;
import com.katalon.kata.webdriver.WebDriverFactory;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class SampleSauceLabsWebDriverFactory implements WebDriverFactory {

    private static final String BROWSER_KEY = "sauceBrowser";

    private static final String VERSION_KEY = "sauceBrowserVersion";

    private static final String PLATFORM_KEY = "saucePlatform";

    private static final String SAUCE_USER_NAME_KEY = "sauceUsername";

    private static final String SAUCE_ACCESS_KEY_KEY = "sauceAccessKey";

    private static final String SAUCE_URL = "https://ondemand.saucelabs.com/wd/hub";

    @Override
    public RemoteWebDriver createRemoteWebDriver(String seleniumServer) {

        try {

            String sauceUserName = ParameterHelper.getParameterDefaultValue(SAUCE_USER_NAME_KEY);
            String sauceAccessKey = ParameterHelper.getParameterDefaultValue(SAUCE_ACCESS_KEY_KEY);

            String browser = ParameterHelper.getParameterDefaultValue(BROWSER_KEY);
            String version = ParameterHelper.getParameterDefaultValue(VERSION_KEY);
            String os = ParameterHelper.getParameterDefaultValue(PLATFORM_KEY);

            if (StringUtils.isBlank(browser)) {
                browser = "chrome";
            }
            if (StringUtils.isBlank(version)) {
                version = "latest";
            }
            if (StringUtils.isBlank(os)) {
                os = "Windows 10";
            }

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("username", sauceUserName);
            capabilities.setCapability("accessKey", sauceAccessKey);
            capabilities.setCapability(CapabilityType.BROWSER_NAME, browser);
            capabilities.setCapability(CapabilityType.VERSION, version);
            capabilities.setCapability(CapabilityType.PLATFORM, os);

            RemoteWebDriver driver = new RemoteWebDriver(new URL(SAUCE_URL), capabilities);
            return driver;

        } catch (Exception e) {
            return ExceptionHelper.rethrow(e);
        }
    }
}