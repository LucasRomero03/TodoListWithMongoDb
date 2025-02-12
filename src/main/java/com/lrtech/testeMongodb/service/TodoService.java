package com.lrtech.testeMongodb.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lrtech.testeMongodb.dto.TodoDto;
import com.lrtech.testeMongodb.entities.Todo;
import com.lrtech.testeMongodb.entities.User;
import com.lrtech.testeMongodb.repository.TodoRepository;
import com.lrtech.testeMongodb.service.exceptions.ResourceNotFound;

@Service
public class TodoService {

  private TodoRepository todorep;
  private UserService userService;

  public TodoService(TodoRepository todorep,UserService userService) {
    this.todorep = todorep;
    this.userService = userService;
  }

  public TodoDto getById(String id) {
    Todo todo = todorep.findById(id).orElseThrow(() -> new ResourceNotFound("recurso não encontrado"));
    return new TodoDto(todo);
  }

  public List<TodoDto> getByNome(String nome) {
    List<Todo> listTodos = todorep.findByNomeContainingIgnoreCaseOrderByNomeAsc(nome);
    if (listTodos.isEmpty()) {
      throw new ResourceNotFound("recurso nao encontrado");
    }
    return listTodos.stream().map(x -> new TodoDto(x)).toList();
  }

  public Page<TodoDto> getAllTodos(Pageable pageable) {
    Page<Todo> todos = todorep.findAll(pageable);
    return todos.map(x -> new TodoDto(x));
  }

  public TodoDto createTodo(TodoDto dto) {
    Todo todo = new Todo();
    todo.setNome(dto.getNome());
    todo.setDescricao(dto.getDescricao());
    todo.setPrioridade(dto.getPrioridade());
    todo.setRealizado(dto.getRealizado());

    todo.setUser(new User(userService.getById(dto.getUserDto().getId())));
    todorep.save(todo);
    return new TodoDto(todo);
  }

  public void deleteTodo(String id) {
    if (!todorep.existsById(id)) {
      throw new ResourceNotFound("recurso não encontrado");
    }
    try {
      todorep.deleteById(id);
    } catch (Exception e) {
      throw new ResourceNotFound("banco de dados ");
    }

  }

  public TodoDto updateTodo(String id, TodoDto dto) {
    try {
      Todo todo = todorep.findById(id).orElseThrow(() -> new ResourceNotFound("recurso nao encontrado"));
      todo.setNome(dto.getNome());
      todo.setDescricao(dto.getDescricao());
      todo.setPrioridade(dto.getPrioridade());
      todo.setRealizado(dto.getRealizado());
      todorep.save(todo);
      return new TodoDto(todo);
    } catch (Exception e) {
      throw new ResourceNotFound("Recurso não encontrado ");
    }

  }
}