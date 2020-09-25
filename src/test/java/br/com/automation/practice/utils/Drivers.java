package br.com.automation.practice.utils;

import br.com.automation.practice.enums.Browsers;
import br.com.automation.practice.enums.SistemaOperacional;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Drivers {
  public static WebDriver criarDriver(String mvnParametro) {
    if (mvnParametro == null) {
      System.setProperty(
          Browsers.CHROME_LINUX.pegarTipoBrowser(),
          SistemaOperacional.LINUX_OS_X
              .pegarCaminhoDrivers()
              .concat(Browsers.CHROME_LINUX.pegarExecutavel()));
      ChromeOptions opcao = new ChromeOptions();
      opcao.addArguments("--start-maximized", "--disable-gpu", "--headless", "--no-sandbox");
      return new ChromeDriver(opcao);
    }

    try {
      String soNome = pegarNomeSO();
      String tipoBrowser = pegarTipoBrowserPeloParametro(mvnParametro);
      System.setProperty(
          tipoBrowser,
          pegarCaminhoDriver(soNome).concat(pegarNomeCompletoExecutavelParametro(mvnParametro)));
    } catch (Exception e) {
      System.out.println("ERRO: Por favor, selecione um browser válido para o teste.");
      Browsers.mostrarOpcoesValidasDosBrowsers();
      System.exit(1);
    }

    return Browsers.valueOf(mvnParametro).criarInstanciaDriver();
  }

  private static String formatarNomeSO(String nomeSO) {
    return nomeSO.replace(" ", "_").toUpperCase();
  }

  private static String pegarTipoBrowserPeloParametro(String mvnParametro) {
    return Browsers.valueOf(mvnParametro).pegarTipoBrowser();
  }

  private static String pegarCaminhoDriver(String nomeSO) {
    return SistemaOperacional.valueOf(formatarNomeSO(nomeSO)).pegarCaminhoDrivers();
  }

  private static String pegarNomeSO() {
    return System.getProperty("os.name");
  }

  private static String pegarNomeCompletoExecutavelParametro(String mvnParametro) {
    return Browsers.valueOf(mvnParametro).pegarExecutavel();
  }
}
