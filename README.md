
# Projeto CRUD de Biblioteca

Este é um projeto básico de API CRUD desenvolvido como parte dos meus estudos em Java e Spring Boot. O sistema gerencia três entidades principais: **Livro**, **Categoria** e **Autor**.

## Objetivo

O objetivo principal deste projeto é praticar e fixar conceitos de:
- Desenvolvimento de API REST com Spring Boot
- Arquitetura em camadas (Controller, Service, Repository)
- Mapeamento de entidades com JPA (Java Persistence API)
- Relacionamentos entre entidades
- Operações CRUD básicas (Create, Read, Update, Delete)

## Tecnologias utilizadas

- Java
- Spring Boot
- Spring Data JPA
- Banco de dados H2 (definido por padrão no aplication.properties, em memória)
- banco de dados com SGBD mySQL (podendo ser definido no application.properties)

## Funcionalidades

- Cadastro de livros, categorias e autores
- Consulta de livros, categorias e autores
- Atualização de informações
- Exclusão de registros

## Estrutura do projeto

- **Entity**: classes que representam as tabelas do banco de dados
- **Repository**: interfaces que fazem a comunicação com o banco de dados
- **Service**: regras de negócio e tratamento dos dados
- **Controller**: ponto de entrada das requisições HTTP

## Próximos passos

Pretendo evoluir o projeto adicionando:
- testes unitários
- conteinerização
- Implementação de autenticação e autorização
- Documentação da API com Swagger

## Como executar o projeto

1. Clone este repositório:
   ```
   git clone https://github.com/Levelvini/Biblioteca.git
   ```
2. Importe o projeto em sua IDE favorita (IntelliJ, Eclipse, etc.)
3. Execute a aplicação
4. Acesse a API usando ferramentas como Postman ou Insomnia
