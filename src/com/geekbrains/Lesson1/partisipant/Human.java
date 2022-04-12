package com.geekbrains.Lesson1.partisipant;

public class Human implements Participant {
    private final String name;

    public Human(String name) {
        this.name = name;
    }

    @Override
    public int run() {
        return 400;
    }

    @Override
    public int jump() {
        return 1;
    }

    @Override
    public String toString() {
        return "Human " + name;
    }
}
