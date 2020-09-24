package com.gfi.world.automation.pages;

import com.gfi.world.automation.utils.HandleProperties;
import com.gfi.world.automation.utils.commons.Page;
import org.openqa.selenium.By;

public class HomePage extends Page {

  private final By ELEMENT_TEXT = By.cssSelector("h2[class='inbl fs70']");

  public void visit(String url) {
    String baseUrl =
        System.getProperty("baseUrl") != null
            ? System.getProperty("baseUrl")
            : HandleProperties.getValue("BASE_URL");
    openUrl(baseUrl);
    isUrlContainsValue(url);
  }

  public void chooseNavBarOption(String option) {
    final By NAVBAR_OPTION = By.xpath("//nav[@id='main-navigation']//a[text()='" + option + "']");
    click(NAVBAR_OPTION);
    isUrlContainsValue(option);
  }

  public boolean verifyHomePageText(String message) {
    isVisible(ELEMENT_TEXT);
    return getTextFromLabel(ELEMENT_TEXT).replaceAll("\\n", " ").equals(message);
  }
}
