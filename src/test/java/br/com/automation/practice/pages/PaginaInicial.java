package br.com.automation.practice.paginas;

import br.com.automation.practice.utils.HandleProperties;
import br.com.automation.practice.utils.commons.PaginaBase;
import org.openqa.selenium.By;

public class PaginaInicial extends PaginaBase {

  private final By RESULTADO_PAGINA_INICIAL = By.cssSelector("h1");

  public void visitar(String url) {
    String urlBase =
        System.getProperty("urlBase") != null
            ? System.getProperty("urlBase")
            : HandleProperties.getValue("URL_BASE");
    openUrl(urlBase);
    isUrlContainsValue(url);
  }

  public boolean verificarTextoPaginaInicial(String texto) {
    estaVisivel(RESULTADO_PAGINA_INICIAL);
    return pegarTexto(RESULTADO_PAGINA_INICIAL).equals(texto);
  }
}
