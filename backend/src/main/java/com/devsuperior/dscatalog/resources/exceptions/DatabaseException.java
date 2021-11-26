package com.devsuperior.dscatalog.resources.exceptions;

public class DatabaseException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    //intercepa o controller e trata a excecao
    public DatabaseException(String msg){
        super(msg);
    }
}
