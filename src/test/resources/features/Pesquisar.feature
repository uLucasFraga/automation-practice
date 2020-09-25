#language: pt

@acessar @regressao
Funcionalidade: Buscar produtos
  Como um QA
  Gostaria de acessar o site do "automation-practice"
  Para buscar diferentes produtos e verificar o que for necessário conforme os cenários abaixo

  Contexto: Acessar o site
    Dado que ele acessa o site

  Cenário: Buscar por apenas um produto existente
    Quando ele pesquisar por "Blouse"
    Então ele verifica que a pesquisa por "Blouse" foi feita com sucesso

  Cenário: Buscar por produto existente em grande quantidade
    Quando ele pesquisar por "Dresses"
    Então ele verifica que existem produtos pela mensagem: "7 results have been found"

  Cenário: Buscar por um produto inexistente
    Quando ele pesquisar por "Blusa"
    Então ele verifica que o produto não existe pela mensagem: "No results were found for your search"

  Cenário: Buscar por um produto sem preencher nada no campo de pesquisa
    Quando ele pesquisar por ""
    Então ele verifica que o produto não existe pela mensagem: "Please enter a search keyword"