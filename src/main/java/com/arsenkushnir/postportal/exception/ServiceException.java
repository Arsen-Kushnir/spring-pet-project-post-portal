package com.arsenkushnir.postportal.exception;

public class ServiceException extends RuntimeException{

    public ServiceException(String message){
        super(message);
    }
}
