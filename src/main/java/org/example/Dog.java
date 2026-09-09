package org.example;

public class Dog extends Animal {

    private static int dogCount = 0;

    private static final int MAX_RUN_DISTANCE = 500;
    private static final int MAX_SWIM_DISTANCE = 10;

    public Dog(String name) {
        super(name);
        dogCount++;
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
        if (distance < 0) {
            System.out.println(name + " не может проплыть отрицательное расстояние.");
        } else if (distance <= MAX_SWIM_DISTANCE) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(
                    name + " не может проплыть " + distance +
                            " м. Максимум: " + MAX_SWIM_DISTANCE + " м."
            );
        }
    }

    public static int getDogCount() {
        return dogCount;
    }
}