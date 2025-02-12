package com.lrtech.testeMongodb.dto;

import com.lrtech.testeMongodb.entities.Todo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class TodoDto {

  private String id;
  private String nome;
  private String descricao;
  private Boolean realizado;
  private int prioridade;
  private UserDto userDto;

  public TodoDto(Todo todo) {
    this.id = todo.getId();
    this.nome = todo.getNome();
    this.descricao = todo.getDescricao();
    this.realizado = todo.getRealizado();
    this.prioridade = todo.getPrioridade();
    
    // Adicionando corretamente o UserDto
    if (todo.getUser() != null) {
        this.userDto = new UserDto(todo.getUser());
    }
  }

  public TodoDto(String nome, String descricao, Boolean realizado, int prioridade, UserDto userDto) {
    this.nome = nome;
    this.descricao = descricao;
    this.realizado = realizado;
    this.prioridade = prioridade;
    this.userDto = userDto;
  }
}
