package org.example;

import java.util.HashMap;
import java.util.Map;

public class Lesson_6 {

    public static void main(String[] args) {

        System.out.println("Первое задание:");

        StudentCollection students = new StudentCollection();

        Map<String, Integer> grades1 = new HashMap<>();
        grades1.put("Математика", 5);
        grades1.put("Программирование", 4);
        grades1.put("Физика", 5);
        grades1.put("Английский", 4);

        Map<String, Integer> grades2 = new HashMap<>();
        grades2.put("Математика", 3);
        grades2.put("Программирование", 3);
        grades2.put("Физика", 4);
        grades2.put("Английский", 3);

        Map<String, Integer> grades3 = new HashMap<>();
        grades3.put("Математика", 2);
        grades3.put("Программирование", 3);
        grades3.put("Физика", 2);
        grades3.put("Английский", 2);

        Map<String, Integer> grades4 = new HashMap<>();
        grades4.put("Математика", 5);
        grades4.put("Программирование", 5);
        grades4.put("Физика", 4);
        grades4.put("Английский", 5);

        students.addStudent(new Student(
                "Иван",
                "ИВТ-101",
                1,
                grades1
        ));

        students.addStudent(new Student(
                "Анна",
                "ИВТ-102",
                2,
                grades2
        ));

        students.addStudent(new Student(
                "Петр",
                "ИВТ-101",
                1,
                grades3
        ));

        students.addStudent(new Student(
                "Мария",
                "ИВТ-103",
                3,
                grades4
        ));

        System.out.println("\nИсходный список студентов:");

        students.printAllStudents();

        students.removeStudents();

        students.promoteStudents();

        System.out.println("\nПосле удаления и перевода на следующий курс:");

        students.printAllStudents();

        System.out.println("\nСтуденты 2 курса:");

        students.printStudents(students.getStudents(), 2);

        System.out.println("\nВторое задание:");

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иванов", "89123456789");
        phoneBook.add("Петров", "89234567890");
        phoneBook.add("Иванов", "89345678901");
        phoneBook.add("Сидоров", "89456789012");
        phoneBook.add("Иванов", "89567890123");

        System.out.println("\nПоиск Иванова:");
        phoneBook.get("Иванов");

        System.out.println("\nПоиск Петрова:");
        phoneBook.get("Петров");

        System.out.println("\nПоиск Смирнова:");
        phoneBook.get("Смирнов");
    }
}