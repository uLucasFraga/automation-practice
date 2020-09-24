package com.gfi.world.automation.pages;

import com.gfi.world.automation.utils.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GfiWorldCareerPage extends Page {

  private final By OPPORTUNITIES_TEXT = By.cssSelector("h3[class='inbl block-title']");
  private final By OPPORTUNITIES_LIST = By.cssSelector("div[class='ts-item-slider']");
  private final By OPPORTUNITIES_NAMES =
      By.cssSelector("div[class='ts-item-slider'] p[class='inbl poste']");

  public boolean verifyOpportunitiesText(String text) {
    isVisible(OPPORTUNITIES_TEXT);
    return getTextFromLabel(OPPORTUNITIES_TEXT).equals(text);
  }

  public void countOpportunities() {
    isVisible(OPPORTUNITIES_LIST);
    List<WebElement> opportunities_list = getElements(OPPORTUNITIES_LIST);
    System.out.println("Total de oportunidades: " + opportunities_list.size());
  }

  public void verifyOpportunitiesNames() {
    isVisible(OPPORTUNITIES_NAMES);
    List<WebElement> opportunities_names_list = new ArrayList<>(getElements(OPPORTUNITIES_NAMES));
    System.out.println("Lista de oportunidades: " + opportunities_names_list.size());
  }
}
