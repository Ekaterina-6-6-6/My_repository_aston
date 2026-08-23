package org.example;

public class Lesson_3 {

    public static void main(String[] args) {

        Product Samsung = new Product(
                "Samsung S25 Ultra",
                "01.02.2025",
                "Samsung Corp.",
                "Korea",
                5599,
                true
        );

        FiveProducts productsArray = new FiveProducts();

        Park park = new Park();

        System.out.println("Первое задание  :");

        Samsung.printInfo();

        System.out.println("\nВторое задание  :");

        productsArray.printInfo();

        System.out.println("\nТретье задание  :");

        park.printInfo();
    }
}