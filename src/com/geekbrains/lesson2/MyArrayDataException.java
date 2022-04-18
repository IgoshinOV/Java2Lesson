package com.geekbrains.lesson2;

public class MyArrayDataException extends NumberFormatException {

    public MyArrayDataException() {
        super("Не удается преобразовать строку в число.");
    }
}
