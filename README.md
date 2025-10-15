[![Finalizado](https://img.shields.io/badge/Status-Conclu%C3%ADdo-brightgreen)](https://github.com/oryanend/workshop-cassandra)

<h1 align="center">Workshop Cassandra</h1>

<p align='center'> 
    <img src="https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot"/> 
    <img src="https://img.shields.io/badge/Cassandra-1287B1?style=for-the-badge&logo=apache%20cassandra&logoColor=white"/>
    <img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white"/>
</p>    

<p align="center">
  <img src="docs/logo.png" alt="Logo DSCommerce" height="300">
</p>

[Testando endpoints.webm](https://github.com/matheusvidal21/DSCommerce/assets/102569695/8dc7beb7-7542-48c1-a731-dda4f41c7507)

# 🔍 Visão Geral
<p>
O <strong>Workshop Cassandra</strong> é um projeto prático desenvolvido com <strong>Java Spring Boot</strong> e <strong>Apache Cassandra</strong>, com o objetivo de demonstrar a modelagem e a manipulação de dados em um banco NoSQL utilizando um cenário de produtos e departamentos.
</p>

<p>
O projeto reforça o uso de boas práticas no desenvolvimento backend com <strong>Spring Boot</strong>, integração com <strong>Cassandra</strong> e consultas otimizadas em ambientes distribuídos.
</p>

<p>
As principais funcionalidades incluem:
</p>

<ul>
  <li>Cadastro, atualização, listagem e exclusão de <strong>departamentos</strong>.</li>
  <li>Cadastro e gerenciamento de <strong>produtos</strong> associados a um departamento.</li>
  <li>Busca de produtos por <strong>nome do departamento</strong>.</li>
  <li>Busca de produtos por <strong>texto na descrição</strong>.</li>
  <li>Consulta de todos os <strong>detalhes de um produto</strong>, incluindo suas <strong>propriedades (Props)</strong>.</li>
</ul>

<p>
O projeto aplica boas práticas no desenvolvimento backend com <strong>Spring Boot</strong>, <strong>API RESTful</strong> e integração com um <strong>banco de dados distribuído</strong>.
</p>

## Índice
- 🧠 [Modelo conceitual](#-modelo-conceitual)
- 📁 [Estrutura de pacotes](#-estrutura-de-pacotes)
- 💻 [Tecnologias utilizadas](#-tecnologias-utilizadas)
- 🔧 [Como executar](#-como-executar)
- 🛠️ [Testando a API com o Postman](#%EF%B8%8F-testando-a-api-com-o-postman)
- 👥 [Autor](#-autor)

# 🧠 Modelo conceitual
<p>
O modelo conceitual do <strong>Workshop Cassandra</strong> representa a relação entre <strong>departamentos</strong>, <strong>produtos</strong> e suas <strong>propriedades</strong>, servindo como base para o armazenamento de dados no <strong>Apache Cassandra</strong>.
</p>

<p>
Cada <strong>Department</strong> possui vários <strong>Product</strong>, que contêm informações como nome, descrição, preço e data de criação. 
Os produtos podem ter várias <strong>Prop</strong> (propriedades), que armazenam características adicionais como nome, valor e tipo.
</p>

<p>
O tipo da propriedade é definido pelo enumerador <strong>PropType</strong>, que indica se a propriedade se refere ao <code>PRODUCT</code> ou à <code>CONDITION</code>.
</p>

<p align="center">
  <img src="docs/modelo_conceitual.png" alt="Modelo conceitual">
</p>

# 📁 Estrutura de pacotes
* **`/docs`** — Documentação do projeto (visão geral, diagramas e modelos de dados).
* **`/src`** — Código-fonte principal da aplicação:
  * **`/config`** — Configurações da aplicação (segurança, conexão com Cassandra e beans do Spring).
  * **`/controllers`** — Controladores REST que tratam requisições HTTP e retornam respostas.
  * **`/model`**: Pacote mais abrangente que pode conter classes de modelo de domínio que não são diretamente entidades persistidas, mas que representam conceitos importantes do negócio ou estruturas de dados auxiliares.
    * **`/dto`** — Objetos de transferência de dados entre camadas (Data Transfer Objects).
    * **`/embedded`**: Classes de dados complexos ou objetos incorporados em outras entidades.
    * **`/entities`** — Classes que representam as entidades do domínio, mapeadas para as tabelas do Cassandra.
    * **`/enums`**: Armazena as enumerações utilizadas no projeto para definir conjuntos fixos de valores.
  * **`/repositories`** — Interfaces de persistência baseadas no Spring Data Cassandra.
  * **`/services`** — Lógica de negócio da aplicação e orquestração das operações.
  * **`/exceptions`** — Exceções personalizadas para tratamento de erros.
* **`.gitignore`** — Define arquivos e pastas ignorados pelo Git.
* **`README.md`** — Documentação principal com informações e instruções do projeto.
* **`pom.xml`** — Arquivo do Maven responsável pelas dependências e configurações de build.
* **`mvnw` / `mvnw.cmd`** — Scripts Maven Wrapper que garantem o uso da versão correta do Maven.
* **`.mvn/wrapper`** — Arquivos de suporte do Maven Wrapper.


# 💻 Tecnologias utilizadas
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
![Cassandra](https://img.shields.io/badge/Cassandra-1287B1?style=for-the-badge&logo=apache%20cassandra&logoColor=white)

# 🔧 Como executar?
Segue abaixo as instruções para executar o projeto:

## Pré-requisitos
- Certifique-se de ter o Java JDK instalado na sua máquina
- Instale o IntelliJ IDEA ou outra IDE de sua preferência para desenvolvimento Java
- É necessário ter o Maven instalado em sua máquina

### Passo 1: Clonar o Repositório
```
git clone git@github.com:oryanend/workshop-cassandra.git
```

### Passo 2: Importar o Projeto
- Abra o Intellij IDEA ou sua IDE de preferência
- Selecione "Open" no menu e escolha o diretório do projeto clonado
- Aguarde até que o IntelliJ configure o projeto

### Passo 3: Configuração
- Verifique se todas as dependências foram carregadas corretamente pelo Maven 

### Passo 4: Execução
- Localize a classe principal da aplicação `WorkshopCassandraApplication`(localizado em src/main/java/com/oryanend/workshopcassandra/WorkshopCassandraApplication.java) e execute-a
- Ou, se preferir utilizar o Maven, você pode executar o projeto a partir da linha de comando:
```
mvn spring-boot:run
```

### Passo 5: Acesso à Aplicação
- Uma vez que a aplicação esteja em execução, você pode interagir com ela consumindo os endpoints da API. Para isso, recomenda-se o uso de ferramentas como o Postman, que permite fazer requisições HTTP de forma fácil e eficiente
- Se preferir, também é possível acessá-la através do navegador web, digitando o endereço <b> `http://localhost:8080` na barra de endereços

# 🛠️ Testando a API com o Postman
Para facilitar o teste dos endpoints da API, disponibilizei uma coleção e um ambiente (environment) no Postman contendo todas as requisições disponíveis. Siga os passos abaixo para importar a coleção e começar a testar:
1. Baixe e Instale o Postman
- Se você ainda não tem o Postman instalado, você pode baixá-lo e instalá-lo gratuitamente a partir do [site oficial](https://www.postman.com/downloads/)
2. Importe a collection e o environment
- Após instalar o Postman, faça o download da coleção que disponibilizei. Você pode encontrá-la [aqui](DSProducts.postman_collection.json)
- Também faça o download do ambiente (environment) localizado [aqui](https://github.com/oryanend/workshop-cassandra/blob/main/Workshop-Cassandra%20Env.postman_environment.json)
3. Importe no Postman
- Abra o Postman e clique no botão "File" localizado no canto superior esquerdo da interface. Em seguida, selecione a opção "Import" e depois localize os dois arquivos e selecione-os
4. Teste os Endpoints
- Agora que a coleção foi importada com sucesso, você verá todas as requisições listadas no painel esquerdo do Postman. Basta selecionar a requisição desejada e clicar em "Send" para testá-la
- Na parte superior direita do Postman, você verá um dropdown com a lista de environments. Selecione o environment recém-importado
  
Com a coleção disponível no Postman, você poderá testar facilmente todos os endpoints da sua API e garantir que ela esteja funcionando corretamente.

# 👥 Autor

| [<img src="https://avatars.githubusercontent.com/u/135620793?v=4" width=115><br><sub>Ryan Oliveira</sub>](https://github.com/matheusvidal21) |
| :---: |
