package com.geekbrains.Lesson1.partisipant;

public class Cat implements Participant {

    private final String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public int run() {
        return 50;
    }

    @Override
    public int jump() {
        return 3;
    }

    @Override
    public String toString() {
        return "Cat " + name;
    }
}
