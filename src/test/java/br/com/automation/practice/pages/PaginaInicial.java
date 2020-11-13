package br.com.automation.practice.pages;

import br.com.automation.practice.utils.ManipularPropriedades;
import br.com.automation.practice.utils.commons.PaginaBase;
import org.openqa.selenium.By;

public class PaginaInicial extends PaginaBase {

  private final By RESULTADO_PAGINA_INICIAL = By.cssSelector("h1");

  public void visitar(String url) {
    String urlBase =
        System.getProperty("urlBase") != null
            ? System.getProperty("urlBase")
            : ManipularPropriedades.pegarDados("URL_BASE");
    abrirURL(urlBase);
    urlContemTexto(url);
  }

  public boolean verificarTextoPaginaInicial(String texto) {
    estaVisivel(RESULTADO_PAGINA_INICIAL);
    return pegarTexto(RESULTADO_PAGINA_INICIAL).equals(texto);
  }

  public void acessarContacteNos(String texto) {
    By SESSAO = By.linkText(texto);
    clicar(SESSAO);
  }
}
