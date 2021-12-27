package com.unifacef.work.groupone.microservicecars.exceptions;

public class BadRequestException extends RuntimeException{
    private static final long serialVersionUID = -762304975304109300L;

    public BadRequestException(final String mesage){
        super(mesage);
    }
}
