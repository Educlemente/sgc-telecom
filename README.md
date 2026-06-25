# SGC Telecom - Backend API & Console System

Este é o ecossistema de backend do **SGC Telecom**, um sistema robusto e escalável desenvolvido para o gerenciamento de planos, estoque e controle de serviços para provedores de telecomunicações. 

O projeto foi construído seguindo os padrões de uma **API RESTful**, utilizando uma arquitetura em camadas com segurança integrada, contando também com uma interface interativa via console para demonstrações e testes locais imediatos.

---

## 🚀 Tecnologias Utilizadas

* **Linguagem Principal:** Java 17+
* **Framework Core:** Spring Boot 3.x
* **Persistência de Dados:** Spring Data JPA / Hibernate
* **Banco de Dados:** MySQL 8.0
* **Segurança e Autenticação:** Spring Security & JWT (Json Web Token)
* **Gerenciador de Dependências:** Maven

---

## 🏛️ Arquitetura do Sistema

O projeto adota o padrão de **Arquitetura em Camadas (N-Tier Architecture)**, aplicando os princípios do **SOLID** (notadamente o Princípio de Responsabilidade Única) para garantir baixo acoplamento e alta coesão:

* **`config`**: Configurações globais do sistema, políticas de segurança do Spring Security e filtros de interceptação de requisições.
* **`controller`**: Camada de exposição dos Endpoints REST, mapeando as rotas de comunicação HTTP com clientes externos.
* **`domain/model`**: Camada de Entidades de Negócio mapeadas via ORM diretamente para o banco de dados.
* **`dto`**: Objetos de Transferência de Dados, garantindo o encapsulamento seguro das informações de entrada e saída.
* **`infra`**: Manipulação de infraestrutura global, incluindo o tratamento e padronização de exceções do sistema.
* **`repository`**: Camada de persistência, abstraindo comandos SQL e interagindo nativamente com o banco MySQL.
* **`service`**: Camada contendo as regras de negócio complexas, criptografia e geração/validação de tokens de acesso.

---

## 🛠️ Como Executar o Projeto

### Pré-requisitos
* Java JDK 17 ou superior instalado.
* Banco de dados MySQL ativo localmente.

### 1. Configuração do Banco de Dados
Abra o arquivo `src/main/resources/application.yml` (ou `.properties`) e configure as credenciais do seu banco local:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/sgc_telecom
    username: seu_usuario_root
    password: sua_senha_do_mysql
  jpa:
    hibernate:
      ddl-auto: update
