package br.com.automation.practice.pages;

import br.com.automation.practice.utils.commons.PaginaBase;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;

public class ContacteNosPagina extends PaginaBase {

  private final By SELECIONAR_CONTATO = By.id("id_contact");
  private final By INPUT_EMAIL = By.id("email");
  private final By INPUT_PEDIDO = By.id("id_order");
  private final By INPUT_MENSAGEM = By.id("message");
  private final By BOTAO_ENVIAR_MENSAGEM = By.id("submitMessage");
  private final By ALERTA_SUCESSO_MENSAGEM = By.cssSelector("p[class='alert alert-success']");
  private final By ALERTA_ERRO_MENSAGEM = By.cssSelector("div[class='alert alert-danger'] li");

  Faker faker = new Faker();
  String email = faker.internet().emailAddress();
  String pedido = faker.commerce().promotionCode();
  String mensagem = faker.chuckNorris().fact();

  public void selecionarTipoCliente(String cliente) {
    selecionarPorTexto(SELECIONAR_CONTATO, cliente);
  }

  public void preencherEmail() {
    esperarElemento(INPUT_EMAIL);
    preencherCampo(INPUT_EMAIL, email);
  }

  public void preencherReferenciaPedido() {
    esperarElemento(INPUT_PEDIDO);
    preencherCampo(INPUT_PEDIDO, pedido);
  }

  public void preencherMensagem() {
    esperarElemento(INPUT_MENSAGEM);
    preencherCampo(INPUT_MENSAGEM, mensagem);
  }

  public void enviarMensagem() {
    estaClicavel(BOTAO_ENVIAR_MENSAGEM);
    clicar(BOTAO_ENVIAR_MENSAGEM);
  }

  public boolean verificarEnvioMensagemSucesso(String mensagem) {
    estaVisivel(ALERTA_SUCESSO_MENSAGEM);
    return pegarTexto(ALERTA_SUCESSO_MENSAGEM).equals(mensagem);
  }

  public boolean verificarEnvioMensagemInvalida(String mensagem) {
    estaClicavel(ALERTA_ERRO_MENSAGEM);
    return pegarTexto(ALERTA_ERRO_MENSAGEM).equals(mensagem);
  }
}
