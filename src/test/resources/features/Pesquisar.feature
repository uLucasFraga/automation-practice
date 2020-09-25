#language: pt

@acessar @regressao
Funcionalidade: Buscar produtos
  Como um QA
  Gostaria de acessar o site do "automation-practice"
  Para buscar diferentes produtos e verificar o que for necessário conforme os cenários abaixo

  Contexto: Acessar o site
    Dado que ele acessa o site

  Cenário: Buscar por um produto existente
    Quando ele pesquisar por "Blouse"
    Então ele verifica que a pesquisa por "Blouse" foi feita com sucesso

  Cenário: Buscar por um produto inexistente
    Quando ele pesquisar por "Blusa"
    Então ele verifica que a pesquisa por "Blusa" não existe