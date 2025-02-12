package com.lrtech.testeMongodb.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.lrtech.testeMongodb.dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class User {
  @Id
  private String id;
  private String nome;
  private String email;
  private String senha;
  
  public User(UserDto dto){
    id = dto.getId();
    nome = dto.getNome();
    email=dto.getEmail();
    senha=dto.getSenha();
  }

}

