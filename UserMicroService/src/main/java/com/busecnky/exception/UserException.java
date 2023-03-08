package com.busecnky.exception;

import lombok.Getter;

@Getter
public class UserException extends RuntimeException{
    private final EErrorType errorType;

    /**
     * Runtime dan miras aldığımız için hata mesajının kendisine iletilmesi gereklidir.
     * super(errorType.getMessage()); bunu yazmalıyız.
     * @param errorType
     */
    public UserException(EErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public UserException(EErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }
}
