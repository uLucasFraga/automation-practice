package br.com.automation.practice.enums;

import static br.com.automation.practice.utils.Drivers.criarDriver;

import br.com.automation.practice.utils.ManipularPropriedades;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public enum Browsers {
  FF_LINUX("webdriver.gecko.driver", "/geckodriver_linux"),
  FF_MAC("webdriver.gecko.driver", "/geckodriver_mac"),
  FF_WINDOWS("webdriver.gecko.driver", "/geckodriver_win.exe"),
  CHROME_LINUX("webdriver.chrome.driver", "/chromedriver_linux"),
  CHROME_MAC("webdriver.chrome.driver", "/chromedriver_mac"),
  CHROME_WINDOWS("webdriver.chrome.driver", "/chromedriver_win.exe");

  public static WebDriver webDriver;
  private final String tipoBrowser;
  private final String executavel;

  Browsers(String tipoBrowser, String executavel) {
    this.tipoBrowser = tipoBrowser;
    this.executavel = executavel;
  }

  public static void mostrarOpcoesValidasDosBrowsers() {
    for (Browsers tipoBrowser : Browsers.values()) {
      System.out.println("======= ".concat(tipoBrowser.name()));
    }
  }

  public static void setarWebDriver() {
    if (Boolean.parseBoolean(System.getProperty("URL_BASE"))) {
      try {
        String urlBase =
            System.getProperty("urlBase") != null
                ? System.getProperty("urlBase")
                : ManipularPropriedades.pegarDados("URL_BASE");
        webDriver = new RemoteWebDriver(new URL(urlBase), new ChromeOptions());
      } catch (MalformedURLException e) {
        e.printStackTrace();
      }
    } else {
      webDriver = criarDriver(System.getProperty("browser"));
    }
  }

  public static void sairDriver() {
    webDriver.quit();
    webDriver = null;
  }

  public String pegarTipoBrowser() {
    return tipoBrowser;
  }

  public String pegarExecutavel() {
    return executavel;
  }

  public WebDriver criarInstanciaDriver() {
    switch (tipoBrowser) {
      case "webdriver.gecko.driver":
        return new FirefoxDriver();
      case "webdriver.chrome.driver":
        return new ChromeDriver();
      default:
        return null;
    }
  }
}
