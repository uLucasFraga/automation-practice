package br.com.automation.practice.paginas;

import br.com.automation.practice.utils.commons.PaginaBase;
import org.openqa.selenium.By;

public class PesquisaPaginaBase extends PaginaBase {

  private final By INPUT_PESQUISA = By.id("search_query_top");
  private final By RESULTADO_PESQUISA_VALIDA = By.cssSelector(".right-block h5 a");
  private final By RESULTADO_PESQUISA_INVALIDA = By.cssSelector("p[class='alert alert-warning']");
  private final By RESULTADO_PRODUTOS_VALIDO = By.className("heading-counter");

  public void pesquisar(String texto) {
    fillInput(texto, INPUT_PESQUISA);
    pressEnter(INPUT_PESQUISA);
  }

  public boolean verificarValido(String texto) {
    return pegarTexto(RESULTADO_PESQUISA_VALIDA).equals(texto);
  }

  public boolean verificarInvalido(String texto) {
    return pegarTexto(RESULTADO_PESQUISA_INVALIDA).contains(texto);
  }

  public boolean verificarResultadoTotal(String texto) {
    estaVisivel(RESULTADO_PRODUTOS_VALIDO);
    return pegarTexto(RESULTADO_PRODUTOS_VALIDO).contains(texto);
  }
}
