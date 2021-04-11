package com.arsenkushnir.postportal.exception;

public class UserDuplicationException extends RuntimeException{

    public UserDuplicationException(String message){
        super(message);
    }
}
