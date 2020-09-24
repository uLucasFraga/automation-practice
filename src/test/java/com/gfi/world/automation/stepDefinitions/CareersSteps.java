package com.gfi.world.automation.stepDefinitions;

import com.gfi.world.automation.pages.CareersPage;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Então;

import static org.junit.Assert.assertTrue;

public class CareersSteps {

  private CareersPage careerPage;

  @Before
  public void setup() {
    careerPage = new CareersPage();
  }

  /* =========================ENTÃO========================= */
  @Então("^ele verifica que \"([^\"]*)\" foi exibido com sucesso$")
  public void eleVerificaQueOTextoFoiExibidoComSucesso(String text) {
    assertTrue(careerPage.verifyOpportunities(text));
  }

  @Então("^ele verifica a quantidade de oportunidades de emprego com sucesso$")
  public void eleVerificaAQuantidadeDeOportunidadesDeEmpregoComSucesso() {
    careerPage.countOpportunities("Quantidade total de oportunidades de emprego: ");
  }

  @Então("^ele verifica as áreas de oportunidades de emprego com sucesso$")
  public void eleVerificaAsAreasDeOportunidadesDeEmpregoComSucesso() {
    careerPage.getListNamesOpportunities("Lista de oportunidades: ");
  }
}
