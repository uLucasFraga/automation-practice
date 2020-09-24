#language: pt

@exemplo
Funcionalidade: Parceiros do Gfi World
  Como um QA
  Gostaria de automatizar o site gfi-world
  Para contabilizar a sessão de Carreiras
  De acordo com a etapa sugerida pelo processo seletivo

  Contexto: Acessar site gfi-world
    Dado que ele acessa o site gfi-world

  Cenário: verificar se existem parceiros no site
    Dado que ele esteja na sessão "Parceiros"
    Então ele verifica que a lista de parceiros foi exibida com sucesso

  Cenário: verificar a quantidade de parceiros disponíveis no site
    Dado que ele esteja na sessão "Parceiros"
    Então ele verifica a quantidade de parceiros com sucesso

  Cenário: verificar quais são os parceiros no site
    Dado que ele esteja na sessão "Parceiros"
    Então ele verifica os nomes dos parceiros com sucesso