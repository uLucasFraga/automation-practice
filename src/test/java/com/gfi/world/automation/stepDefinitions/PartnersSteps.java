package com.gfi.world.automation.stepDefinitions;

import com.gfi.world.automation.pages.PartnersPage;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Então;

import static org.junit.Assert.assertTrue;

public class PartnersSteps {

  private PartnersPage partnerPage;

  @Before
  public void setup() {
    partnerPage = new PartnersPage();
  }

  @Então("^ele verifica que a lista de parceiros foi exibida com sucesso$")
  public void eleVerificaQueAListaDeParceirosFoiExibidaComSucesso() {
    assertTrue(partnerPage.verifyPartnersList());
  }

  @Então("^ele verifica a quantidade de parceiros com sucesso$")
  public void eleVerificaAQuantidadeDeParceirosComSucesso() {
    partnerPage.countPartners("Quantidade total de parceiros: ");
  }

  @Então("^ele verifica os nomes dos parceiros com sucesso$")
  public void eleVerificaOsNomesDosParceirosComSucesso() {
    partnerPage.getListNamesPartners("Lista de parceiros: ");
  }
}
