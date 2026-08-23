package org.example;

public class FiveProducts {

    Product[] productsArray = new Product[5];

    public FiveProducts() {

        productsArray[0] = new Product(
                "Samsung S25 Ultra",
                "01.02.2025",
                "Samsung Corp.",
                "Korea",
                5599,
                true
        );

        productsArray[1] = new Product(
                "iPhone 16 Pro",
                "15.09.2024",
                "Apple",
                "USA",
                4999,
                false
        );

        productsArray[2] = new Product(
                "Xiaomi 15",
                "20.10.2024",
                "Xiaomi",
                "China",
                2999,
                true
        );

        productsArray[3] = new Product(
                "MacBook Air M4",
                "10.03.2025",
                "Apple",
                "USA",
                6499,
                false
        );

        productsArray[4] = new Product(
                "Sony PlayStation 5",
                "05.11.2024",
                "Sony",
                "Japan",
                2499,
                true
        );
    }

    public void printInfo() {

        for (int i = 0; i < productsArray.length; i++) {
            System.out.println("\nПродукт №" + (i + 1));
            productsArray[i].printInfo();
        }
    }
}