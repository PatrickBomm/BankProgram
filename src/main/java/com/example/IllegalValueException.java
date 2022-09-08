package com.example;

public class IllegalValueException extends RuntimeException{
    public IllegalValueException() {
        super("Valor invalido!");
    }
}
