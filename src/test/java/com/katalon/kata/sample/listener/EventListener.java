package com.katalon.kata.sample.listener;

import com.katalon.kata.webdriver.WebDriverPool;
import org.testng.IExecutionListener;

public class EventListener implements IExecutionListener {
  @Override
  public void onExecutionStart() {
    WebDriverPool webDriverPool = WebDriverPool.get();
    webDriverPool.setAfterCreateDriverListener(driver -> {
      driver.register(new WebDriverEventListener());
    });
  }

  @Override
  public void onExecutionFinish() {

  }
}
