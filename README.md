# TODO List API

API para gerenciar tarefas (CRUD) utilizando MongoDB como banco de dados.

## Tecnologias Utilizadas

- [Spring Boot 3.4.3](https://spring.io/projects/spring-boot) - Framework principal
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html) - Estrutura para desenvolvimento web
- [Spring Data MongoDB](https://spring.io/projects/spring-data-mongodb) - Integração com banco NoSQL MongoDB
- [SpringDoc OpenAPI 3](https://springdoc.org/v2/#spring-webflux-support) - Documentação automatizada da API
- [Lombok](https://projectlombok.org/) - Redução de boilerplate no código Java
- [Maven](https://maven.apache.org/) - Gerenciador de dependências e build
- [MongoDB](https://www.mongodb.com/pt-br) - Banco de dados NoSQL

## Princípios e Boas Práticas Adotadas

- Arquitetura baseada em **API REST**
- Uso de padrões **SOLID, DRY, YAGNI, KISS**
- **Injeção de Dependências** para desacoplamento
- **Tratamento de Erros** estruturado
- **Documentação Automática** via OpenAPI 3

## Como Executar o Projeto

1. **Clonar o repositório:**
   ```bash
   git clone <URL_DO_REPOSITORIO>
   cd testeMongodb
   ```
2. **Configurar o MongoDB:**
   - Certifique-se de que o MongoDB está rodando localmente ou configure a conexão com um servidor remoto.
   
3. **Compilar e construir o projeto:**
   ```bash
   ./mvnw clean package
   ```
4. **Executar a aplicação:**
   ```bash
   java -jar target/testeMongodb-0.0.1-SNAPSHOT.jar
   ```

A API estará acessível em: [http://localhost:8080](http://localhost:8080)

A documentação via Swagger/OpenAPI 3 pode ser acessada em:
[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## Endpoints da API

### Criar Tarefa
```http
POST /todos
```
#### Exemplo de Corpo da Requisição:
```json
{
  "nome": "Minha Tarefa",
  "descricao": "Detalhes da tarefa",
  "prioridade": 1
}
```

### Listar Todas as Tarefas
```http
GET /todos
```
#### Exemplo de Resposta:
```json
[
  {
    "id": "1",
    "nome": "Minha Tarefa",
    "descricao": "Detalhes da tarefa",
    "prioridade": 1,
    "realizado": false
  }
]
```

### Atualizar Tarefa
```http
PUT /todos/{id}
```
#### Exemplo de Corpo da Requisição:
```json
{
  "nome": "Tarefa Atualizada",
  "descricao": "Nova descrição",
  "prioridade": 2
}
```

### Remover Tarefa
```http
DELETE /todos/{id}
```
#### Resposta:
```json
{}
```



