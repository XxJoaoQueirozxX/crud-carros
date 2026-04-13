# CRUD de Veículos

API REST desenvolvida para o gerenciamento de um cadastro de veículos, permitindo operações completas de CRUD (Create, Read, Update, Delete).

## 🚀 Tecnologias Utilizadas

- **Java 11**
- **Spring Boot 2.4.4**
- **Spring Data JPA**
- **H2 Database** (Banco de dados em memória)
- **Swagger/Springfox 3.0.0** (Documentação da API)
- **Maven** (Gerenciador de dependências)

## 📋 Funcionalidades

- Cadastro de novos veículos.
- Listagem de todos os veículos cadastrados.
- Busca de veículo por ID.
- Atualização de dados de um veículo existente.
- Remoção de um veículo do sistema.

## 🛠️ Como Executar o Projeto

1. Certifique-se de ter o **Java 11** e o **Maven** instalados em sua máquina.
2. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/crud-carros.git
   ```
3. Acesse a pasta do projeto:
   ```bash
   cd crud-carros
   ```
4. Execute o projeto utilizando o Maven:
   ```bash
   ./mvnw spring-boot:run
   ```
5. A aplicação estará disponível em `http://localhost:8080`.

## 📖 Documentação da API (Swagger)

A documentação interativa da API, onde você pode testar os endpoints e visualizar os modelos de dados, está disponível em:
- [http://localhost:8080/swagger-ui/](http://localhost:8080/swagger-ui/)

## 🗄️ Banco de Dados (H2 Console)

Para visualizar os dados salvos no banco de dados em memória (H2), acesse:
- [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
- **JDBC URL:** `jdbc:h2:mem:testdb` (ou conforme configurado no application.properties)

## 🛣️ Endpoints Principais

### Veículos (`/veiculos`)

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| **GET** | `/veiculos` | Lista todos os veículos (permite filtros via query params) |
| **GET** | `/veiculos/{id}` | Busca um veículo pelo seu ID |
| **POST** | `/veiculos` | Cadastra um novo veículo |
| **PUT** | `/veiculos/{id}` | Atualiza um veículo existente |
| **DELETE** | `/veiculos/{id}` | Remove um veículo do sistema |

### Exemplo de Objeto Veículo

```json
{
  "modelo": "Civic",
  "marca": "Honda",
  "cor": "Preto",
  "ano": 2022,
  "tipo": "SEDAN",
  "preco": 120000.00
}
```

---
Desenvolvido por [João Queiroz](https://github.com/joaoqueiroz)
