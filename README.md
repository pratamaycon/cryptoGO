<img width="150" height="150" align="right" src="https://upload.wikimedia.org/wikipedia/pt/4/47/UFF_bras%C3%A3o.png">

# Disciplina Desenvolvimento de Aplicações 2021/1

## Entrega 2 - Projeto e Implementação de uma API REST CryptoGO

## TÉCNOLOGIAS UTILIZADAS

- JAVA 8
- JPA
- SPRING BOOT 2.2.6
- MAVEN 3.6.1
- IDE ECLIPSE
- POSTGRESQL
- POSTMAN

### Descrição do Projeto

<p align="justify">

- {Leo}
  
</p>

### PRÉ REQUISITOS PARA RODAR ESSE PROJETO

- Para rodar localmente é necessário criar um database `cryptoGO` no seu Postgresql.
- Utilizar o Postman ou similiar. Nesse caso, temos o swagger porém ainda é necessário usar o postman para pegar *Accesstoken*  

### Para Utilizar API

1. Primeiro deve ser criado um usuário para que possa ser posível utilizar os demais endpoints.
2. Após a criação do usuário agora é possível acessar os demais endpoints.

[URL ENDPOINT](https://cryptogo-api.herokuapp.com/)

[Link Swagger](https://cryptogo-api.herokuapp.com/swagger-ui.html#/)

Obs: Ficará disponivel uma collection do postman com os testes que foram utilizados durante o desenvolvimento dessa API REST.
A collection está numa pasta chamada postman bem na raiz do projeto.

### URLS DOS ENDPOINTS - Autenticação

**POST**
URL do endpoint access token:

`https://cryptogo-api.herokuapp.com/oauth/token`

**DELETE**
URL do endpoint deslogar:

`https://cryptogo-api.herokuapp.com/tokens/revoke`

### URLS DOS ENDPOINTS - Usuário

**GET**
URL do endpoint que retorna uma lista de usuários:

`https://cryptogo-api.herokuapp.com/api/v1/users`

**GET**
URL do endpoint que retorna um usuario /{login}:

`https://cryptogo-api.herokuapp.com/api/v1/users/admin`

**POST**
URL do endpoint que cria um usuario:

`https://cryptogo-api.herokuapp.com/api/v1/users`

**PUT**
URL do endpoint que atualiza um usuario /{login}:

`https://cryptogo-api.herokuapp.com/api/v1/users/admin`

**PUT**
URL do endpoint que altera senha /{login}:

`https://cryptogo-api.herokuapp.com/api/v1/users/3/senha`

**DELETE**
URL do endpoint que deleta usuario /{login}:

`https://cryptogo-api.herokuapp.com/api/v1/users/3`

### URLS DOS ENDPOINTS - CryptoTipo

**GET**
URL do endpoint que retorna uma lista paginada de CryptoTipo:

`https://cryptogo-api.herokuapp.com/api/v1/cryptos?page=0&size=5`

**GET**
URL do endpoint que retorna um CryptoTipo /{1}:

`https://cryptogo-api.herokuapp.com/api/v1/cryptos/1`

**GET**
URL do endpoint que retorna uma lista com as recomendações thresholds pos dia:

`https://cryptogo-api.herokuapp.com/api/v1/recomendacao-aposDia/01/01/2021`

**GET**
URL do endpoint que retorna uma lista com as recomendações thresholds antes do dia:

`https://cryptogo-api.herokuapp.com/api/v1/recomendacao-antesDia/01/01/2021`

**POST**
URL do endpoint que cria uma CryptoTipo:

`https://cryptogo-api.herokuapp.com/api/v1/cryptos`

**PUT**
URL do endpoint que altera uma CryptoTipo /{3}:

`https://cryptogo-api.herokuapp.com/api/v1/cryptos/3`

**DELETE**
URL do endpoint que deleta usuario /{2}:

`https://cryptogo-api.herokuapp.com/api/v1/cryptos/2`

### URLS DOS ENDPOINTS - CryptoThreshold

**GET**
URL do endpoint que retorna uma lista paginada de CryptoThreshold:

`https://cryptogo-api.herokuapp.com/api/v1/cryptosThresholds?page=0&size=5`

**GET**
URL do endpoint que retorna um CryptoThreshold /{4}:

`https://cryptogo-api.herokuapp.com/api/v1/cryptosThresholds/4`

**POST**
URL do endpoint que cria uma CryptoThreshold:

`https://cryptogo-api.herokuapp.com/api/v1/cryptosThresholds`

**PUT**
URL do endpoint que altera uma CryptoThreshold /{14}:

`https://cryptogo-api.herokuapp.com/api/v1/cryptosThresholds/14`

**DELETE**
URL do endpoint que deleta CryptoThreshold /{17}:

`https://cryptogo-api.herokuapp.com/api/v1/cryptosThresholds/17`
