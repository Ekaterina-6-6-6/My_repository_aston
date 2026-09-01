package org.example;

public class ArrayIndexOutOfBoundsException {

    public static void test() {

        int[] array = {1, 2, 3};

        try {
            // В массиве нет элемента с индексом 3
            System.out.println(array[3]);

        } catch (java.lang.ArrayIndexOutOfBoundsException e) {

            System.out.println(
                    "Поймано ArrayIndexOutOfBoundsException: "
                            + e.getMessage()
            );
        }
    }
}