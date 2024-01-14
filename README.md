Projeto Web Spring Boot com MySQL

Bem-vindo ao Projeto Spring Boot com MySQL! Este projeto é uma aplicação Java construída com o framework Spring Boot e utiliza um banco de dados MySQL para armazenamento de dados.

O objetivo geral do Projeto até o momento foi: realizar a integração com o front/back permitindo a realização do cadastro ser salva no banco de dados e a operação retornar o http 200.

Configuração do Ambiente
Pré-requisitos

JDK 11 ou superior

Maven

MySQL

IDE: eclipse, intellij ou Vscode

Use o comando: git clone https://github.com/victor-delfino/Web-API-Java

Para criar uma cópia do meu código e você poder utilizar.


Configuração do Banco de Dados
Crie um banco de dados chamado usuarios.
Use esse código dentro do mySQL workbench:

create database usuarios;

use usuarios;

create table usuario(

     id			integer auto_increment primary key,
   
    nome			varchar(200) not null,
    
    email			varchar(50) not null unique,
    
    senha 			text not null,
    
    telefone		varchar(15) not null

);

Configure as credenciais do banco de dados no arquivo src/main/resources/application.properties.

spring.datasource.url=jdbc:mysql://localhost:3306/usuarios

spring.datasource.username=seu_usuario

spring.datasource.password=sua_senha

Estrutura do Projeto
A estrutura do projeto segue as convenções padrão do Spring Boot:

controller: Contém os controladores REST para manipular as solicitações HTTP.
dao: Contém a lógica de acesso ao banco de dados usando JPA e o CrudRepository.
entidade: Define a entidade Usuario.

Entidade 'Usuario'
A entidade Usuario representa os usuários da aplicação e possui os seguintes campos:

id (Integer): Identificador único do usuário.

nome (String): Nome do usuário.

email (String): Endereço de e-mail do usuário.

senha (String): Senha do usuário.

telefone (String): Número de telefone do usuário.

RestController
O controlador REST (UsuarioController) oferece endpoints para realizar operações CRUD no recurso Usuario. Ele utiliza a anotação @RestController.

Endpoints:
Get - retorna um valor 
Post - Salva um valor
Put - Altera um valor
Delete - Deleta um valor pelo Id

Você pode utilizar o Postman para testar e realizar requerimentos
https://www.postman.com/downloads/
