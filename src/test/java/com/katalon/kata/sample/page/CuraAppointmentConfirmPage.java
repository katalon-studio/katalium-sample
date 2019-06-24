package com.katalon.kata.sample.page;

import com.katalon.kata.selenium.PageTemplate;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CuraAppointmentConfirmPage extends PageTemplate {

  @FindBy(id="facility")
  private WebElement facilityLabel;
  @FindBy(id="hospital_readmission")
  private  WebElement hospitalReadMissionLabel;
  @FindBy(id="program")
  private  WebElement programLabel;
  @FindBy(id="comment")
  private  WebElement commentLabel;
  @FindBy(id="visit_date")
  private  WebElement visitDateLabel;

  public void checkInformation(String facility, String vistiDate, String comment) {
    Assert.assertEquals(facilityLabel.getText(), facility);
    Assert.assertEquals(hospitalReadMissionLabel.getText(), "Yes");
    Assert.assertEquals(programLabel.getText(), "Medicaid");
    Assert.assertEquals(visitDateLabel.getText(), vistiDate);
    Assert.assertEquals(commentLabel.getText(), comment);
  }
}
