package com.gfi.world.automation.pages;

import com.gfi.world.automation.utils.commons.Page;
import org.openqa.selenium.By;

public class PartnersPage extends Page {

  private final By PARTNERS_LIST = By.className("items");
  private final By PARTNERS_LIST_NUMBERS = By.cssSelector("div[class='inbl item']");
  private final By PARTNERS_LIST_NAMES = By.cssSelector("p[class='title fs16']");

  public boolean verifyPartnersList() {
    return isVisible(PARTNERS_LIST);
  }

  public void countPartners(String message) {
    countList(PARTNERS_LIST_NUMBERS, message);
  }

  public void getListNamesPartners(String message) {
    getListNames(PARTNERS_LIST_NAMES, message);
  }
}
