package br.ada.customer.crud.exceptionexample;

public class CarroNaoLigaException extends Exception{

    public CarroNaoLigaException(String message, Exception cause) {
        super(message, cause);
    }
}
