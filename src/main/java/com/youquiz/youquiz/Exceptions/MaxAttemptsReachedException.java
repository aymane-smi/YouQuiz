package com.youquiz.youquiz.Exceptions;

public class MaxAttemptsReachedException extends RuntimeException{
    public MaxAttemptsReachedException(){}

    public MaxAttemptsReachedException(String message){
        super(message);
    }
}
