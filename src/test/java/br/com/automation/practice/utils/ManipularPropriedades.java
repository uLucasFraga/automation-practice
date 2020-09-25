package br.com.automation.practice.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ManipularPropriedades {

  private static final String PROPRIEDADES = "./src/test/resources/config.properties";

  private static Properties propriedades;

  public static String pegarDados(String dado) {
    try {
      if (propriedades == null) {
        ManipularPropriedades.propriedades = new Properties();
        ManipularPropriedades.propriedades.load(new FileInputStream(PROPRIEDADES));
      }

    } catch (IOException e) {
      e.printStackTrace();
    }

    return ManipularPropriedades.propriedades.getProperty(dado);
  }
}
