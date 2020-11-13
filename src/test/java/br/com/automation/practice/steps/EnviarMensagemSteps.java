package br.com.automation.practice.steps;

import static org.junit.Assert.assertTrue;

import br.com.automation.practice.pages.ContacteNosPagina;
import br.com.automation.practice.pages.PaginaInicial;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class EnviarMensagemSteps {

  private PaginaInicial paginaInicial;
  private ContacteNosPagina contactNosPage;

  @Before
  public void iniciar() {
    paginaInicial = new PaginaInicial();
    contactNosPage = new ContacteNosPagina();
  }

  /* =========================DADO========================= */
  @Dado("^que ele acessa a sessão de \"([^\"]*)\"$")
  public void que_ele_acessa_a_sessão_de(String sessao) {
    paginaInicial.acessarContacteNos(sessao);
  }

  /* =========================QUANDO========================= */
  @Quando("^ele enviar mensagem como um \"([^\"]*)\"$")
  public void ele_enviar_mensagem_como_um(String cliente) {
    contactNosPage.selecionarTipoCliente(cliente);
    contactNosPage.preencherEmail();
    contactNosPage.preencherReferenciaPedido();
    contactNosPage.preencherMensagem();
    contactNosPage.enviarMensagem();
  }

  @Quando("^ele enviar mensagem como um \"([^\"]*)\" sem preencher o email$")
  public void ele_enviar_mensagem_como_um_sem_preencher_o_email(String cliente) {
    contactNosPage.selecionarTipoCliente(cliente);
    contactNosPage.preencherReferenciaPedido();
    contactNosPage.preencherMensagem();
    contactNosPage.enviarMensagem();
  }

  @Quando("^ele enviar mensagem como um \"([^\"]*)\" sem preencher a ordem do pedido$")
  public void ele_enviar_mensagem_como_um_sem_preencher_a_ordem_do_pedido(String cliente) {
    contactNosPage.selecionarTipoCliente(cliente);
    contactNosPage.preencherEmail();
    contactNosPage.preencherMensagem();
    contactNosPage.enviarMensagem();
  }

  /* =========================ENTÃO========================= */
  @Então("^ele verifica que a mensagem foi enviada pelo texto: \"([^\"]*)\"$")
  public void ele_verifica_que_a_mensagem_foi_enviada_pelo_texto(String mensagem) {
    assertTrue(contactNosPage.verificarEnvioMensagemSucesso(mensagem));
  }

  @Então("^ele verifica que a mensagem não foi enviada pelo texto: \"([^\"]*)\"$")
  public void ele_verifica_que_a_mensagem_nao_foi_enviada_pelo_texto(String mensagem) {
    assertTrue(contactNosPage.verificarEnvioMensagemInvalida(mensagem));
  }
}
