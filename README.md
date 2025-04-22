# Projeto CRUD Api Produtos Spring Boot

Este projeto é uma aplicação CRUD (Create, Read, Update, Delete) desenvolvida com Spring Boot, utilizando um banco de dados H2 e integrando com o Spring Data JPA. A aplicação foi projetada para gerenciar entidades de produtos de forma simples e eficiente.

## Sumário

1. [Como Executar](#como-executar)
2. [Como Testar](#como-testar)
3. [Documentação](#documentação)
4. [Tratamento de Erros](#tratamento-de-erros)
5. [Padrões de Projeto e padrões Usados](#padrões-de-projeto-e-padrões-usados)
6. [Melhorias](#melhorias)
7. [Conclusão](#conclusão)
8. [Licença](#licença)
9. [Contato](#contato)

---------

## Como Executar

### Requisitos

- Java 17 ou superior
- Maven
- IDE (como IntelliJ IDEA, Eclipse ou VSCode) ou terminal

### Passos

1. Clone o repositório:

   git clone https://github.com/guilhermegoett/crud-produtos-clean-hexagonal.git

   cd crud

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

## Documentação

A documentação da API estр disponível através do Swagger e pode ser acessada diretamente através da URL:

http://localhost:8080/swagger-ui.html

O Swagger irá fornecer uma interface interativa para visualizar todos os endpoints da API, enviar requisições e ver as respostas.

## Tratamento de Erros

A aplicação utiliza a anotação @ControllerAdvice para capturar e tratar exceções de forma centralizada e elegante, seguindo os princípios do Clean Code e separação de responsabilidades.

Foi criada uma classe de configuração dedicada ao tratamento de exceções globais, permitindo que qualquer erro seja interceptado e retornado ao cliente com uma mensagem clara e apropriada.

Atualmente, a aplicação trata explicitamente a exceção IllegalArgumentException, que é lançada quando ocorrem erros de validação nos dados de entrada. Um exemplo prático é o tratamento do caso de preço negativo durante a criação de um produto.

Exemplo de resposta para entrada inválida:

{
    "error": "Preço inválido",
    "message": "O campo 'preço' deve ser um valor positivo.",
    "timestamp": "2025-04-21T21:28:44.3605334",
    "status": 400
}

## Padrões de Projeto e Padrões Usados

### Arquitetura

O projeto adota a Arquitetura Hexagonal (Ports and Adapters) aliada aos princípios de Clean Code, promovendo alta coesão, baixo acoplamento e facilidade de manutenção. A estrutura é organizada em camadas bem definidas:

Controller Layer (Adapter de entrada): Responsável por mapear as requisições HTTP para os serviços da aplicação. Atua como uma porta de entrada para os casos de uso.

Service Layer (Application Service): Contém a lógica de negócio da aplicação. Faz a mediação entre os adaptadores e o núcleo de domínio.

Domain Layer: Representa o núcleo da aplicação, onde ficam as entidades e regras de negócio puras.

Repository Layer (DAO / Port de saída): Responsável pela persistência dos dados. Utiliza o Spring Data JPA para abstrair a manipulação direta do banco de dados. As interfaces (ports) são implementadas por adaptadores que interagem com o banco.

Essa abordagem permite que o domínio da aplicação permaneça independente de frameworks, detalhes de infraestrutura e interfaces externas.

### Padrões de Projeto

DAO (Data Access Object): Usado para encapsular o acesso ao banco de dados, permitindo que a aplicação interaja com as entidades através de métodos como save(), findById(), entre outros.

DTO (Data Transfer Object): Usado para transferir dados entre as camadas da aplicação, evitando expor diretamente as entidades do banco de dados. O DTO é uma representação simplificada dos dados que podem ser enviados ou recebidos por meio da API.

Factory Pattern: Embora o padrão não tenha sido explicitamente implementado no código, o Spring Boot utiliza o padrão Factory para criação de beans e objetos de configuração, com a anotação @Bean e o gerenciamento de dependências do Spring Context.

Singleton: O Spring Boot usa o padrão Singleton para gerenciar as instâncias de beans, como serviços e repositórios, garantindo que apenas uma instРncia seja criada durante a execução da aplicação.

Service Layer: A camada de serviço é responsрvel por implementar a lзgica de negзcio da aplicação e por interagir com os repositórios para manipulaусo dos dados.

Controller Layer: Utiliza o padrão de design MVC (Model-View-Controller) para separar as preocupações e lidar com as requisições HTTP. As classes de controladores mapeiam as rotas e chamam os métodos da camada de serviço.

Spring Boot Actuator
O projeto utiliza o Spring Boot Actuator para fornecer informações sobre o status da aplicação e expor métricas de monitoramento. A configuração padrão inclui endpoints como:
health: Verifica o status da aplicação

http://localhost:8080/actuator/health

info: Exibe informações gerais sobre a aplicação

http://localhost:8080/v3/api-docs

Esses endpoints ajudam na monitoração e garantem que a aplicação esteja funcionando corretamente em produção.

## Melhorias

Ativar HTTPS localmente para testes:

1. Gere um certificado (autoassinado para testes)

keytool -genkeypair -alias meu-certificado \
  -keyalg RSA -keysize 2048 -storetype PKCS12 \
  -keystore keystore.p12 -validity 3650

2. Coloque o arquivo keystore.p12 no seu projeto (ex: pasta src/main/resources)

3. Configure o application.properties ou application.yml:

server.port=8443
server.ssl.enabled=true
server.ssl.key-store=classpath:keystore.p12
server.ssl.key-store-password=sua_senha
server.ssl.key-store-type=PKCS12
server.ssl.key-alias=meu-certificado

## Conclusão

Este projeto é um exemplo básico de uma aplicação CRUD utilizando Spring Boot, com uma arquitetura modular e padrões de projeto como DAO, DTO e Factory. Com o Spring Boot Actuator, é fácil monitorar a saúde da aplicação e expor informações úteis para a operação em produção.

Se tiver dúvidas ou problemas, sinta-se à vontade para abrir uma issue ou contribuir com melhorias!

## Licença

Este projeto é distribuído sob a licença MIT. Veja `LICENSE` para mais informações.

## Contato

Caso tenha dúvidas ou sugestões, entre em contato pelo e-mail **[guilhermegoet@gmail.com](mailto:guilhermegoet@gmail.com)**.
