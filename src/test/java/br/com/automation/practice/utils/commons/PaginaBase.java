package br.com.automation.practice.utils.commons;

import br.com.automation.practice.enums.Browsers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class Page {

  private final long DEFAULT_TIME_WAIT = 10;

  public Page() {
    if (Browsers.webDriver == null) {
      Browsers.setWebDriver();
    }
  }

  public static WebDriver getDriver() {
    return Browsers.webDriver;
  }

  protected void openUrl(String url) {
    getDriver().get(url);
  }

  protected String getUrl() {
    return getDriver().getCurrentUrl();
  }

  protected boolean isUrlContainsValue(String text) {
    return getUrl().contains(text);
  }

  protected WebElement waitElement(By locator) {
    return new WebDriverWait(getDriver(), DEFAULT_TIME_WAIT)
        .until(ExpectedConditions.presenceOfElementLocated(locator));
  }

  protected List<WebElement> waitElements(By locator) {
    return new WebDriverWait(getDriver(), DEFAULT_TIME_WAIT)
        .until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
  }

  protected boolean isVisible(By locator) {
    new WebDriverWait(getDriver(), DEFAULT_TIME_WAIT)
        .until(ExpectedConditions.visibilityOf(getElement(locator)));
    return getElement(locator).isDisplayed();
  }

  protected boolean isNotVisible(By locator) {
    return new WebDriverWait(getDriver(), DEFAULT_TIME_WAIT)
        .until(ExpectedConditions.invisibilityOf(getElement(locator)));
  }

  protected boolean isClickable(By locator) {
    new WebDriverWait(getDriver(), DEFAULT_TIME_WAIT)
        .until(ExpectedConditions.elementToBeClickable(getElement(locator)));
    return getElement(locator).isDisplayed() && getElement(locator).isEnabled();
  }

  protected void waitForTextInElement(By locator, String textToBeWait) {
    new WebDriverWait(getDriver(), DEFAULT_TIME_WAIT)
        .until(ExpectedConditions.textToBe(locator, textToBeWait));
  }

  protected void waitForTextPresentInElement(By locator, String textToBeWait) {
    new WebDriverWait(getDriver(), DEFAULT_TIME_WAIT)
        .until(ExpectedConditions.textToBePresentInElement(getElement(locator), textToBeWait));
  }

  protected void waitForElementToBeSelected(By locator) {
    new WebDriverWait(getDriver(), DEFAULT_TIME_WAIT)
        .until(ExpectedConditions.elementToBeSelected(getElement(locator)));
  }

  protected void waitElementInvisible(By locator) {
    new WebDriverWait(getDriver(), DEFAULT_TIME_WAIT)
        .until(ExpectedConditions.invisibilityOfElementLocated((locator)));
  }

  protected void countList(By locator, String message) {
    isVisible(locator);
    List<WebElement> list = getElements(locator);
    System.out.println(message + list.size());
  }

  protected void getListNames(By locator, String message) {
    isVisible(locator);
    List<WebElement> list_names = getElements(locator);
    List<String> all_elements_text = new ArrayList<>();
    for (WebElement element : list_names) {
      all_elements_text.add(element.getText());
      System.out.println(message + element.getText());
    }
  }

  protected WebElement getElement(By locator) {
    return waitElement(locator);
  }

  protected List<WebElement> getElements(By locator) {
    return waitElements(locator);
  }

  protected void fillInput(String datatype, By locator) {
    isVisible(locator);
    getElement(locator).clear();
    this.waitForTextInElement(locator, "");
    getElement(locator).sendKeys(datatype);
  }

  protected void clickOn(By locator) {
    isVisible(locator);
    new Actions(getDriver()).moveToElement(getElement(locator)).perform();
    getElement(locator).click();
  }

  protected void clickElementByTextList(By list, By locator, String text) {
    isElementAttachedToHtml(list);
    List<WebElement> textList = new ArrayList<>(getElements(list));
    for (WebElement element : textList) {
      if (text.equals(getTextFromLabel(locator))) {
        element.click();
        break;
      }
    }
  }

  protected void click(By locator) {
    isClickable(locator);
    getElement(locator).click();
  }

  protected void check(By locator) {
    if (!getElement(locator).isSelected()) {
      click(locator);
      waitForChecked(locator);
    }
  }

  protected void unCheck(By locator) {
    if (getElement(locator).isSelected()) {
      click(locator);
      waitForNotChecked(locator);
    }
  }

  protected boolean waitForChecked(By locator) {
    return getElement(locator).isSelected();
  }

  protected boolean waitForNotChecked(By locator) {
    return !getElement(locator).isSelected();
  }

  protected boolean isVisibleOnMouse(By locator) {
    isVisible(locator);
    new Actions(getDriver()).moveToElement(getElement(locator)).perform();
    return getElement(locator).isDisplayed();
  }

  protected String getTitle() {
    return getTitle().trim();
  }

  protected String getTextFromLabel(By locator) {
    return getElement(locator).getText().trim();
  }

  protected String getAttributeFromLabel(By locator, String value) {
    return getElement(locator).getAttribute(value);
  }

  protected String getTextOfVisibleElement(WebElement element) {
    String text = null;
    try {
      text = element.getText().trim();
    } catch (Exception e) {
      System.out.println(element + " : " + e);
    }
    return text;
  }

  protected boolean isElementAttachedToHtml(By locator) {
    try {
      waitElement(locator);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  protected void pressTab(By locator) {
    isVisible(locator);
    getElement(locator).sendKeys(Keys.TAB);
  }

  protected void pressEnter(By locator) {
    isVisible(locator);
    getElement(locator).sendKeys(Keys.ENTER);
  }
}
