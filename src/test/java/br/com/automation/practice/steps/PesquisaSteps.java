package br.com.automation.practice.stepDefinitions;

import br.com.automation.practice.paginas.PesquisaPaginaBase;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

import static org.junit.Assert.assertTrue;

public class PesquisaSteps {

  private PesquisaPaginaBase pesquisaPage;

  @Before
  public void setup() {
    pesquisaPage = new PesquisaPaginaBase();
  }

  /* =========================QUANDO========================= */
  @Quando("^ele pesquisar por \"([^\"]*)\"$")
  public void elePesquisarPor(String produto) {
    pesquisaPage.pesquisar(produto);
  }

  /* =========================ENTÃO========================= */
  @Então("^ele verifica que a pesquisa por \"([^\"]*)\" foi feita com sucesso$")
  public void eleVerificaQueAPesquisaPorFoiFeitaComSucesso(String produto) {
    assertTrue(pesquisaPage.verificarValido(produto));
  }

  @Então("^ele verifica que existem produtos pela mensagem: \"([^\"]*)\"$")
  public void eleVerificaQueExistemProdutosPelaMensagem(String mensagem) {
    assertTrue(pesquisaPage.verificarResultadoTotal(mensagem));
  }

  @Então("^ele verifica que o produto não existe pela mensagem: \"([^\"]*)\"$")
  public void eleVerificaQueOProdutoNaoExistePelaMensagem(String mensagem) {
    assertTrue(pesquisaPage.verificarInvalido(mensagem));
  }
}
