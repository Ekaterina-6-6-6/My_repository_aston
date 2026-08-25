package org.example;

public class Lesson_4 {

    public static void main(String[] args) {

        Animal.Dog dogBobik = new Animal.Dog("Бобик");
        Animal.Dog dogSharik = new Animal.Dog("Шарик");

        Animal.Cat catMurzik = new Animal.Cat("Мурзик");
        Animal.Cat catBarsik = new Animal.Cat("Барсик");
        Animal.Cat catVasya = new Animal.Cat("Вася");

        System.out.println("Животные");

        System.out.println("\nСобаки бегают");

        System.out.println();

        dogBobik.run(0);
        dogSharik.run(435);
        dogBobik.run(500);
        dogBobik.run(600);

        System.out.println("\nСобаки плавают");

        System.out.println();

        dogBobik.swim(0);
        dogBobik.swim(5);
        dogBobik.swim(10);
        dogSharik.swim(20);

        System.out.println("\nКоты бегают");

        System.out.println();

        catMurzik.run(0);
        catBarsik.run(150);
        catVasya.run(200);
        catBarsik.run(400);

        System.out.println("\nКоты плавают");

        System.out.println();

        catMurzik.swim(0);
        catVasya.swim(10);

        System.out.println("\nКоты кушют");

        System.out.println();

        Animal.Cat.Bowl bowl = new Animal.Cat.Bowl(44);

        Animal.Cat[] cats = {
                catMurzik,
                catBarsik,
                catVasya
        };

        for (Animal.Cat cat : cats) {
            cat.eat(bowl);
        }

        System.out.println();

        for (Animal.Cat cat : cats) {
            System.out.println(
                    cat.name + " сыт: " +
                            (cat.isSatiety() ? "Да" : "Нет")
            );
        }

        bowl.addFood(15);

        System.out.println(
                "\nПосле добавления еды в миске: " +
                        bowl.getFood()
        );

        System.out.println(
                "\nВсего животных: " +
                        Animal.getAnimalCount()
        );

        System.out.println(
                "Собак: " +
                        Animal.Dog.getDogCount()
        );

        System.out.println(
                "Котов: " +
                        Animal.Cat.getCatCount()
        );

        System.out.println("\nГеометрические фигуры");

        Circle circle = new Circle(
                5,
                "Красный",
                "Черный"
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
                "Зеленый",
                "Черный"
        );

        System.out.println("\nКруг:");

        System.out.println(
                "Периметр: " +
                        circle.getPerimeter()
        );

        System.out.println(
                "Площадь: " +
                        circle.getArea()
        );

        System.out.println(
                "Цвет фона: " +
                        circle.getFillColor()
        );

        System.out.println(
                "Цвет границ: " +
                        circle.getBorderColor()
        );

        System.out.println("\nПрямоугольник:");

        System.out.println(
                "Периметр: " +
                        rectangle.getPerimeter()
        );

        System.out.println(
                "Площадь: " +
                        rectangle.getArea()
        );

        System.out.println(
                "Цвет фона: " +
                        rectangle.getFillColor()
        );

        System.out.println(
                "Цвет границ: " +
                        rectangle.getBorderColor()
        );

        System.out.println("\nТреугольник:");

        System.out.println(
                "Периметр: " +
                        triangle.getPerimeter()
        );

        System.out.println(
                "Площадь: " +
                        triangle.getArea()
        );

        System.out.println(
                "Цвет фона: " +
                        triangle.getFillColor()
        );

        System.out.println(
                "Цвет границ: " +
                        triangle.getBorderColor()
        );
    }
}