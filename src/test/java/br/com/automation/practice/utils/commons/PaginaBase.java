package br.com.automation.practice.utils.commons;

import br.com.automation.practice.enums.Browsers;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaginaBase {

  private final long TEMPO_PADRAO_ESPERA = 10;

  public PaginaBase() {
    if (Browsers.webDriver == null) {
      Browsers.setarWebDriver();
    }
  }

  public static WebDriver pegarDriver() {
    return Browsers.webDriver;
  }

  protected void abrirURL(String url) {
    pegarDriver().get(url);
  }

  protected String pegarURL() {
    return pegarDriver().getCurrentUrl();
  }

  protected boolean urlContemTexto(String texto) {
    return pegarURL().contains(texto);
  }

  protected WebElement esperarElemento(By localizador) {
    return new WebDriverWait(pegarDriver(), TEMPO_PADRAO_ESPERA)
        .until(ExpectedConditions.presenceOfElementLocated(localizador));
  }

  protected List<WebElement> esperarElementos(By localizador) {
    return new WebDriverWait(pegarDriver(), TEMPO_PADRAO_ESPERA)
        .until(ExpectedConditions.presenceOfAllElementsLocatedBy(localizador));
  }

  protected boolean estaVisivel(By localizador) {
    new WebDriverWait(pegarDriver(), TEMPO_PADRAO_ESPERA)
        .until(ExpectedConditions.visibilityOf(pegarElemento(localizador)));
    return pegarElemento(localizador).isDisplayed();
  }

  protected boolean naoEstaVisivel(By localizador) {
    return new WebDriverWait(pegarDriver(), TEMPO_PADRAO_ESPERA)
        .until(ExpectedConditions.invisibilityOf(pegarElemento(localizador)));
  }

  protected boolean estaClicavel(By localizador) {
    new WebDriverWait(pegarDriver(), TEMPO_PADRAO_ESPERA)
        .until(ExpectedConditions.elementToBeClickable(pegarElemento(localizador)));
    return pegarElemento(localizador).isDisplayed() && pegarElemento(localizador).isEnabled();
  }

  protected void esperarPorTextoNoElemento(By localizador, String textoEsperado) {
    new WebDriverWait(pegarDriver(), TEMPO_PADRAO_ESPERA)
        .until(ExpectedConditions.textToBe(localizador, textoEsperado));
  }

  protected void esperarPorTextoPresenteNoElemento(By localizador, String textoEsperado) {
    new WebDriverWait(pegarDriver(), TEMPO_PADRAO_ESPERA)
        .until(
            ExpectedConditions.textToBePresentInElement(pegarElemento(localizador), textoEsperado));
  }

  protected void esperarPorElementoEstarSelecionado(By localizador) {
    new WebDriverWait(pegarDriver(), TEMPO_PADRAO_ESPERA)
        .until(ExpectedConditions.elementToBeSelected(pegarElemento(localizador)));
  }

  protected void esperarElementoNaoVisivel(By localizador) {
    new WebDriverWait(pegarDriver(), TEMPO_PADRAO_ESPERA)
        .until(ExpectedConditions.invisibilityOfElementLocated((localizador)));
  }

  protected void contarUmaListagem(By localizador, String mensagem) {
    estaVisivel(localizador);
    List<WebElement> lista = pegarElementos(localizador);
    System.out.println(mensagem + lista.size());
  }

  protected void pegarUmaListaDeNomes(By localizador, String mensagem) {
    estaVisivel(localizador);
    List<WebElement> lista_nomes = pegarElementos(localizador);
    List<String> todos_elementos_lista = new ArrayList<>();
    for (WebElement elemento : lista_nomes) {
      todos_elementos_lista.add(elemento.getText());
      System.out.println(mensagem + elemento.getText());
    }
  }

  protected WebElement pegarElemento(By localizador) {
    return esperarElemento(localizador);
  }

  protected List<WebElement> pegarElementos(By localizador) {
    return esperarElementos(localizador);
  }

  protected void preencherCampo(By localizador, String texto) {
    estaVisivel(localizador);
    pegarElemento(localizador).clear();
    this.esperarPorTextoNoElemento(localizador, "");
    pegarElemento(localizador).sendKeys(texto);
  }

  protected void clicarMouse(By localizador) {
    estaVisivel(localizador);
    new Actions(pegarDriver()).moveToElement(pegarElemento(localizador)).perform();
    pegarElemento(localizador).click();
  }

  protected void clicarElementoPeloTextoDeUmaLista(By lista, By localizador, String texto) {
    estaVisivelNoHtml(lista);
    List<WebElement> texto_lista = new ArrayList<>(pegarElementos(lista));
    for (WebElement elemento : texto_lista) {
      if (texto.equals(pegarTexto(localizador))) {
        elemento.click();
        break;
      }
    }
  }

  protected void selecionarPorTexto(By localizador, String texto) {
    Select selecionar = new Select(pegarElemento(localizador));
    estaVisivelNoHtml(localizador);
    selecionar.selectByVisibleText(texto);
  }

  protected void clicar(By localizador) {
    estaClicavel(localizador);
    pegarElemento(localizador).click();
  }

  protected void selecionarCheck(By localizador) {
    if (!pegarElemento(localizador).isSelected()) {
      clicar(localizador);
      esperarCheckElemento(localizador);
    }
  }

  protected void naoSelecionarCheck(By localizador) {
    if (pegarElemento(localizador).isSelected()) {
      clicar(localizador);
      esperarNaoCheckElemento(localizador);
    }
  }

  protected boolean esperarCheckElemento(By localizador) {
    return pegarElemento(localizador).isSelected();
  }

  protected boolean esperarNaoCheckElemento(By localizador) {
    return !pegarElemento(localizador).isSelected();
  }

  protected boolean estaVisivelMouse(By localizador) {
    estaVisivel(localizador);
    new Actions(pegarDriver()).moveToElement(pegarElemento(localizador)).perform();
    return pegarElemento(localizador).isDisplayed();
  }

  protected String pegarTitulo() {
    return pegarTitulo().trim();
  }

  protected String pegarTexto(By localizador) {
    return pegarElemento(localizador).getText().trim();
  }

  protected String pegarAtributo(By localizador, String dado) {
    return pegarElemento(localizador).getAttribute(dado);
  }

  protected String pegarTextoVisivelElemento(WebElement elemento) {
    String texto = null;
    try {
      texto = elemento.getText().trim();
    } catch (Exception e) {
      System.out.println(elemento + " : " + e);
    }
    return texto;
  }

  protected boolean estaVisivelNoHtml(By localizador) {
    try {
      esperarElemento(localizador);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  protected void apertarTAB(By localizador) {
    estaVisivel(localizador);
    pegarElemento(localizador).sendKeys(Keys.TAB);
  }

  protected void apertarENTER(By localizador) {
    estaVisivel(localizador);
    pegarElemento(localizador).sendKeys(Keys.ENTER);
  }
}
