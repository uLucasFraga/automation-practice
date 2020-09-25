package br.com.automation.practice.steps.commons;

import br.com.automation.practice.enums.Browsers;
import br.com.automation.practice.utils.AllureAjuda;
import cucumber.api.Scenario;
import cucumber.api.java.After;

public class Hooks {

  @After
  public void depoisCadaCenario(Scenario cenario) {
    AllureAjuda.salvarScreenshotDoCenario(cenario);
    Browsers.sairDriver();
  }
}
