package com.lrtech.testeMongodb.controller;

import java.net.URI;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lrtech.testeMongodb.dto.TodoDto;
import com.lrtech.testeMongodb.service.TodoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(value = "/todos")
public class TodoController {
  // injeção de dependecia com construtor
  private TodoService todoService;

  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }


  //// USANDO OS REPONSE ENTITY
  // getById
  @GetMapping(value = "/{id}")
  public ResponseEntity<TodoDto> getById(@PathVariable String id) {
    TodoDto dto = todoService.getById(id);
    return ResponseEntity.ok(dto);
  }

  @GetMapping("/usuarios/{id}")
  public ResponseEntity<List<TodoDto>> getTodoByUser_id(@PathVariable String id) {
    return ResponseEntity.ok(todoService.getTodoByUser(id));
  }

  @GetMapping("/usuarios")
  public ResponseEntity<List<TodoDto>> getTodoByNome(@RequestParam("nome") String nome) {
    List<TodoDto> todos = todoService.getTodoByNome(nome);
    return ResponseEntity.ok(todos);
  }

  // GETBYNAME
  @Operation(summary = "Busca produtos por ID", method = "GET")
    @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
      @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
      @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
      @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
  })
  @GetMapping(value = "/nome")
  public ResponseEntity<List<TodoDto>> getByNome(@RequestParam("nome") String nome) {
    List<TodoDto> listTododto = todoService.getByNome(nome);
    return ResponseEntity.ok(listTododto);
  }

  // getAll
  @GetMapping
  public ResponseEntity<Page<TodoDto>> getAllTodos(Pageable pageable) {
    Page<TodoDto> todos = todoService.getAllTodos(pageable);
    return ResponseEntity.ok(todos);
  }

  // POST
  @PostMapping
  public ResponseEntity<TodoDto> createTodo(@RequestBody TodoDto dto) {
    TodoDto copy = todoService.createTodo(dto);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(copy.getId())
        .toUri();
    return ResponseEntity.created(uri).body(copy);
  }

  // DELETE
  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> deleteTodo(@PathVariable String id) {
    todoService.deleteTodo(id);
    return ResponseEntity.noContent().build();
  }

  // PUT
  @PutMapping(value = "/{id}")
  public ResponseEntity<TodoDto> updateTodo(@PathVariable String id, @RequestBody TodoDto dto) {
    TodoDto copy = todoService.updateTodo(id, dto);
    return ResponseEntity.ok(copy);
  }
}
