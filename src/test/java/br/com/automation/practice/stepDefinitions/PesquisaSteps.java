package br.com.automation.practice.stepDefinitions;

import br.com.automation.practice.pages.BuscaPage;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

import static org.junit.Assert.assertTrue;

public class BuscaSteps {

  private BuscaPage buscaPage;

  @Before
  public void setup() {
    buscaPage = new BuscaPage();
  }

  /* =========================QUANDO========================= */
  @Quando("^ele pesquisar por \"([^\"]*)\"$")
  public void elePesquisarPor(String produto) {
    buscaPage.pesquisar(produto);
  }

  /* =========================ENTÃO========================= */
  @Então("^ele verifica que a pesquisa por \"([^\"]*)\" foi feita com sucesso$")
  public void eleVerificaQueAPesquisaPorFoiFeitaComSucesso(String produto) {
    assertTrue(buscaPage.verificar(produto));
  }

  @Então("^ele verifica que a pesquisa por \"([^\"]*)\" não existe$")
  public void eleVerificaQueAPesquisaPorNãoExiste(String produto) {

  }
}
