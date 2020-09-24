#language: pt

@exemplo
Funcionalidade: Carreiras do Gfi World
  Como um QA
  Gostaria de automatizar o site gfi-world
  Para contabilizar a sessão de Carreiras
  De acordo com a etapa sugerida pelo processo seletivo

  Contexto: Acessar site gfi-world
    Dado que ele acessa o site gfi-world

  Cenário: verificar se existem ofertas disponíveis no site
    Dado que ele esteja na sessão "Carreiras"
    Então ele verifica que "Todas as nossas oportunidades de carreira" foi exibido com sucesso

  Cenário: verificar a quantidade de oportunidades de emprego disponíveis no site
    Dado que ele esteja na sessão "Carreiras"
    Então ele verifica a quantidade de oportunidades de emprego com sucesso

  Cenário: verificar quais são as áreas das oportunidades de emprego no site
    Dado que ele esteja na sessão "Carreiras"
    Então ele verifica as áreas de oportunidades de emprego com sucesso