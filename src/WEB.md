# TESTES-WEB

Repositório para testes automatizados para WEB.
- WEB: selenium, cucumber, junit e allure

> Testando e validando navegadores com selenium em java: [SELENIUM](https://github.com/SeleniumHQ/selenium)

---

##### status:

[![CONTINUOUS INTEGRATION](https://github.com/uLucasFraga/automation-practice/workflows/CONTINUOUS%20INTEGRATION/badge.svg?branch=develop)](https://github.com/uLucasFraga/automation-practice/actions)


## Índice sobre o projeto:

> Índice [README:](https://github.com/uLucasFraga/automation-practice/blob/main/README.md)

- [Pre-requisitos](#pre-requisitos)
- [Configuração](#configuração)
- [Instalação](#instalação)
- [Como testar](#como-testar)
- [Report](#report)

---

## Pre-requisitos

- [Instalar JDK 8+](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Instalar Maven](https://maven.apache.org/install.html)
- [Instalar IntelliJ ou outra IDE](https://www.jetbrains.com/idea/download/)
- [Exemplo com selenium](https://medium.com/@mlvandijk/getting-started-with-cucumber-in-java-a-10-minute-tutorial-586652d2c82)

## Configuração

> variáveis de ambientes e bash_profile - exemplos:

###### java: `export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk{sua_versão_aqui}.jdk/Contents/Home`

###### maven: `export PATH=/opt/apache-maven-{sua_versão_aqui}/bin:$PATH`

##### Instalar Java
- Mac, Windows e Linux: https://www.liquidweb.com/kb/how-to-install-java-on-ubuntu-windows-and-macos

##### Instalar Maven
- Mac, Windows e Linux: https://www.baeldung.com/install-maven-on-windows-linux-mac

Criar um projeto _maven_ ou usar o arquivo _pom.xml_ para fazer o download e instalar as dependências.

## Instalação

> Clonar o projeto

- Clonar esse repositório localmente usando http ou ssh, por exemplo:

`git clone https://github.com/uLucasFraga/automation-practice.git`

- Limpar e instalar todas as dependências (pom.xml):

`cd /seu_projeto`

`mvn clean install`

![Instalando as dependências via mvn](http://g.recordit.co/vCNaZgadVu.gif)

> Dicas

- Use o pom.xml para fazer download de sua nova lib para manter o projeto rodando via terminal

## Como testar

Antes de rodar os testes sigam os passos abaixo:

- Criar um arquivo `config.properties` dentro da pasta *resources*
- Inserir dados válidos

###### Nota¹: seguir o exemplo do arquivo: `config.properties.example`
Exemplo dos dados abaixo:

```
BASE_URL=http://automationpractice.com
```

###### Nota²:
Como boa prática por questão de segurança e exercícios, esses dados poderiam ser considerados sensíveis por isso é interessante não expormos no código.
Então, o projeto ignora o arquivo de config (via .gitignore). Basta cria-lo antes de rodar.

> rodar todos os testes com o maven
```
$ mvn clean test
```

> rodar todos os testes com o cucumber
```
$ mvn clean -Dtest=CucumberRunnerTest test
```

> rodar os testes com cucumber através de uma tag (ex: tag @regressao)
```
$ mvn test -DCucumber.options="--tags '@regressao'"
```

> rodar os testes via IDE (IntelliJ)

Clicar com o botão direito no projeto/class **automation-practice > Run 'AllTests'** ou **CTRL+F5**

## Report
Após a etapa de testes, será criada uma pasta chamada `allure-results` e diversos arquivos **.json** dentro.
Para visualizarmos o "**report**" com as métricas de testes do **Allure**, temos duas opções:

1 - através do plugin maven-allure, rodarmos o seguinte comando: `mvn allure:serve`

> exemplo_com_maven_allure:
```
mvn clean test
mvn allure:serveallure serve allure-results
```

2 - podemos baixar o [Allure command line](https://github.com/etki/allure-cli) e usarmos o comando: `allure serve allure-results`

> exemplo_com_allure_command_line:
```
mvn clean test
allure serve {pasta_do_allure_results}
```
O reporte do **Allure** subira-a automaticamente.

###### Nota³:
Os arquivos **.json** são gerados sempre que algum teste é "rodado".
Então, caso prefira utilizar o allure_command_line, rode antes o comando `mvn clean` para limpar a pasta e metrificar corretamente.

--- 

## Licença

[![License](http://img.shields.io/:license-mit-blue.svg?style=flat-square)](http://badges.mit-license.org)

- **[MIT license](http://opensource.org/licenses/mit-license.php)**
- Copyright 2020 © <a href="https://www.linkedin.com/in/ulucasfraga/" target="_blank">Lucas Fraga</a>.
