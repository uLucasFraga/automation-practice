package br.com.automation.practice.stepDefinitions.commons;

import br.com.automation.practice.enums.Browsers;
import br.com.automation.practice.utils.AllureHelper;
import cucumber.api.Scenario;
import cucumber.api.java.After;

public class Hooks {

  @After
  public void afterEachScenario(Scenario scenario) {
    AllureHelper.saveScreenshotOfScenario(scenario);
    Browsers.sairDriver();
  }
}
