package com.geekbrains.lesson2;

public class HomeWorkApp2 {

    public static void main(String[] args) {
        String[][] twoDimensionalArray = {
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1c"}
        };

        try {
            arrayConversion(twoDimensionalArray);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void arrayConversion(String[][] arrays) {
        if (arrays.length == 4) {
            for (String[] array : arrays) {
                if (array.length != 4) {
                    throw new MyArraySizeException();
                }
            }
        } else {
            throw new MyArraySizeException();
        }

        int counter = 0;
        int x;

        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                if (isInteger(arrays[i][j])) {
                    x = Integer.parseInt(arrays[i][j]);
                    counter += x;
                } else {
                    System.out.println("Неверные данные лежат в ячейке с  id " + i + " - " + j);
                    throw new MyArrayDataException();
                }
            }
        }
        System.out.println(counter);
    }

    public static boolean isInteger(String string) {
        if (string == null || string.equals("")) {
            System.out.println("Не корректно заполнен массив");
            return false;
        }
        try {
            int i = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException ignored) {
            System.out.println("Неправильный формат строки");
        }
        return false;
    }
}


