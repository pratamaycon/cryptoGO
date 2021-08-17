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

[Link Swagger](https://cryptogo-api.herokuapp.com/swagger-ui.html#/)

Obs: Ficará disponivel uma collection do postman com os testes que foram utilizados durante o desenvolvimento dessa API REST.
A collection está numa pasta chamada postman bem na raiz do projeto.

### URLS DOS ENDPOINTS

**GET**
URL do endpoint que retorna uma lista de usuários:

`https://cryptogo-api.herokuapp.com/api/v1/users`

**GET**
URL do endpoint que retorna um usuario /{logic}:

`https://cryptogo-api.herokuapp.com/api/v1/users/admin`

**POST**
URL do endpoint que cria um usuario:

`https://cryptogo-api.herokuapp.com/api/v1/users`

**PUT**
URL do endpoint que atualiza um usuario:

`https://cryptogo-api.herokuapp.com/api/v1/users/admin`

**PUT**
URL do endpoint que altera senha:

`https://cryptogo-api.herokuapp.com/api/v1/users/3/senha`

**DELET**
URL do endpoint que deleta usuario:

`https://cryptogo-api.herokuapp.com/api/v1/users/3/senha`

