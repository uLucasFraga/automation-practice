package br.com.automation.practice.steps;

import br.com.automation.practice.pages.PesquisaPagina;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

import static org.junit.Assert.assertTrue;

public class PesquisaSteps {

  private PesquisaPagina pesquisaPage;

  @Before
  public void iniciar() {
    pesquisaPage = new PesquisaPagina();
  }

  /* =========================QUANDO========================= */
  @Quando("^ele pesquisar por \"([^\"]*)\"$")
  public void elePesquisarPor(String produto) {
    pesquisaPage.pesquisar(produto);
  }

  /* =========================ENTÃO========================= */
  @Então("^ele verifica que a pesquisa por \"([^\"]*)\" foi feita com sucesso$")
  public void eleVerificaQueAPesquisaPorFoiFeitaComSucesso(String produto) {
    assertTrue(pesquisaPage.verificarPesquisaValida(produto));
  }

  @Então("^ele verifica que existem produtos pela mensagem: \"([^\"]*)\"$")
  public void eleVerificaQueExistemProdutosPelaMensagem(String mensagem) {
    assertTrue(pesquisaPage.verificarResultadoTotal(mensagem));
  }

  @Então("^ele verifica que o produto não existe pela mensagem: \"([^\"]*)\"$")
  public void eleVerificaQueOProdutoNaoExistePelaMensagem(String mensagem) {
    assertTrue(pesquisaPage.verificarPesquisaInvalida(mensagem));
  }
}
