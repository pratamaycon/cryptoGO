<img width="150" height="150" align="right" src="https://upload.wikimedia.org/wikipedia/pt/4/47/UFF_bras%C3%A3o.png">



# Disciplina Desenvolvimento de Aplicações 2021/1

## Tarefa 01: Definição e Implementação de Classes de Entidade

## TÉCNOLOGIAS UTILIZADAS

- JAVA 8
- JPA
- SPRING BOOT 2.5.3
- MAVEN 3.6.1
- IDE ECLIPSE
- POSTGRESQL

### Descrição da Tarefa

<p align="justify">

- Modelo de Classes contendo as classes de entidade (com pelo menos 2*N classes de entidade, onde N é o número de integrantes do grupo).
- A implementação das classes de entidades com JPA (código JAVA).
  
</p>

### PRÉ REQUISITOS PARA RODAR ESSE PROJETO

- É necessário criar um database `cryptoGO` no seu Postgresql.

# EM CONSTRUÇÃO...


========================
REST API Documentation
========================

The Stashboard REST API is split in two portions. The public facing REST API only responds to GET and lives at the ``/api/v1/`` endpoint. This API requires no authentication.

The admin-only REST API lives at the ``/admin/api/v1/`` endpoint and responsds to GET, POST, PUT, and DELETE. You'll need to authenticate via OAuth. You can obtain your OAuth keys on the OAuth Credentials page at ``https://{application-id}.appspot.com/admin/credentials``

Services 
----------

The Services resource represents all web services currently tracked via Stashboard.

==============   ===============
Property         Description
==============   ===============
id	         The unique identifier by which to identify the service
name             The name of the service, defined by the user
description      The description of the web service
current-event    The current event for the service
url	         The URL of the specific service resource
==============   ===============
