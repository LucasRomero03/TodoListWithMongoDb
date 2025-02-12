package com.lrtech.testeMongodb.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lrtech.testeMongodb.dto.UserDto;
import com.lrtech.testeMongodb.entities.User;
import com.lrtech.testeMongodb.repository.UserRepository;
import com.lrtech.testeMongodb.service.exceptions.ResourceNotFound;

@Service
public class UserService {
  private UserRepository userRep;

  public UserService(UserRepository userRep){
    this.userRep=userRep;
  }

  public UserDto getById(String id){
    User user = userRep.findById(id).orElseThrow( () -> new ResourceNotFound("recurso nao encontrado"));

    return new UserDto(user);
  }
  public Page<UserDto> getUsers(Pageable pageable){
    Page<User> users = userRep.findAll(pageable);
    
    return users.map(x -> new UserDto(x));
  }

  public UserDto createUser(UserDto userDto){
    User user = new User();
    user.setNome(userDto.getNome());
    user.setEmail(userDto.getEmail());
    user.setSenha(userDto.getSenha());
    userRep.save(user);
    return new UserDto(user);
  }
  public void deleteUser(String id){
   if(!userRep.existsById(id)){
    throw new ResourceNotFound("recurso nao encontrado");
   }
    try {
     
      userRep.deleteById(id);
    } catch (Exception e) {
      throw new ResourceNotFound("recurso nao encontrado 1232132");
    }
  }
  public UserDto atualizarUser(String id, UserDto userDto){
    if (!userRep.existsById(id)) {
      throw new ResourceNotFound("recurso nao encontrado");
    }
    try {
      User user = userRep.findById(id).orElseThrow(()-> new ResourceNotFound("recurso nao encontrado"));
      user.setNome(userDto.getNome());
      user.setEmail(userDto.getEmail());
      user.setSenha(userDto.getSenha());
      userRep.save(user);
      return userDto;
    } catch (Exception e) {
      throw new ResourceNotFound("email ja existe");
    }
    
    
  }
}

