package com.gfi.world.automation.utils;

import com.gfi.world.automation.enums.Browsers;
import com.gfi.world.automation.enums.OperationSystems;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

  public static WebDriver createDriver(String mvnParameter) {
    if (mvnParameter == null) {
      System.setProperty(
          Browsers.CHROME_LINUX.getBrowserType(),
          OperationSystems.LINUX_OS_X
              .getDriversPath()
              .concat(Browsers.CHROME_LINUX.getExecutable()));
      ChromeOptions options = new ChromeOptions();
      options.addArguments("--window-size=1920,1080", "--disable-gpu", "--no-sandbox");
      return new ChromeDriver(options);
    }

    try {
      String soName = getSoName();
      String browserType = getBrowserTypeFromParameter(mvnParameter);
      System.setProperty(
          browserType,
          getDriversPath(soName).concat(getFullExecutableNameFromParameter(mvnParameter)));
    } catch (Exception e) {
      System.out.println("ERROR: Please select one of the valid browsers for the test.");
      Browsers.showAvailableBrowsersOptions();
      System.exit(1);
    }

    return Browsers.valueOf(mvnParameter).createDriverInstance();
  }

  private static String formatSoName(String soName) {
    return soName.replace(" ", "_").toUpperCase();
  }

  private static String getBrowserTypeFromParameter(String mvnParameter) {
    return Browsers.valueOf(mvnParameter).getBrowserType();
  }

  private static String getDriversPath(String osName) {
    return OperationSystems.valueOf(formatSoName(osName)).getDriversPath();
  }

  private static String getSoName() {
    return System.getProperty("os.name");
  }

  private static String getFullExecutableNameFromParameter(String mvnParameter) {
    return Browsers.valueOf(mvnParameter).getExecutable();
  }
}
