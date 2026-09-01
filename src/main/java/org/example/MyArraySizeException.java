package org.example;

public class MyArraySizeException extends Exception {

    public MyArraySizeException(String message) {
        super(message);
    }

    public static void checkSize(String[][] array)
            throws MyArraySizeException {

        if (array.length != 4) {
            throw new MyArraySizeException(
                    "Массив должен быть размером 4x4"
            );
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException(
                        "Массив должен быть размером 4x4"
                );
            }
        }
    }
}