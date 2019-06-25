package com.katalon.kata.sample.page;

import com.katalon.kata.selenium.PageTemplate;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CuraLoginPage extends PageTemplate {

  @FindBy(id = "txt-username")
  private WebElement usernameInput;

  @FindBy(id = "txt-password")
  private WebElement passwordInput;

  @FindBy(id = "btn-login")
  private WebElement loginBtn;

  public void login(String username, String password) {
    log.info("Log in.");
    usernameInput.sendKeys(username);
    passwordInput.sendKeys(password);
    loginBtn.click();
  }
}
