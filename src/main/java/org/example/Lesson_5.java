//Изначально в условии дан массив 4х4. Использовала многократный перехват исключений.
//То есть если массив соответствует 4х4, то дальше будем проверять на наличие букв и символов.
package org.example;

public class Lesson_5 {

    public static void main(String[] args) {

        String[][] array = {
                {"1", "2", "4", "6"},
                {"4", "5", "6", "6"},
                {"7", "8", "9", "6"},
                {"7", "8", "3", "6"}
        };

        try {

            MyArraySizeException.checkSize(array);

            int sum = MyArrayDataException.sumArray(array);

            System.out.println(
                    "Сумма элементов массива: " + sum
            );

        } catch (MyArraySizeException | MyArrayDataException e) {

            System.out.println(
                    "Ошибка: " + e.getMessage()
            );
        }

        ArrayIndexOutOfBoundsException.test();
    }
}
