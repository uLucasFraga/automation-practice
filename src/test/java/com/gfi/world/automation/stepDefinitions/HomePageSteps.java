package com.gfi.world.automation.stepDefinitions;

import com.gfi.world.automation.pages.HomePage;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;

import static com.gfi.world.automation.utils.HandleProperties.getValue;
import static org.junit.Assert.assertTrue;

public class HomePageSteps {

  private HomePage homePage;

  @Before
  public void setup() {
    homePage = new HomePage();
  }

  /* =========================DADO========================= */
  @Dado("^que ele acessa o site gfi-world$")
  public void queEleAcessaOSiteGfiWorld() {
    homePage.visit(getValue("BASE_URL"));
  }

  @Dado("^que ele esteja na sessão \"([^\"]*)\"$")
  public void queEleEstejaNaSessaoCarreira(String option) {
    homePage.chooseNavBarOption(option);
  }

  /* =========================ENTÃO========================= */
  @Então("^ele verifica o texto \"([^\"]*)\" com sucesso$")
  public void eleVerificaOTextoComSucesso(String text) {
    assertTrue(homePage.verifyHomePageText(text));
  }
}
