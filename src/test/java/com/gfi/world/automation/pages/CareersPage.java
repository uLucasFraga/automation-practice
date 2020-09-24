package com.gfi.world.automation.pages;

import com.gfi.world.automation.utils.commons.Page;
import org.openqa.selenium.By;

public class CareersPage extends Page {

  private final By OPPORTUNITIES_TEXT = By.cssSelector("h3[class='inbl block-title']");
  private final By OPPORTUNITIES_LIST_NUMBERS = By.cssSelector("div[class='ts-item-slider']");
  private final By OPPORTUNITIES_LIST_NAMES = By.cssSelector("p[class='inbl poste']");

  public boolean verifyOpportunities(String text) {
    isVisible(OPPORTUNITIES_TEXT);
    return getTextFromLabel(OPPORTUNITIES_TEXT).equals(text);
  }

  public void countOpportunities(String message) {
    countList(OPPORTUNITIES_LIST_NUMBERS, message);
  }

  public void getListNamesOpportunities(String message) {
    getListNames(OPPORTUNITIES_LIST_NAMES, message);
  }
}
