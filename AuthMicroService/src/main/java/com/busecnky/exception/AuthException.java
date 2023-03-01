package com.busecnky.exception;

import lombok.Getter;

@Getter
public class AuthException extends RuntimeException{
    private final EErrorType errorType;

    /**
     * Runtime dan miras aldığımız için hata mesajının kendisine iletilmesi gereklidir.
     * super(errorType.getMessage()); bunu yazmalıyız.
     * @param errorType
     */
    public AuthException(EErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public AuthException(EErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }
}
