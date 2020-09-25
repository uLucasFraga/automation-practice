package br.com.automation.practice.steps;

import br.com.automation.practice.pages.PaginaInicial;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;

import static br.com.automation.practice.utils.HandleProperties.getValue;
import static org.junit.Assert.assertTrue;

public class PaginaInicialSteps {

  private PaginaInicial paginaInicial;

  @Before
  public void setup() {
    paginaInicial = new PaginaInicial();
  }

  /* =========================DADO========================= */
  @Dado("^que ele acessa o site$")
  public void queEleAcessaOSite() {
    paginaInicial.visitar(getValue("URL_BASE"));
  }

  /* =========================ENTÃO========================= */
  @Então("^ele verifica o texto \"([^\"]*)\" na página inicial$")
  public void eleVerificaOTextoNaPaginaInicial(String text) {
    assertTrue(paginaInicial.verificarTextoPaginaInicial(text));
  }
}
