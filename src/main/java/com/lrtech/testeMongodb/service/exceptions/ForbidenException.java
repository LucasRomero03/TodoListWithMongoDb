package com.lrtech.testeMongodb.service.exceptions;

public class ForbidenException extends RuntimeException  {
  public ForbidenException(String msg){

   super(msg);
  }
}
