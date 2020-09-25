package br.com.automation.practice.enums;

import java.io.File;

public enum SistemaOperacional {
  LINUX_OS_X("drivers/linux/"),
  MAC_OS_X("drivers/mac/"),
  WINDOWS_OS_X("drivers/windows/");

  private final String caminhoDriver;

  SistemaOperacional(String caminhoDriver) {
    this.caminhoDriver = caminhoDriver;
  }

  public String pegarCaminhoDrivers() {
    return new File(caminhoDriver).getAbsolutePath();
  }
}
