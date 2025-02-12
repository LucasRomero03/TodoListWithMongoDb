package com.lrtech.testeMongodb.service.exceptions;

public class ResourceNotFound extends RuntimeException {
 public ResourceNotFound(String msg){
  super(msg);
 } 
}
