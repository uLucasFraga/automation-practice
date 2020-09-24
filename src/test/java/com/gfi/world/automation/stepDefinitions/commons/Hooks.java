package com.gfi.world.automation.stepDefinitions.commons;

import com.gfi.world.automation.enums.Browsers;
import com.gfi.world.automation.utils.AllureHelper;
import cucumber.api.Scenario;
import cucumber.api.java.After;

public class Hooks {

  @After
  public void afterEachScenario(Scenario scenario) {
    AllureHelper.saveScreenshotOfScenario(scenario);
    Browsers.quitDriver();
  }
}
