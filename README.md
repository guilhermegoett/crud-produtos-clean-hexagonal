# Projeto CRUD Spring Boot

Este projeto � uma aplica��o CRUD (Create, Read, Update, Delete) desenvolvida com Spring Boot, utilizando um banco de dados H2 e integrando com o Spring Data JPA. A aplica��o foi projetada para gerenciar entidades de produtos de forma simples e eficiente.

## Sum�rio

1. [Como Executar](#como-executar)
2. [Como Testar](#como-testar)
3. [Padr�es de Projeto e Padr�es Usados](#padr�es-de-projeto-e-padr�es-usados)
4. [Conclus�o](#conclus�o)

---

## Como Executar

### Requisitos

- Java 17 ou superior
- Maven
- IDE (como IntelliJ IDEA, Eclipse ou VSCode) ou terminal

### Passos

1. Clone o reposit�rio:

   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   cd seu-repositorio

2. Navegue at� o diret�rio do projeto e execute o comando Maven para rodar a aplica��o:

No terminal:

mvn clean install
mvn spring-boot:run

## Como Testar

### Testes Automatizados
O projeto utiliza testes automatizados para garantir o bom funcionamento das funcionalidades. Estes testes est�o localizados na pasta src/test/java. Para rodar os testes unit�rios, utilize o comando Maven abaixo:

mvn test

### Testes de Health Check
A aplica��o exp�e endpoints para verificar seu status e sa�de atrav�s do Spring Actuator. Voc� pode testar a sa�de da aplica��o acessando o seguinte endpoint (Este endpoint retornar� um JSON indicando o status da aplica��o):


http://localhost:8080/actuator/health


### Testes de Funcionalidade

A aplica��o possui endpoints REST para gerenciar produtos:

GET /api/products: Listar todos os produtos

GET /api/products/{id}: Buscar um produto espec�fico por ID

POST /api/products: Criar um novo produto

PUT /api/products/{id}: Atualizar um produto existente

DELETE /api/products/{id}: Deletar um produto

Voc� pode testar essas funcionalidades usando ferramentas como Postman ou cURL.

## Padr�es de Projeto e Padr�es Usados

### Arquitetura

O projeto segue uma arquitetura limpa e modular, dividida nas seguintes camadas:

Controller Layer: Respons�vel por mapear as requisi��es HTTP para os servi�os.
Service Layer: Cont�m a l�gica de neg�cio e interage com o reposit�rio.
Repository Layer (DAO): Respons�vel pela persist�ncia dos dados. Utiliza o Spring Data JPA para abstrair a manipula��o direta do banco de dados.

### Padr�es de Projeto

DAO (Data Access Object): Usado para encapsular o acesso ao banco de dados, permitindo que a aplica��o interaja com as entidades atrav�s de m�todos como save(), findById(), entre outros.

DTO (Data Transfer Object): Usado para transferir dados entre as camadas da aplica��o, evitando expor diretamente as entidades do banco de dados. O DTO � uma representa��o simplificada dos dados que podem ser enviados ou recebidos por meio da API.

Factory Pattern: Embora o padr�o n�o tenha sido explicitamente implementado no c�digo, o Spring Boot utiliza o padr�o Factory para cria��o de beans e objetos de configura��o, com a anota��o @Bean e o gerenciamento de depend�ncias do Spring Context.

Singleton: O Spring Boot usa o padr�o Singleton para gerenciar as inst�ncias de beans, como servi�os e reposit�rios, garantindo que apenas uma inst�ncia seja criada durante a execu��o da aplica��o.

Service Layer: A camada de servi�o � respons�vel por implementar a l�gica de neg�cio da aplica��o e por interagir com os reposit�rios para manipula��o dos dados.

Controller Layer: Utiliza o padr�o de design MVC (Model-View-Controller) para separar as preocupa��es e lidar com as requisi��es HTTP. As classes de controladores mapeiam as rotas e chamam os m�todos da camada de servi�o.

Spring Boot Actuator
O projeto utiliza o Spring Boot Actuator para fornecer informa��es sobre o status da aplica��o e expor m�tricas de monitoramento. A configura��o padr�o inclui endpoints como:
health: Verifica o status da aplica��o
info: Exibe informa��es gerais sobre a aplica��o
Esses endpoints ajudam na monitora��o e garantem que a aplica��o esteja funcionando corretamente em produ��o.

## Conclus�o

Este projeto � um exemplo b�sico de uma aplica��o CRUD utilizando Spring Boot, com uma arquitetura modular e padr�es de projeto como DAO, DTO e Factory. Com o Spring Boot Actuator, � f�cil monitorar a sa�de da aplica��o e expor informa��es �teis para a opera��o em produ��o.

Se tiver d�vidas ou problemas, sinta-se � vontade para abrir uma issue ou contribuir com melhorias!

### Como usar:

1. **Como Executar**: O fluxo come�a com a clonagem do reposit�rio, configura��o do ambiente (Java 17), e execu��o da aplica��o com Maven.
2. **Como Testar**: Instru��es sobre como executar os testes automatizados, verificar a sa�de da aplica��o com Actuator, e testar os endpoints via Postman ou cURL.
3. **Padr�es de Projeto**: Explica��o sobre a arquitetura e padr�es de projeto utilizados no sistema, c