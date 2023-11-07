package com.youquiz.youquiz.Exceptions;

import lombok.NoArgsConstructor;

public class NotFoundException extends Exception{
    public NotFoundException(String message){
        super(message);
    }

    public NotFoundException(){
        super("invalid id for the element");
    }
}
