# Projeto CRUD Spring Boot

Este projeto é uma aplicação CRUD (Create, Read, Update, Delete) desenvolvida com Spring Boot, utilizando um banco de dados H2 e integrando com o Spring Data JPA. A aplicação foi projetada para gerenciar entidades de produtos de forma simples e eficiente.

## Sumário

1. [Como Executar](#como-executar)
2. [Como Testar](#como-testar)
3. [Padrões de Projeto e Padrões Usados](#padrões-de-projeto-e-padrões-usados)
4. [Conclusão](#conclusão)

---

## Como Executar

### Requisitos

- Java 17 ou superior
- Maven
- IDE (como IntelliJ IDEA, Eclipse ou VSCode) ou terminal

### Passos

1. Clone o repositório:

   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   cd seu-repositorio

2. Navegue até o diretório do projeto e execute o comando Maven para rodar a aplicação:

No terminal:

mvn clean install
mvn spring-boot:run

## Como Testar

### Testes Automatizados
O projeto utiliza testes automatizados para garantir o bom funcionamento das funcionalidades. Estes testes estão localizados na pasta src/test/java. Para rodar os testes unitários, utilize o comando Maven abaixo:

mvn test

### Testes de Health Check
A aplicação expõe endpoints para verificar seu status e saúde através do Spring Actuator. Você pode testar a saúde da aplicação acessando o seguinte endpoint (Este endpoint retornará um JSON indicando o status da aplicação):


http://localhost:8080/actuator/health


### Testes de Funcionalidade

A aplicação possui endpoints REST para gerenciar produtos:

GET /api/products: Listar todos os produtos

GET /api/products/{id}: Buscar um produto específico por ID

POST /api/products: Criar um novo produto

PUT /api/products/{id}: Atualizar um produto existente

DELETE /api/products/{id}: Deletar um produto

Você pode testar essas funcionalidades usando ferramentas como Postman ou cURL.

## Padrões de Projeto e Padrões Usados

### Arquitetura

O projeto segue uma arquitetura limpa e modular, dividida nas seguintes camadas:

Controller Layer: Responsável por mapear as requisições HTTP para os serviços.
Service Layer: Contém a lógica de negócio e interage com o repositório.
Repository Layer (DAO): Responsável pela persistência dos dados. Utiliza o Spring Data JPA para abstrair a manipulação direta do banco de dados.

### Padrões de Projeto

DAO (Data Access Object): Usado para encapsular o acesso ao banco de dados, permitindo que a aplicação interaja com as entidades através de métodos como save(), findById(), entre outros.

DTO (Data Transfer Object): Usado para transferir dados entre as camadas da aplicação, evitando expor diretamente as entidades do banco de dados. O DTO é uma representação simplificada dos dados que podem ser enviados ou recebidos por meio da API.

Factory Pattern: Embora o padrão não tenha sido explicitamente implementado no código, o Spring Boot utiliza o padrão Factory para criação de beans e objetos de configuração, com a anotação @Bean e o gerenciamento de dependências do Spring Context.

Singleton: O Spring Boot usa o padrão Singleton para gerenciar as instâncias de beans, como serviços e repositórios, garantindo que apenas uma instância seja criada durante a execução da aplicação.

Service Layer: A camada de serviço é responsável por implementar a lógica de negócio da aplicação e por interagir com os repositórios para manipulação dos dados.

Controller Layer: Utiliza o padrão de design MVC (Model-View-Controller) para separar as preocupações e lidar com as requisições HTTP. As classes de controladores mapeiam as rotas e chamam os métodos da camada de serviço.

Spring Boot Actuator
O projeto utiliza o Spring Boot Actuator para fornecer informações sobre o status da aplicação e expor métricas de monitoramento. A configuração padrão inclui endpoints como:
health: Verifica o status da aplicação
info: Exibe informações gerais sobre a aplicação
Esses endpoints ajudam na monitoração e garantem que a aplicação esteja funcionando corretamente em produção.

## Conclusão

Este projeto é um exemplo básico de uma aplicação CRUD utilizando Spring Boot, com uma arquitetura modular e padrões de projeto como DAO, DTO e Factory. Com o Spring Boot Actuator, é fácil monitorar a saúde da aplicação e expor informações úteis para a operação em produção.

Se tiver dúvidas ou problemas, sinta-se à vontade para abrir uma issue ou contribuir com melhorias!

### Como usar:

1. **Como Executar**: O fluxo começa com a clonagem do repositório, configuração do ambiente (Java 17), e execução da aplicação com Maven.
2. **Como Testar**: Instruções sobre como executar os testes automatizados, verificar a saúde da aplicação com Actuator, e testar os endpoints via Postman ou cURL.
3. **Padrões de Projeto**: Explicação sobre a arquitetura e padrões de projeto utilizados no sistema, c