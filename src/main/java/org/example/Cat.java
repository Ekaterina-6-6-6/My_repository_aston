package org.example;

public class Cat extends Animal {

    private static int catCount = 0;

    private static final int FOOD_REQUIRED = 15;
    private static final int MAX_RUN_DISTANCE = 200;

    private boolean satiety;

    public Cat(String name) {
        super(name);
        catCount++;
        satiety = false;
    }

    @Override
    public void run(int distance) {
        if (distance < 0) {
            System.out.println(name + " не может пробежать отрицательное расстояние.");
        } else if (distance <= MAX_RUN_DISTANCE) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(
                    name + " не может пробежать " + distance +
                            " м. Максимум: " + MAX_RUN_DISTANCE + " м."
            );
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public void eat(Bowl bowl) {
        if (bowl.getFood() >= FOOD_REQUIRED) {
            bowl.decreaseFood(FOOD_REQUIRED);
            satiety = true;

            System.out.println(name + " покушал и теперь сыт.");
        } else {
            System.out.println(
                    name + " не смог покушать — в миске недостаточно еды."
            );
        }
    }

    public boolean isSatiety() {
        return satiety;
    }

    public static int getCatCount() {
        return catCount;
    }
}