package com.katalon.kata.sample.page;

import com.katalon.kata.selenium.PageTemplate;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CuraHomePage extends PageTemplate {

  private String baseUrl;

  @FindBy(id = "btn-make-appointment")
  private WebElement makeAppointmentBtn;

  public CuraHomePage(String baseUrl) {
    this.baseUrl = baseUrl;
  }

  public void open() {
    driver.get(baseUrl);
  }

  public void makeAppointment() {
    makeAppointmentBtn.click();
  }
}