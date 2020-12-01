package com.katalon.kata.sample.page;

import com.katalon.kata.selenium.PageTemplate;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CuraAppoinmentPage extends PageTemplate {

  @FindBy(id = "appointment")
  private WebElement divAppointment;

  @FindBy(id = "combo_facility")
  private WebElement facilitySelect;

  @FindBy(id = "txt_comment")
  private WebElement commentInput;

  @FindBy(id = "txt_visit_date")
  private WebElement visitDateInput;

  @FindBy(id = "btn-book-appointment")
  private WebElement bookAppointmentBtn;

  @FindBy(id = "radio_program_medicaid")
  private WebElement medicaidCheck;

  @FindBy(id = "radio_program_none")
  private WebElement medicareCheck;

  @FindBy(id = "txt_comment")
  private WebElement noneCheck;

  @FindBy(name = "hospital_readmission")
  private WebElement readMissionCheck;


  public boolean isOnPage() {
    try {
      log.info("Check is on appointment page.");
      return divAppointment.isDisplayed();
    } catch (Exception ex) {
      return false;
    }
  }

  public void fillAppointmentDetails(String facility, String visitDate, String comment) {
    log.info("Fill appointment details.");
    waitUntil(ExpectedConditions.elementToBeClickable(facilitySelect));
    Select facilitySelectBox = new Select(facilitySelect);
    facilitySelectBox.selectByVisibleText(facility);
    medicaidCheck.click();
    readMissionCheck.click();
    visitDateInput.sendKeys(visitDate);
    commentInput.sendKeys(comment);
    bookAppointmentBtn.click();
  }
}
