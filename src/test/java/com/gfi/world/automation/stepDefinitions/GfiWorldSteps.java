package com.gfi.world.automation.stepDefinitions;

import com.gfi.world.automation.pages.GfiWorldCareerPage;
import com.gfi.world.automation.pages.GfiWorldHomePage;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;

import static com.gfi.world.automation.utils.HandleProperties.getValue;
import static org.junit.Assert.assertTrue;

public class GfiWorldSteps {

  private GfiWorldHomePage homePage;
  private GfiWorldCareerPage carrerPage;

  @Before
  public void setup() {
    homePage = new GfiWorldHomePage();
    carrerPage = new GfiWorldCareerPage();
  }

  /*DADO*/
  @Dado("^que ele acessa o site gfi-world$")
  public void que_ele_acessa_o_site_gfi_world() {
    homePage.visit(getValue("BASE_URL"));
  }

  @Dado("^que ele esteja na sessão \"([^\"]*)\"$")
  public void que_ele_esteja_na_sessao_carreira(String option) {
    homePage.chooseNavBarOption(option);
  }

  /*ENTÃO*/
  @Então("^ele verifica o texto \"([^\"]*)\" com sucesso$")
  public void ele_verifica_o_texto_com_sucesso(String text) {
    assertTrue(homePage.verifyHomePageText(text));
  }

  @Então("^ele verifica que \"([^\"]*)\" foi exibido com sucesso$")
  public void ele_verifica_que_o_texto_foi_exibido_com_sucesso(String text) {
    assertTrue(carrerPage.verifyOpportunitiesText(text));
  }

  @Então("^ele verifica a quantidade de oportunidades de emprego com sucesso$")
  public void ele_verifica_a_quantidade_de_oportunidades_de_emprego_com_sucesso() {
    carrerPage.countOpportunities();
  }

  @Então("^ele verifica as áreas de oportunidades de emprego com sucesso$")
  public void ele_verifica_as_areas_de_oportunidades_de_emprego_com_sucesso() {
    carrerPage.verifyOpportunitiesNames();
  }
}
