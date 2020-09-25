package br.com.automation.practice.pages;

import br.com.automation.practice.utils.commons.Page;
import org.openqa.selenium.By;

public class BuscaPage extends Page {

  private final By INPUT_PESQUISA = By.id("search_query_top");
  private final By RESULTADO_PRESQUISA = By.cssSelector(".right-block h5 a");

  public void pesquisar(String texto) {
    fillInput(texto, INPUT_PESQUISA);
    pressEnter(INPUT_PESQUISA);
  }

  public boolean verificar(String texto) {
    return getTextFromLabel(RESULTADO_PRESQUISA).equals(texto);
  }
}
