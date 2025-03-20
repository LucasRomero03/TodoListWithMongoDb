package com.lrtech.testeMongodb.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "todos")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Todo {
  
  @Id
  private String id;
  private String nome;
  private String descricao;
  private Boolean realizado;
  private int prioridade;
  // private User user;
  
  public Todo(String nome, String descricao, Boolean realizado, int prioridade,User user) {
    this.nome = nome;
    this.descricao = descricao;
    this.realizado = realizado;
    this.prioridade = prioridade;
    // this.user=user;
  }


}
