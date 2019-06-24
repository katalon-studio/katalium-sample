package com.katalon.kata.sample.parameterize;

import com.katalon.kata.helper.LogHelper;
import com.katalon.kata.sample.Constants;
import com.katalon.kata.sample.page.CuraAppoinmentPage;
import com.katalon.kata.sample.page.CuraAppointmentConfirmPage;
import com.katalon.kata.sample.page.CuraHomePage;
import com.katalon.kata.sample.page.CuraLoginPage;
import com.katalon.kata.testng.TestTemplate;
import org.slf4j.Logger;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizedMakeAppointmentTest extends TestTemplate {

  private static final Logger log = LogHelper.getLogger();

  private CuraHomePage curaHomePage = new CuraHomePage(Constants.baseUrl);

  private CuraLoginPage loginPage;

  private CuraAppoinmentPage curaAppoinmentPage;

  private CuraAppointmentConfirmPage curaAppointmentConfirmPage;

  @Parameters({"facility", "visitDate", "comment"})
  @Test
  public void shoudMakeAppointmentWithParameters(String facility, String visitDate, String comment) {
    log.info("Make appointment with parameters");
    log.info("Facility {}", facility);
    log.info("VisitDate {}", visitDate);
    log.info("Comment {}", comment);
    curaHomePage.open();
    curaHomePage.makeAppointment();
    loginPage.login(Constants.username, Constants.password);
    curaAppoinmentPage.fillApointmentDetails(facility, visitDate, comment);
    curaAppointmentConfirmPage.checkInformation(facility, visitDate, comment);
    driver.quit();
  }
}
