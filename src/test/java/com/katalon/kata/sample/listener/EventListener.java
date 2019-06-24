package com.katalon.kata.sample.listener;

import org.testng.IExecutionListener;

import com.katalon.kata.webdriver.WebDriverPool;

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
