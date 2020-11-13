#language: pt

@enviar_mensagem @regressao
Funcionalidade: Enviar mensagem
  Como um QA
  Gostaria de acessar o site do "automation-practice"
  Para enviar uma mensagem de acordo com o serviço necessário conforme os cenários abaixo

  Contexto: Acessar o site
    Dado que ele acessa o site

  Cenário: Enviar mensagem como um "customer service"
    Dado que ele acessa a sessão de "Contact us"
    Quando ele enviar mensagem como um "Customer service"
    Então ele verifica que a mensagem foi enviada pelo texto: "Your message has been successfully sent to our team."

  Cenário: Enviar mensagem como um "customer service"
    Dado que ele acessa a sessão de "Contact us"
    Quando ele enviar mensagem como um "Webmaster"
    Então ele verifica que a mensagem foi enviada pelo texto: "Your message has been successfully sent to our team."

  Cenário: Enviar mensagem faltando a escolha do tipo de cliente
    Dado que ele acessa a sessão de "Contact us"
    Quando ele enviar mensagem como um "-- Choose --"
    Então ele verifica que a mensagem não foi enviada pelo texto: "Please select a subject from the list provided."

  Cenário: Enviar mensagem faltando preencher o email
    Dado que ele acessa a sessão de "Contact us"
    Quando ele enviar mensagem como um "Customer service" sem preencher o email
    Então ele verifica que a mensagem não foi enviada pelo texto: "Invalid email address."

  Cenário: Enviar mensagem faltando preencher a ordem do pedido
    Dado que ele acessa a sessão de "Contact us"
    Quando ele enviar mensagem como um "Customer service" sem preencher a ordem do pedido
    Então ele verifica que a mensagem foi enviada pelo texto: "Your message has been successfully sent to our team."

  Cenário: Enviar mensagem sem preencher os campos do tipo de cliente e o email
    Dado que ele acessa a sessão de "Contact us"
    Quando ele enviar mensagem como um "-- Choose --" sem preencher o email
    Então ele verifica que a mensagem não foi enviada pelo texto: "Invalid email address."