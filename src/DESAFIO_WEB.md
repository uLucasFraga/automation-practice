# DESAFIO-WEB

Repositório para testes automáticos para WEB.
- WEB: selenium, cucumber, junit e allure

> Testando e validando navegadores com selenium em java: [SELENIUM](https://github.com/SeleniumHQ/selenium)

---

##### status:

![TEST CI/CD](https://github.com/uLucasFraga/gfi-world-automation/workflows/TEST%20CI/CD/badge.svg)


## Índice sobre o projeto:

> Índice [README:](https://github.com/uLucasFraga/gfi-world-automation/blob/master/README.md)

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

###### java: `export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_191.jdk/Contents/Home`

###### maven: `export PATH=/opt/apache-maven-3.5.3/bin:$PATH`

##### Instalar Java
- Mac, Windows e Linux: https://www.liquidweb.com/kb/how-to-install-java-on-ubuntu-windows-and-macos

##### Instalar Maven
- Mac, Windows e Linux: https://www.baeldung.com/install-maven-on-windows-linux-mac

Criar um projeto _maven_ ou usar o arquivo _pom.xml_ para fazer o download/instalar as dependências

## Instalação

> Clonar o projeto

- Clonar esse repositório localmente usando http ou ssh, por exemplo:

`git clone https://github.com/uLucasFraga/gfi-world-automation.git`

- Limpar e instalar todas as dependências (pom.xml):

`cd /seu_projeto`

`mvn clean install`

![Instalando as dependências via mvn](http://g.recordit.co/vCNaZgadVu.gif)

> Dicas

- Use o pom.xml para fazer download de suas novas libs para manter o projeto rodando via terminal

## Como testar

Antes de rodar os testes sigam os passos abaixo:

- Criar um arquivo `config.properties` dentro da pasta *resources*
- Inserir dados válidos

###### Nota¹: seguir o exemplo do arquivo: `config.properties.example`
Exemplo dos dados abaixo:

```
BASE_URL=https://com.gfi.com.gfi.world/pt-pt
```

###### Nota²:
Como boa prática por questão de segurança, esses dados poderiam ser considerados sensíveis por isso é interessante não expormos no código.
Então, o projeto ignora o arquivo de config (via .gitignore). Basta cria-lo antes de rodar.

> rodar todos os testes com o maven
```
$ mvn clean test
```

> rodar todos os testes com o cucumber
```
$ mvn clean -Dtest=CucumberRunnerTest test
```

> rodar os testes com cucumber através de uma tag (ex: tag @exemplo)
```
$ mvn test -DCucumber.options="--tags '@exemplo'"
```

> rodar os testes via IDE (IntelliJ)

Clicar com o botão direito no projeto/class **gfi.world-automation > Run 'AllTests'** ou **CTRL+F5**

## Report
Após a etapa de testes, será criada uma pasta chamada `allure-results` e diversos arquivos **.json** dentro.
Para visualizarmos o "**report**" com as métricas de testes do **Allure**, devemos baixar o `allure command line tool` para facilitar.

- [Allure command line](https://github.com/etki/allure-cli)

Depois de baixado, basta usarmos o comando: `allure serve allure-results` e vermos o servidor do **Allure** subindo com as métricas.

###### Nota³:
Os arquivos **.json** são gerados sempre que algum teste é rodado.

Então, para não metrificar os testes desnecessários, basta rodarmos o comando `mvn clean` antes de qualquer comando.

Exemplo:
```
mvn clean test-compile -Dit.test=AllRegressionIT verify -DskipUTs=true
allure serve allure-results
```
O reporte do Allure subira-a automaticamente.

--- 

## Licença

[![License](http://img.shields.io/:license-mit-blue.svg?style=flat-square)](http://badges.mit-license.org)

- **[MIT license](http://opensource.org/licenses/mit-license.php)**
- Copyright 2020 © <a href="https://www.linkedin.com/in/dtferreira/" target="_blank">Diogo Ferreira</a>.