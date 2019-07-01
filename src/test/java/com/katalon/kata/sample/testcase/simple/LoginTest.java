package com.katalon.kata.sample.testcase.simple;

import com.katalon.kata.sample.Constants;
import com.katalon.kata.sample.page.CuraAppoinmentPage;
import com.katalon.kata.sample.page.CuraHomePage;
import com.katalon.kata.sample.page.CuraLoginPage;
import com.katalon.kata.testng.TestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestTemplate {

  private CuraHomePage curaHomePage = new CuraHomePage(Constants.baseUrl);

  private CuraLoginPage curaLoginPage;

  private CuraAppoinmentPage curaAppoinmentPage;

  @Test
  public void shouldLogin() {
    curaHomePage.open();
    curaHomePage.makeAppointment();
    curaLoginPage.login(Constants.username, Constants.password);
    boolean exist = curaAppoinmentPage.isOnPage();
    Assert.assertTrue(exist);
    driver.quit();
  }
}
