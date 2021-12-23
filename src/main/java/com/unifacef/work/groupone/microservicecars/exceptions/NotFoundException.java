package com.unifacef.work.groupone.microservicecars.exceptions;

public class NotFoundException extends RuntimeException{
    private static final long serialVersionUID = -762304975304109271L;

    public NotFoundException(final String message){
        super(message);
    }
}
