package org.example;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println("Первое задание  :");
        printThreeWords();

        System.out.println("\nВторое задание  :");
        checkSumSign();

        System.out.println("\nТретье задание  :");
        printColor();

        System.out.println("\nЧетвёртое задание  :");
        compareNumbers();

        System.out.println("\nПятое задание  :");
        System.out.println(sumInRange(5, 10));

        System.out.println("\nШестое задание  :");
        checkNumber(10);

        System.out.println("\nСедьмое задание  :");
        System.out.println(isNegative(-5));

        System.out.println("\nВосьмое задание  :");
        printString("Hello", 3);

        System.out.println("\nДевятое задание  :");
        System.out.println(isLeapYear(2024));

        System.out.println("\nДесятое задание  :");
        changeArray();

        System.out.println("\nОдиннадцатое задание  :");
        fillArray();

        System.out.println("\nДвенадцатое задание  :");
        multiplyNumbers();

        System.out.println("\nТринадцатое задание  :");
        fillDiagonal();

        System.out.println("\nЧетырнадцатое задание  :");
        int[] result = createArray(5, 7);
        System.out.println(Arrays.toString(result));
    }

    // 1. Вывести три слова
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    // 2. Сравнение суммы с 0
    public static void checkSumSign() {
        int a = 10;
        int b = -5;

        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    // 3. Сравнить число с 0 и вывести цвет
    public static void printColor() {
        int value = 50;

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    // 4. Сравнить числа
    public static void compareNumbers() {
        int a = 10;
        int b = 20;

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    // 5. Проверить сумму
    public static boolean sumInRange(int a, int b) {
        return a + b >= 10 && a + b <= 20;
    }

    // 6. Проверить положительное или отрицательное число
    public static void checkNumber(int number) {
        if (number >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    // 7. Проверить отрицательное число
    public static boolean isNegative(int number) {
        return number < 0;
    }

    // 8. Вывести строку указанное количество раз
    public static void printString(String text, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(text);
        }
    }

    // 9. Проверить год на високосность
    public static boolean isLeapYear(int year) {
        return year % 400 == 0 || year % 4 == 0 && year % 100 != 0;
    }

    // 10. Задать числовой масис в с 1 и 0
    public static void changeArray() {
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }

        System.out.println(Arrays.toString(array));
    }

    // 11. Массив с числами от 1 до 100
    public static void fillArray() {
        int[] array = new int[100];

        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        System.out.println(Arrays.toString(array));
    }

    // 12. Числа из массива меньше 6 умножить на 2
    public static void multiplyNumbers() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] = array[i] * 2;
            }
        }

        System.out.println(Arrays.toString(array));
    }

    // 13. Заполнить массив, диагональ единицами
    public static void fillDiagonal() {
        int[][] array = new int[5][5];

        for (int i = 0; i < array.length; i++) {
            array[i][i] = 1;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }

    // 14. Создать массив заданной длины
    public static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];

        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }

        return array;
    }
}