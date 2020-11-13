package br.com.automation.practice.pages;

import br.com.automation.practice.utils.commons.PaginaBase;
import org.openqa.selenium.By;

public class ContacteNosPage extends PaginaBase {

  private final By SESSAO_CONTACT_US = By.id("contact-link");

  public void acessarContacteUs(String sessao) {
    estaVisivel(SESSAO_CONTACT_US);
    clicar(SESSAO_CONTACT_US);
  }
}
