package com.geekbrains.Lesson1.partisipant;

public class Robot implements Participant {

    private final String name;

    public Robot(String name) {
        this.name = name;
    }

    @Override
    public int run() {
        return 500;
    }

    @Override
    public int jump() {
        return 5;
    }

    @Override
    public String toString() {
        return "Robot " + name;
    }
}
