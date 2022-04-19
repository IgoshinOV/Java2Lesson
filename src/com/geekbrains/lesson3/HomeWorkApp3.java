package com.geekbrains.lesson3;

import java.util.*;

public class HomeWorkApp3 {

    private static final String[] ARRAY = {
            "Красный",
            "Желтый",
            "Зеленый",
            "Черный",
            "Белый",
            "Синий",
            "Ораньжевый",
            "Красный",
            "Белый",
            "Белый",
            "Черный",
            "Черный"
    };

    public static void main(String[] args) {
        List<String> arrayList = Arrays.asList(ARRAY);
        Set<String> unique = new LinkedHashSet<>(arrayList);

        System.out.println(unique);
        arrayListCounter(arrayList, unique);

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "8800131141");
        phoneBook.add("Петров", "8800131581");
        phoneBook.add("Сидоров", "8800131501");
        phoneBook.add("Кузнецов", "8800131789");
        phoneBook.add("Петров", "8800581521");
        phoneBook.add("Иванов", "8800174521");
        phoneBook.add("Петров", "8800135891");
        phoneBook.add("Иванов", "8800131561");

        phoneBook.get("Иванов");
    }

    private static void arrayListCounter(List<String> arrayList, Set<String> unique) {
        for (String o : unique) {
            int counter = 0;
            for (String s : arrayList) {
                if (o.equals(s)) {
                    counter++;
                }
            }
            System.out.println(o + " - количество повторений = " + counter);
        }
    }
}
