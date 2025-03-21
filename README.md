<h1 align="center">
TODO List
</h1>


API para gerenciar tarefas (CRUD) para Ajudar nas Demandas Internas.

## Tecnologias

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data MongoDB](https://spring.io/projects/spring-data-mongodb)
- [SpringDoc OpenAPI 3](https://springdoc.org/v2/#spring-webflux-support)
- [MongoDB](https://www.mongodb.com/pt-br/lp/cloud/atlas/try4?utm_source=google&utm_campaign=search_gs_pl_evergreen_atlas_core_prosp-brand_gic-null_amers-br_ps-all_desktop_pt-br_lead&utm_term=mongodb&utm_medium=cpc_paid_search&utm_ad=p&utm_ad_campaign_id=20378068769&adgroup=154980291521&cq_cmp=20378068769&gad_source=1&gclid=Cj0KCQjw-e6-BhDmARIsAOxxlxU1ShkbCtAN-o10xgJcN7p-N2dFiDb9FlGyjs09Q0Ob_jXp-rjluwQaAgM7EALw_wcB)

## Práticas adotadas

- SOLID, DRY, YAGNI, KISS
- API REST
- Consultas com Spring Data MongoDB
- Injeção de Dependências
- Tratamento de respostas de erro
- Geração automática do Swagger com a OpenAPI 3

## Como Executar

- Clonar repositório git
- Construir o projeto:

```
$ ./mvnw clean package

```

- Executar a aplicação:

```
$ java -jar target/todolist-0.0.1-SNAPSHOT.jar

```

A API poderá ser acessada em [localhost:8080](http://localhost:8080/).
O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [Postman](https://www.postman.com/):

- Criar Tarefa

```
$ http POST :8080/todos nome="Todo 1" descricao="Desc Todo 1" prioridade=1

[
  {
    "descricao": "Desc Todo 1",
    "id": 1,
    "nome": "Todo 1",
    "prioridade": 1,
    "realizado": false
  }
]

```

- Listar Tarefas

```
$ http GET :8080/todos

[
  {
    "descricao": "Desc Todo 1",
    "id": 1,
    "nome": "Todo 1",
    "prioridade": 1,
    "realizado": false
  }
]

```

- Atualizar Tarefa

```
$ http PUT :8080/todos/1 nome="Todo 1 Up" descricao="Desc Todo 1 Up" prioridade=2

[
  {
    "descricao": "Desc Todo 1 Up",
    "id": 1,
    "nome": "Todo 1 Up",
    "prioridade": 2,
    "realizado": false
  }
]

```

- Remover Tarefa

```
http DELETE :8080/todos/1

[ ]

```
