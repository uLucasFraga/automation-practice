package br.com.automation.practice.stepDefinitions;

import br.com.automation.practice.pages.HomePage;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

import static br.com.automation.practice.utils.HandleProperties.getValue;
import static org.junit.Assert.assertTrue;

public class HomeSteps {

  private HomePage homePage;

  @Before
  public void setup() {
    homePage = new HomePage();
  }

  /* =========================DADO========================= */
  @Dado("^que ele acessa o site$")
  public void queEleAcessaOSite() {
    homePage.visit(getValue("BASE_URL"));
  }

  /* =========================ENTÃO========================= */
  @Então("^ele verifica o texto \"([^\"]*)\" na página inicial$")
  public void eleVerificaOTextoNaPaginaInicial(String text) {
    assertTrue(homePage.verifyHomePageText(text));
  }
  @Quando("^ele pesquisar por \"([^\"]*)\"$")
  public void elePesquisarPor(String arg0) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }
}
