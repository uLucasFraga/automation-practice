package br.com.automation.practice.runner;

import br.com.automation.practice.enums.Browsers;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src/test/resources"},
    glue = {"br.com.automation.practice.steps"},
    plugin = {"io.qameta.allure.cucumberjvm.AllureCucumberJvm"},
    tags = "~@ignorar")
public class CucumberRunnerTest {

  @BeforeClass
  public static void inicializar() {
    Browsers.setarWebDriver();
  }
}
