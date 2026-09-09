package org.example;

public class Lesson_4 {

    public static void main(String[] args) {

        Dog dogBobik = new Dog("Бобик");
        Dog dogSharik = new Dog("Шарик");

        Cat catMurzik = new Cat("Мурзик");
        Cat catBarsik = new Cat("Барсик");
        Cat catVasya = new Cat("Вася");

        System.out.println("===== ЖИВОТНЫЕ =====");

        System.out.println("\nСобаки бегают:");

        dogBobik.run(150);
        dogSharik.run(435);
        dogBobik.run(500);
        dogBobik.run(600);

        System.out.println("\nСобаки плавают:");

        dogBobik.swim(5);
        dogBobik.swim(10);
        dogSharik.swim(20);

        System.out.println("\nКоты бегают:");

        catMurzik.run(100);
        catBarsik.run(150);
        catVasya.run(200);
        catBarsik.run(400);

        System.out.println("\nКоты плавают:");

        catMurzik.swim(10);
        catVasya.swim(20);

        System.out.println("\nКормление котов");

        Bowl bowl = new Bowl(44);

        Cat[] cats = {
                catMurzik,
                catBarsik,
                catVasya
        };

        for (Cat cat : cats) {
            cat.eat(bowl);
        }

        System.out.println("\nСытость котов:");

        for (Cat cat : cats) {
            System.out.println(
                    cat.name + " сыт: " +
                            (cat.isSatiety() ? "Да" : "Нет")
            );
        }

        System.out.println(
                "\nЕды в миске осталось: " +
                        bowl.getFood()
        );

        bowl.addFood(15);

        System.out.println(
                "После добавления еды в миске: " +
                        bowl.getFood()
        );

        System.out.println("\nПодсчёт животных");

        System.out.println(
                "Всего животных: " +
                        Animal.getAnimalCount()
        );

        System.out.println(
                "Собак: " +
                        Dog.getDogCount()
        );

        System.out.println(
                "Котов: " +
                        Cat.getCatCount()
        );

        System.out.println("\nГеометрия");

        Circle circle = new Circle(
                5,
                "Красный",
                "Чёрный"
        );

        Rectangle rectangle = new Rectangle(
                6,
                23,
                "Синий",
                "Белый"
        );

        Triangle triangle = new Triangle(
                3,
                4,
                5,
                "Зелёный",
                "Чёрный"
        );

        System.out.println("\nКруг:");

        printFigureInfo(circle);

        System.out.println("\nПрямоугольник:");

        printFigureInfo(rectangle);

        System.out.println("\nТреугольник:");

        printFigureInfo(triangle);
    }

    private static void printFigureInfo(Geometry figure) {

        System.out.println(
                "Периметр: " +
                        figure.getPerimeter()
        );

        System.out.println(
                "Площадь: " +
                        figure.getArea()
        );

        System.out.println(
                "Цвет фона: " +
                        figure.getFillColor()
        );

        System.out.println(
                "Цвет границ: " +
                        figure.getBorderColor()
        );
    }
}