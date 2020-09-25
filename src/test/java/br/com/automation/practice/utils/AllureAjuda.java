package br.com.automation.practice.utils;

import br.com.automation.practice.utils.commons.PaginaBase;
import cucumber.api.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class AllureAjuda {

  private static void screenShot(String status, Scenario cenario) {
    byte[] screenshotBytes =
        ((TakesScreenshot) PaginaBase.pegarDriver()).getScreenshotAs(OutputType.BYTES);
    InputStream screenshotStream = new ByteArrayInputStream(screenshotBytes);
    Allure.addAttachment(cenario.getName() + " - " + status, screenshotStream);
  }

  public static void salvarScreenshotDoCenario(Scenario cenario) {
    if (!cenario.isFailed()) {
      screenShot("SUCESSO", cenario);

    } else {
      screenShot("FALHA", cenario);
    }
  }
}
