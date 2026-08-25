package org.example;

public class Animal {

    protected String name;

    private static int animalCount = 0;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public void run(int distance) {
        System.out.println(name + " пробежал " + distance + " м.");
    }

    public void swim(int distance) {
        System.out.println(name + " проплыл " + distance + " м.");
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    public static class Dog extends Animal {

        private static int dogCount = 0;

        public Dog(String name) {
            super(name);
            dogCount++;
        }

        @Override
        public void run(int distance) {
            if (distance <= 500) {
                System.out.println(name + " пробежал " + distance + " м.");
            } else {
                System.out.println(
                        name + " не может пробежать " + distance +
                                " м. Максимум: 500 м."
                );
            }
        }

        @Override
        public void swim(int distance) {
            if (distance <= 10) {
                System.out.println(name + " проплыл " + distance + " м.");
            } else {
                System.out.println(
                        name + " не может проплыть " + distance +
                                " м. Максимум: 10 м."
                );
            }
        }

        public static int getDogCount() {
            return dogCount;
        }
    }

    public static class Cat extends Animal {

        private static int catCount = 0;

        private boolean satiety = false;

        private static final int FOOD_REQUIRED = 15;

        public Cat(String name) {
            super(name);
            catCount++;
        }

        @Override
        public void run(int distance) {
            if (distance <= 200) {
                System.out.println(name + " пробежал " + distance + " м.");
            } else {
                System.out.println(
                        name + " не может пробежать " + distance +
                                " м. Максимум: 200 м."
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

                System.out.println(
                        name + " покушал и теперь сыт."
                );
            } else {
                System.out.println(
                        name + " не смог покушать — " +
                                "в миске недостаточно еды."
                );
            }
        }

        public boolean isSatiety() {
            return satiety;
        }

        public static int getCatCount() {
            return catCount;
        }

        public static class Bowl {

            private int food;

            public Bowl(int food) {
                if (food < 0) {
                    this.food = 0;
                } else {
                    this.food = food;
                }
            }

            public int getFood() {
                return food;
            }

            public void addFood(int amount) {
                if (amount > 0) {
                    food += amount;
                }
            }

            public void decreaseFood(int amount) {
                if (amount > 0 && amount <= food) {
                    food -= amount;
                }
            }
        }
    }
}