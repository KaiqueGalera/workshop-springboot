# 🛒 Webservice API - E-commerce Backend (Spring Boot)

API REST desenvolvida em **Java com Spring Boot**, simulando um sistema de e-commerce com entidades como **User, Product, Category, Order, OrderItem e Payment**.

O projeto tem como objetivo evoluir progressivamente para um backend robusto, aplicando boas práticas de desenvolvimento, testes, arquitetura e deploy em cloud.

---

## 🚀 Tecnologias utilizadas

* Java 21+ / 25
* Spring Boot 4
* Spring Web MVC
* Spring Data JPA (Hibernate)
* H2 Database (ambiente de desenvolvimento)
* PostgreSQL *(em evolução)*
* Maven
* Bean Validation (Jakarta Validation)

---

## 📌 Objetivos do projeto

Este projeto foi desenvolvido com foco em:

* Construção de APIs REST seguindo boas práticas
* Separação de camadas (Controller → Service → Repository)
* Uso de DTOs para desacoplamento
* Tratamento global de exceções
* Evolução contínua com:

  * Testes automatizados
  * Integração com banco real
  * Deploy em nuvem (AWS)
  * Microsserviços

---

## 🧱 Estrutura do projeto

```
com.galera.webservice
├── controller
├── service
├── repository
├── domain
├── dto
├── exception
└── config
```

Arquitetura baseada em camadas:

```
Controller → Service → Repository → Database
```

---

## 📊 Modelo de domínio

O sistema simula um e-commerce básico com as seguintes entidades:

* **User** → Cliente do sistema
* **Product** → Produto disponível
* **Category** → Categoria de produtos
* **Order** → Pedido realizado
* **OrderItem** → Itens do pedido
* **Payment** → Pagamento do pedido

---

## ⚙️ Como executar o projeto

### Pré-requisitos

* Java 21+
* Maven

### Rodar localmente

```bash
git clone https://github.com/seu-usuario/seu-repo.git
cd webservice
./mvnw spring-boot:run
```

A API estará disponível em:

```
http://localhost:8080
```

---

## 🧪 Banco de dados (H2)

O projeto utiliza banco em memória para desenvolvimento.

### Console H2:

```
http://localhost:8080/h2-console
```

Configuração padrão:

* JDBC URL: `jdbc:h2:mem:devdb`
* User: `sa`
* Password: (vazio)

---

## 🔁 Endpoints principais

### 👤 Users

* `GET /users` → listar usuários
* `GET /users/{id}` → buscar por id
* `POST /users` → criar usuário
* `PUT /users/{id}` → atualizar usuário
* `DELETE /users/{id}` → deletar usuário

---

## ✅ Validação e tratamento de erros

O projeto utiliza:

* `@Valid` para validação de entrada
* `@RestControllerAdvice` para tratamento global de exceções

Exemplo de erro:

```json
{
  "status": 400,
  "message": "email: invalid email",
  "path": "/users"
}
```

---

## 📈 Roadmap de evolução

Este projeto está sendo evoluído em etapas:

### ✔️ Sprint 1 (atual)

* Estrutura em camadas
* DTOs
* Validação
* Exception Handler global

### 🔜 Próximos passos

* **Testes unitários (JUnit + Mockito)**
* **Testes de integração (MockMvc + Testcontainers)**
* **Migração para PostgreSQL**
* **Flyway (versionamento de banco)**
* **Swagger (OpenAPI)**
* **Docker + Docker Compose**
* **Deploy na AWS (EC2)**
* **Cache com Redis**
* **Arquitetura de microsserviços**

---

## ☁️ Deploy (planejado)

O projeto será disponibilizado em ambiente cloud utilizando:

* AWS EC2 (Free Tier)
* Docker
* Possível evolução para ECS/Fargate

---

## 🔄 Evolução futura (NoSQL)

Está prevista a integração com banco não relacional:

* MongoDB ou Redis
* Uso para cache e/ou logs

---

## 👨‍💻 Autor

Kaique Dias Galera

* Bacharel em Química
* Doutor em Bioquímica
* Estudante de Análise e Desenvolvimento de Sistemas
* Foco em desenvolvimento backend (Java + Spring)
