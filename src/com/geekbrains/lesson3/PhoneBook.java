package com.geekbrains.lesson3;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class PhoneBook {
    Map<String, Set<String>> listOfNumbers = new TreeMap<>();

    public void add(String surname, String phoneNumber) {
        Set<String> phones = listOfNumbers.getOrDefault(surname, new HashSet<>());
        phones.add(phoneNumber);
        listOfNumbers.put(surname, phones);
    }

    public void get(String surname) {
        Set<String> number = listOfNumbers.get(surname);
        System.out.println(surname + "  Тел: " + number);
    }
}
