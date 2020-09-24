package com.gfi.world.automation.runner;

import com.gfi.world.automation.enums.Browsers;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src/test/resources"},
    glue = {"com.gfi.world.automation.stepDefinitions"},
    plugin = {"io.qameta.allure.cucumberjvm.AllureCucumberJvm"},
    tags = {"~@notImplemented"})
public class CucumberRunnerTest {

  @BeforeClass
  public static void tearUp() {
    Browsers.setWebDriver();
  }
}
