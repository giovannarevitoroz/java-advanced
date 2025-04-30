Claro, Giovanna! Abaixo está o conteúdo completo do `README.md`, incluindo sua identificação, explicação teórica do projeto, endpoints, diagrama conceitual (em texto), e **todas as dependências utilizadas e justificativas** sobre por que elas foram necessárias para atender os requisitos técnicos.

---

# 📦 API de Operações de Comércio Exterior

**Autora**: Giovanna Revito Roz  
**RM**: RM558981  
**Projeto**: API para controle de operações de importação e exportação entre empresas de aviação.  
**Tecnologia**: Java 17 + Spring Boot  
**Banco de Dados**: H2 (em memória)

---

## 📘 Descrição

Uma empresa de aviação realiza operações de importação e exportação com diversos países. Para organizar suas transações, clientes, produtos e documentos de envio, foi desenvolvido este sistema para centralizar e padronizar os dados de forma segura, robusta e escalável.

---

## ✅ Funcionalidades

- Cadastro de empresas com endereço embutido
- Registro de operações comerciais (importação/exportação)
- Associação de transportes e documentos a cada operação
- Paginação na listagem de operações
- Filtros por tipo de operação (importação/exportação)
- Exceções personalizadas
- Organização em camadas (Controller, Service, Repository)
- Uso de DTOs e validação de dados

---

## 🔗 Endpoints Disponíveis

| Método | Endpoint                              | Descrição                                  |
|--------|----------------------------------------|--------------------------------------------|
| GET    | `/empresas`                            | Lista todas as empresas                    |
| POST   | `/empresas`                            | Cadastra nova empresa                      |
| POST   | `/operacoes`                           | Cadastra nova operação                     |
| GET    | `/operacoes`                           | Lista operações com paginação             |
| GET    | `/operacoes/busca?tipo=importacao`     | Busca por tipo de operação                 |
| GET    | `/operacoes/{id}`                      | Detalha uma operação específica            |
| POST   | `/operacoes/{id}/transportes`          | Adiciona transporte à operação             |
| POST   | `/operacoes/{id}/documentos`           | Adiciona documento à operação              |

---

## 🧱 Modelo de Domínio

```
+----------------+
|    Empresa     |
+----------------+
| - cnpj         |
| - nome         |
| - pais         |
| - endereco     | (@Embedded)
+----------------+

+-------------------------------------+
|      OperacaoComercial (abstract)   | (@Inheritance)
+-------------------------------------+
| - codigoOperacao                    |
| - empresa (Empresa)                | (@IdClass/@EmbeddedId)
| - dataRegistro                      |
| - valorTotal                        |
+-------------------+----------------+
                    |
        -------------------------
        |                       |
  +------------+        +-----------------+
  | Exportacao |        |  Importacao     |
  +------------+        +-----------------+
  | destinoFinal|        | origemCarga     |
  | incoterm    |        | paisOrigem      |
  +------------+        +-----------------+

+------------------+         +--------------------+
|   Transporte     |         |     Documento      |
+------------------+         +--------------------+
| tipo             |         | tipo               |
| dataEmbarque     |         | nome               |
| origem           |         | dataEmissao        |
| destino          |         +--------------------+
+------------------+
```

---

## ⚙️ Tecnologias e Dependências Utilizadas

### 📦 **Dependências do `pom.xml` e Justificativas**

| Dependência                          | Utilidade                                                                 |
|-------------------------------------|---------------------------------------------------------------------------|
| `spring-boot-starter-web`           | Criação de controllers REST para a API.                                   |
| `spring-boot-starter-data-jpa`      | Integração com banco de dados usando JPA/Hibernate.                       |
| `spring-boot-starter-validation`    | Validação de dados de entrada usando `@Valid`.                            |
| `spring-boot-starter-hateoas`       | HATEOAS para estruturar recursos RESTful (não obrigatório, mas incluído). |
| `spring-boot-devtools`              | Hot reload para facilitar o desenvolvimento.                              |
| `h2`                                | Banco de dados em memória para testes e desenvolvimento rápido.          |
| `lombok`                            | Reduzir boilerplate com anotações como `@Getter`, `@Setter`, etc.         |


> **Extras técnicos utilizados:**
- `@Embedded`: para encapsular os dados de endereço.
- `@IdClass` ou `@EmbeddedId`: para criar chave primária composta.
- `@Inheritance(strategy = InheritanceType.JOINED)`: para modelar herança.
- `@OneToMany`, `@ManyToOne`: para relacionamentos entre entidades.
- `@Query` e `@Query(nativeQuery = true)`: para consultas personalizadas nos repositórios.
- `Pageable`: para paginação nas listagens.
- `DTOs`: para encapsular os dados de entrada e saída.
- `Exceções personalizadas`: com tratamento usando `@ControllerAdvice`.

---

## 🧪 Testes

- Foram realizados testes com o **Postman** para validar os principais endpoints.
- Prints e exportações do Postman estão anexados na entrega.

---

Se quiser, posso gerar esse arquivo `README.md` diretamente para você baixar. Deseja isso agora?